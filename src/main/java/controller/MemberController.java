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
import service.Nickcheck;

/**
 * Servlet implementation class board_controller
 */
@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doGet(), doPost() 메소드에서 공통적인 작업을 처리하는 메소드
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI:"+requestURI);
		System.out.println("contextPath:"+contextPath);
		System.out.println("command:"+command);
		
		Action action = null;
		ActionForward forward = null;
		
		//회원 가입
		if(command.equals("/Member.member")) {
			try {
				action = new Member();
				forward = action.execute(request,response);
				}catch(Exception e) {
					e.printStackTrace();
				}
					
			//ID중복 검사(ajax)	
		}else if(command.equals("/Idcheck.member")) {
			try {
				action = new Idcheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		//닉네임 중복검사(ajax)
		}else if(command.equals("/Nickcheck.member")) {
			try {
				action = new Nickcheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
					
		//회원 가입 폼
		}else if(command.contentEquals("/Join.member")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/join.jsp");
			
					
		//로그인(회원인증)	
		}else if(command.equals("/Login.member")) {
			try {
				action = new Login();
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
					
		//로그인 폼	
		}else if(command.equals("/LoginForm.member")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/loginForm.jsp");
			
		
		//로그아웃	
		}else if(command.equals("/Logout.member")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/logout.jsp");	
	
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//포워딩 처리
		if(forward != null) {
			if(forward.isRedirect()) {	//redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			}else {						//dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher =
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

		
	}  // do process end
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("get");
		
		doProcess(request, response);
	}

	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("post");
		
		doProcess(request, response);
	}

}
