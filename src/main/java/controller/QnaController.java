package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ActionForward;
import service.QnaService;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("*.qna")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QnaService qnaService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QnaController() {
		super();
		// TODO Auto-generated constructor stub
		qnaService = new QnaService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String url = request.getServletPath();
		url = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")); // 주소 파싱해서 가져오기

		ActionForward actionForward = null;
		// 글 목록
		if (url.equals("qnaList")) {
			try {
				actionForward = qnaService.qnaList(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * else if (url.equals("qnaSelect")) { actionForward =
			 * qnaService.selectOne(request, response); }
			 */
			// 글 작성 폼
		} else if (url.equals("qnaWriteForm")) {
			try {
				actionForward = qnaService.writeForm(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 글 작성(원문작성)
		} else if (url.equals("qnaWrite")) {
			try {
				actionForward = qnaService.write(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 글 수정폼
		} else if (url.equals("qnaUpdateForm")) {
			try {
				actionForward = qnaService.updateForm(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 글 수정
		} else if (url.equals("qnaUpdate")) {
			try {
				actionForward = qnaService.update(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 글 삭제
		} else if (url.equals("qnaDelete")) {
			try {
				actionForward = qnaService.delete(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 답변 폼
		} else if (url.equals("qnaAnswerForm")) {
			try {
				actionForward = qnaService.answerForm(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 답변
		} else if (url.equals("qnaAnswer")) {
			try {
				actionForward = qnaService.answer(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 답변 수정폼
		} else if (url.equals("qnaAnswerForm")) {
			try {
				actionForward = qnaService.answerUpdateForm(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 답변 수정
		} else if (url.equals("qnaAnswer")) {
			try {
				actionForward = qnaService.answerUpdate(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 답변 삭제
		} else if (url.equals("qnaAnswerDelete")) {
			try {
				actionForward = qnaService.answerDelete(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (actionForward.isRedirect()) { // flag 값이 true-Forward냐 false-Redirect냐에 따라 결정
			System.out.println("Forward");
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		} else {
			System.out.println("Redirect");
			response.sendRedirect(actionForward.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST");
		
		doGet(request, response);
	}

}
