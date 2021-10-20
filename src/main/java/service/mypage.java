package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.memberDAO;
import dto.memberDTO;

public class mypage implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("mypage");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String mem_id = (String)session.getAttribute("mem_id");
		
		memberDAO dao = memberDAO.getinstance();
		memberDTO member = dao.getMember(mem_id);
		System.out.println("마이페이지:"+member);
		
		request.setAttribute("member", member);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/updateform.jsp");
		
		return forward;
	}
	
	

}
