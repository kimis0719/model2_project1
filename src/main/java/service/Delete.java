package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.memberDAO;
import dto.memberDTO;

public class Delete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Delete");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		memberDAO dao = memberDAO.getinstance();
		memberDTO old = dao.getMember(mem_id);
	 
		// 비밀번호 비교
		if(old.getMem_pass().equals(mem_pass)) {  // 비밀번호 일치시
			int result = dao.delete(mem_id);
			if(result == 1) System.out.println("삭제 성공");
			
			session.invalidate();
			
		}else {  								  // 비밀번호 불일치시
			out.println("<script>");
			out.println("alert('비밀번호 불일치');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Loginform.do");
		
		return forward;
		
	}
		

}
