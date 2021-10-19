package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;
import service.ActionForward;
import service.Idcheck;
import service.Login;
import service.Member;

/**
 * Servlet implementation class board_controller
 */
@WebServlet("*.do")
public class membercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doGet(), doPost() 메소드에서 공통적인 작업을 처리하는 메소드
	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI"+requestURI);
		System.out.println("contextPath"+contextPath);
		System.out.println("command"+command);
		
		Action action = null;
		ActionForward forward = null;
		
		//회원 가입
		if(command.equals("/Member.do")) {
			try {
				action = new Member();
				forward =action.execute(request,response);
				}catch(Exception e) {
					e.printStackTrace();
				}
					
			//ID중복 검사(ajax)	
		}else if(command.equals("/Idcheck.do")) {
			try {
				action = new Idcheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
					
		//회원 가입 폼
		}else if(command.contentEquals("/Join.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/join.jsp");
			
					
		//로그인(회원인증)	
		}else if(command.equals("/Login.do")) {
			try {
				action = new Login();
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
					
		//로그인 폼	
		}else if(command.equals("/Login.do")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/login.jsp");
		
		//로그아웃	
		}else if(command.equals("/Logout.do")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/logout.jsp");	
	
		}//임시로 박아둔거
		
			//회원가입 이메일인증
/*		}else if(command.equals("/.do")) {
			
			try {
				action = new ;
				forword = action.execute(request, response);		
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		  //포워딩처리 if(forward != null) { if(forward.isRedirect()) { // redirect 방식으로 포워딩
		  /*response.sendRedirect(forward.getPath()); }else { // dispatcher 방식으로 포워딩
		  RequestDispatcher dispatcher =
		  request.getRequestDispatcher(forward.getPath()); dispatcher.forward(request,
		  response); } }*/
		 
	} // doProcess() end

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");

		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");

		doProcess(request, response);
	}

}
