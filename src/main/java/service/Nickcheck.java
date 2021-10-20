package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class Nickcheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Nickcheck");
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String mem_nick = request.getParameter("mem_nick");
		System.out.println("닉네임:"+mem_nick);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.nickcheck(mem_nick);
		System.out.println("result:"+result);

		out.println(result);
		
		return null;
	}

}
