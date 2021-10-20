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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String url = request.getServletPath();
		url = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".")); //주소 파싱해서 가져오기
		
		ActionForward actionForward = null;
		if(url.equals("qnaList")) {
			try {
				actionForward = qnaService.qnaList(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} /*
			 * else if(url.equals("qnaSelect")) { actionForward =
			 * qnaService.selectOne(request, response); } else if(url.equals("qnaWrite")) {
			 * actionForward = qnaService.write(request, response); } else
			 * if(url.equals("qnaUpdate")) { actionForward = qnaService.update(request,
			 * response); }
			 */
		
		if(actionForward.isRedirect()) { //flag 값이 true-Forward냐 false-Redirect냐에 따라 결정
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionForward.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
