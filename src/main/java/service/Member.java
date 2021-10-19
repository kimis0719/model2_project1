//회원가입
package service;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import dao.memberDAO;
import dao.memberDAO;
import model.memberDTO;

public class Member implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Member");
		
		request.setCharacterEncoding("utf-8");
		
		memberDTO member = new memberDTO();
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_nick(request.getParameter("mem_nick"));
		member.setMem_pass(request.getParameter("mem_pass"));
		member.setMem_email(request.getParameter("mem_email"));
		member.setMem_phone(request.getParameter("mem_phone"));
		member.setMem_img(request.getParameter("mem_img"));
		
		
		
		memberDAO dao =memberDAO.getInstance();
		int result =dao.insert(member);
		if(result == 1) {
			System.out.println("회원 가입 성공");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/login.jsp");
		
		return forward;
	}
	

}
