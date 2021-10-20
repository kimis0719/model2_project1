package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.memberDAO;

public class Idcheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Idcheck");
		
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();  // 브라우저 출력을 위한 out객체 생성
		
		// request 객체는 컨트롤러 클래스에서 2번전달을 받아야만 사용가능하다
		String mem_id = request.getParameter("mem_id");
		System.out.println("mem_id:"+mem_id);
		
		memberDAO dao = memberDAO.getinstance();
		int result = dao.idcheck(mem_id);  // dao클래스 내에 Idcheck메소드를 생성하여 ID중복검사에 사용
		System.out.println("result:"+result);  // 1출력 : 중복 ID / -1출력 : 사용가능한 ID

		out.println(result);
		
		return null;
	}

}
