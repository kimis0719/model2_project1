package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class FindPw implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FindPw");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		String mem_id = request.getParameter("mem_id");
		String mem_nick = request.getParameter("mem_nick");

		MemberDAO dao = MemberDAO.getInstance();
		String mem_pass = dao.searchPw(mem_id, mem_nick);
		System.out.println(mem_pass);
		if (mem_pass != null) {
			System.out.println("비밀번호찾기 성공");		
			request.setAttribute("mem_pass",mem_pass);
	
		} else { // 비밀번호 찾기 실패
			out.println("<script>");
			out.println("alert('잘못된 정보 입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/findpwresult.jsp");

		return forward;
	}
}