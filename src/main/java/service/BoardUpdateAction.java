package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.MemberDTO;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardUpdateAction 왔다");
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int cate_num = Integer.parseInt(request.getParameter("cate_num"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.getBoardDetail(cate_num, board_num);
		
		request.setAttribute("board", boardDTO);
		request.setAttribute("member", memberDTO);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 	// dispatcher 방식으로 포워딩
		forward.setPath("./board/boardUpdate.jsp"); // 글 작성폼
		
		return forward;
	}
}