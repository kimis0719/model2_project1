package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class BoardGoodAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardGoodAction");

		request.setCharacterEncoding("utf-8");

		// 좋아요를 누른 글의 정보를 가져옴
		int currentCate = Integer.parseInt(request.getParameter("cate_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(currentCate + " " + board_num + " " + page);

		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.BoardGoodAction(board_num);
		if (result == 1) 
			System.out.println("게시글 추천 성공");

		request.setAttribute("currentCate", currentCate);
		request.setAttribute("board_num", board_num);
		request.setAttribute("page", page);

		ActionForward forward = new ActionForward();

		forward.setRedirect(false); // dispatcher 방식으로 포워딩
		forward.setPath("/BoardDetailAction.board?cate_num=" + currentCate + "&board_num=" + board_num + "&page=" + page);

		return forward;

	}

}
