//로그인(회원인증)
package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class Login implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Login");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
	
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String mem_id =request.getParameter("mem_id");
		String mem_pass =request.getParameter("mem_pass");
		
		MemberDAO dao =MemberDAO.getInstance();
		int result = dao.memberAuth(mem_id, mem_pass);	//회원인증
		if(result == 1)System.out.println("회원 인증 성공");
		
		if(result ==1) {		//회원 인증 성공
			session.setAttribute("mem_id", mem_id);		//세션 공유 설정
		}else {					//회원 인증 실패
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/mainpage.jsp");
		
		return forward;
	}

}
