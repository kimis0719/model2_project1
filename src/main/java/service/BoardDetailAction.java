package service;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dao.CateDAO;
import dao.ReplyDAO;
import dto.BoardDTO;
import dto.CateDTO;
import dto.ReplyDTO;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");

		System.out.println("BoardDetailAction");
		
		// 글내용 상세정보 구해오기
		int currentCate = Integer.parseInt(request.getParameter("cate_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(currentCate+" "+ board_num+" "+page);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.readCountUpdate(currentCate, board_num);					// 조회수 증가
		BoardDTO board = dao.getBoardDetail(currentCate, board_num);	// 상세정보 구하기

		
		// 글 내용에서 줄 바꿈
		String content = board.getBoard_content().replace("\n", "<br>");
						
		
		
		// 글 상제정보 공유설정
		request.setAttribute("content", content);
		request.setAttribute("board", board);
		request.setAttribute("page", page);

		int limit = 10; // 한화면에 출력할 데이터 갯수

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		// page = 1 : startRo=1, endRow=10
		// page = 2 : startRo=11, endRow=20
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;

		int listcount = dao.getCount(currentCate); // 총 데이터 갯수 구해오는 그룹함수
		System.out.println("listcount : " + listcount);

		List<BoardDTO> boardlist = dao.getList(startRow, endRow, currentCate);
		System.out.println("boardlist : " + boardlist);

		// 총 페이지
		int pageCount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);

		int startPage = ((page - 1) / 10) * limit + 1; // 1, 11, 21, ...
		int endPage = startPage + 10 - 1; // 10, 20, 30, ...

		if (endPage > pageCount)
			endPage = pageCount;

		request.setAttribute("currentCate", currentCate);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 댓글 정보 가져오기
		ReplyDAO ldao = ReplyDAO.getInstance();
		List<ReplyDTO> replylist = ldao.getReplyListAction(board_num);
		System.out.println("replylist : " + replylist);
		
		request.setAttribute("replylist", replylist);
		
		// 게시판 정보를 받을 리스트 생성
		List<CateDTO> catelist = new ArrayList<CateDTO>();

		// cate_code 1 ~ 5 까지의 게시판 정보 가져오기
		for (int i = 1; i <= 5; i++) {
			CateDAO catedao = CateDAO.getInstance();
			int cate = i;

			// 게시판정보(게시판 번호, 카테고리번호, 게시판 이름) 받아올 리스트 생성
			List<CateDTO> list = catedao.getcatelist(cate);

			// 게시판정보 catelist에 추가
			catelist.addAll(list);
		}
		// 게시판 이름을 구함
		CateDAO caten = CateDAO.getInstance();
		String cateName = caten.getBoardName(currentCate);
		
		System.out.println("catelist : " + catelist);
		System.out.println("cateName : " + cateName);
		// 게시판정보 공유설정
		request.setAttribute("catelist", catelist);
		request.setAttribute("cateName", cateName);

		ActionForward forward = new ActionForward();

		// request 객체로 공유를 한 경우에는 dispatcher 방식으로 포워딩이 되어야,
		// view 페이지에서 공유한 값에 접근이 가능하다.
		forward.setRedirect(false); // dispatcher 방식으로 포워딩
		forward.setPath("/boardDetail.board"); 
		
		return forward;

	}

}
