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
import service.BoardCountOrderListAction;
import service.BoardGoodOrderListAction;
import service.BoardListAction;
import service.CateListAction;

/**
 * Servlet implementation class board_controller
 */

@WebServlet("*.board")
public class boardcontroller extends HttpServlet {
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

		// 카테고리별 게시판 정보 출력
		if (command.equals("/CateListAction.board")) {
			try {
				action = new CateListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		// 게시판별 목록 출력
		}else if (command.equals("/BoardListAction.board")) {
			try {
				action = new BoardListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		// 정렬 : 게시판별 조회수로 정렬한 목록 출력
		}else if (command.equals("/BoardCountOrderListAction.board")) {
			try {
				action = new BoardCountOrderListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// 정렬 : 게시판별 추천순으로 정렬한 목록 출력
		}else if (command.equals("/BoardGoodOrderListAction.board")) {
			try {
				action = new BoardGoodOrderListAction();
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
