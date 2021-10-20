package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.memberDAO;

public class Login implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Login");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		memberDAO dao = memberDAO.getinstance();
		int result = dao.memberAuth(mem_id, mem_pass);
		if(result == 1)System.out.println("회원 인증 성공");
		
		if(result ==1) {	// 회원 인증 성공시
			session.setAttribute(mem_id, mem_pass);  // 세션 공유
		}else {				// 회원 인증 실패시
			out.println("<script>");
			out.println("alert('회원인증 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();

			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/main.jsp");
		
		return forward;
		
	}

}
