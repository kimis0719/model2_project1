package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("BoardDeleteAction");
		
		response.setContentType("text/html; charset=UTF-8");  // 메세지 박스상 한글값이 깨지지않게 해줌
		request.setCharacterEncoding("UTF-8");  // 한글값이 post로 밸류값에 전달될때 깨지지않게 해줌
		
		PrintWriter out = response.getWriter();
		int cate_num = Integer.parseInt(request.getParameter("cate_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		String path = request.getRealPath("");
		System.out.println("path:"+path);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO old = dao.getBoardDetail(cate_num, board_num);  // 상세정보 구하기
//		BoardDTO old = dao.getBoardDetail(0, board_num);  // 상세정보 구하기
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.do?page="+page); // 경로를 제대로 못찾을때는 /앞에 .추가
		
		return forward;
		
	}
	
}
