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
import service.BoardDeleteAction;
import service.Delete;
import service.Myboardlist;
import service.Update;
import service.UpdateMember;



/**
 * Servlet implementation class board_controller
 */
@WebServlet("*.Mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

  // doGet(), doPost() 메소드에서 공통적인 작업을 처리하는 메소드
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI"+requestURI);
		System.out.println("contextPath"+contextPath);
		System.out.println("command"+command);
		
		Action action = null;
		ActionForward forward = null;		
		
		
		// 메인페이지 이동
		if(command.equals("/MainPageAction.Mypage")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./mainpage.jsp");
		}
		
		// 회원 탈퇴폼
		if(command.equals("./DeleteMember.Mypage")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/deleteform.jsp");
			
			//회원 탈퇴
		}else if(command.equals("./Delete.Mypage")){
			try {
				action = new Delete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			// 내가작성한글 목록
		}else if(command.equals("/Myboardlist.board")) {
			try {
				action = new Myboardlist();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		
			
		}else if(command.equals("/BoardDeleteAction.board")) {
			try {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("./board/boardDelete.jsp");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			// 글 삭제
		
		}else if(command.equals("")) {
			try {
				action = new BoardDeleteAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			// 회원 가입 수정 폼
		}else if(command.equals("/UpdateMember.Mypage")) {
			try {
				action = new UpdateMember();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			// 회원 수정
			
		}else if(command.equals("/Update.Mypage")) {
			try {
				action = new Update();
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
	} // doProcess() end
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
		System.out.println("post");
		
		doProcess(request, response);
	}

}
