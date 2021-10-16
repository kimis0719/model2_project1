package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardListAction");


		int page = 1; 		// 현재 페이지 번호
		int limit = 10;		// 한화면에 출력할 데이터 갯수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// page = 1 : startRo=1, endRow=10
		// page = 2 : startRo=11, endRow=20
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int listcount = dao.getCount();			// 총 데이터 갯수 구해오는 그룹함수
		System.out.println("listcount : " + listcount);
		
		List<BoardDTO> boardlist = dao.getList(startRow, endRow);
		System.out.println("boardlist : "+boardlist);

		ActionForward forward = new ActionForward();
		
		// request 객체로 공유를 한 경우에는 dispatcher 방식으로 포워딩이 되어야,
		// view 페이지에서 공유한 값에 접근이 가능하다.
		forward.setRedirect(false); // dispatcher 방식으로 포워딩
		forward.setPath("./board/boardlist.jsp");

		return forward;
	}

}
