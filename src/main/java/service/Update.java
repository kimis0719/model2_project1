package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class Update implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Update");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// 출력을 위한 out객체 생성
		PrintWriter out = response.getWriter();
		
		MemberDTO member = new MemberDTO(); // DTO 객체 생성
		/*
		 * member.setMem_num(request.getParameter("mem_num"));
		 * member.setMem_id(request.getParameter("mem_id"));
		 * member.setMem_nick(request.getParameter("mem_nick"));
		 * member.setMem_pass(request.getParameter("mem_pass"));
		 * member.setMem_email(request.getParameter("mem_email"));
		 * member.setMem_img(request.getParameter("mem_img"));
		 * member.setMem_phone(request.getParameter("mem_phone"));
		 * member.setMem_up_memnum(request.getParameter("mem_up_memnum"));
		 * member.setMem_up_date(request.getParameter("mem_up_date"));
		 * member.setMem_yn(request.getParameter("mem_yn"));
		 * member.setMem_grade(request.getParameter("mem_grade"));
		 */
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO old = dao.getMember(member.getMem_id());
		
		
		return null;
	}

}
