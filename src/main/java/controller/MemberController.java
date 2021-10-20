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
import service.Delete;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String requestURI = request.getRequestURI();  // 현재 프로젝트를 포함한 전체경로 구하기
		String contextpath = request.getContextPath(); // 현재 프로젝트명을 구해옴
		String command = requestURI.substring(contextpath.length());
		
		System.out.println("requestURI:"+requestURI);
		System.out.println("contextpath:"+contextpath);
		System.out.println("command:"+command);
		
		Action action = null; 
		ActionForward forward = null;  // 초기값은 null값이므로 처음에는 포워딩처리하지않음
		// 아래쪽 else if가 한번 실행하면 null값이 아니게되므로 포워딩처리를 하게된다
		
		// 회원 탈퇴폼
		if(command.equals("DeleteMember.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/deleteform.jsp");
			
			//회원 탈퇴
		}else if(command.equals("/Delete.do")){
			try {
				action = new Delete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} // if end
		
		// 포워딩 처리
		if(forward != null) {
			if(forward.isRedirect()) {  // redirect 방식
				response.sendRedirect(forward.getPath());
			}else {						// dispatcher
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
