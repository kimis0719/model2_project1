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

		int cate_num = Integer.parseInt(request.getParameter("cate_num"));
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
		
		List<BoardDTO> boardlist = dao.getList(startRow, endRow, cate_num);
		System.out.println("boardlist : "+boardlist);
		
		// 총 페이지
		int pageCount = listcount/limit+((listcount%limit==0) ? 0 : 1);
		
		int startPage = ((page-1)/10) * limit + 1; // 1, 11, 21...
		int endPage = startPage + 10 - 1; // 10, 20, 30...
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("cate_num", cate_num);
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlistcount", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		
		// request 객체로 공유를 한 경우에는 dispatcher 방식으로 포워딩이 되어야,
		// view 페이지에서 공유한 값에 접근이 가능하다.
		forward.setRedirect(false); // dispatcher 방식으로 포워딩
		forward.setPath("./board/boardList.jsp");

		return forward;
	}

}
