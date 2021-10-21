package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.MemberDTO;

public class BoardDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDelete 왔다");
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		String path = request.getRealPath("boardupload");
		System.out.println("path:" + path);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoard_num(board_num);
		System.out.println("memberDTO.memnum: "+memberDTO.getMem_num());
		boardDTO.setBoard_up_memnum(memberDTO.getMem_num());
		
		int result = boardDAO.delete(boardDTO);
		if(result == 1) System.out.println("삭제 성공");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.board?cate_num="+request.getParameter("cate_num"));
		
		return forward;
	}
}
