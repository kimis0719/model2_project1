package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class FindId implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FindId");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		String mem_nick = request.getParameter("mem_nick");
		String mem_email = request.getParameter("mem_email");

		MemberDAO dao = MemberDAO.getInstance();
		String mem_id = dao.searchId(mem_nick, mem_email);
		if (mem_id != null)
			System.out.println("아이디찾기 성공");		

		if (mem_id != null) { // 아이디 찾기 성공
			request.setAttribute("mem_id",mem_id);
		} else { // 아이디 찾기 실패
			out.println("<script>");
			out.println("alert('잘못된 정보 입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/findidresult.jsp");

		return forward;
	}
}