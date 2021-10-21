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
import service.BoardDetailAction;
import service.BoardListAction;
import service.BoardOrderListAction;
import service.BoardSearchAction;
import service.CateListAction;

/**
 * Servlet implementation class board_controller
 */

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doGet(), doPost() 메소드에서 공통적인 작업을 처리하는 메소드
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI" + requestURI);
		System.out.println("contextPath" + contextPath);
		System.out.println("command" + command);

		Action action = null;
		ActionForward forward = null;


		// 메뉴 : 메인페이지로 이동 - 카테고리출력
		if (command.equals("/MainPageAction.board")) {
			try {
				action = new CateListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		// 글목록 : 게시판별 목록 출력
		}else if (command.equals("/BoardListAction.board")) {
			try {
				action = new BoardListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		// 글목록 : 정렬 - 게시판별 정렬조건으로 정렬한 목록 출력
		}else if (command.equals("/BoardOrderListAction.board")) {
			try {
				action = new BoardOrderListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		// 글목록 : 검색 - 게시판별 검색결과 출력
		}else if (command.equals("/BoardSearchAction.board")) {
			try {
				action = new BoardSearchAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// 글상세 : 글 상세페이지 출력
		}else if (command.equals("/BoardDetailAction.board")) {
			try {
				action = new BoardDetailAction();
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if(command.equals("BoardGoodAction")){
			try {
				action = new BoardDetailAction();
				forward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 포워딩처리
		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

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