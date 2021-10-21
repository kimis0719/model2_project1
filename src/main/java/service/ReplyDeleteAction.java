package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;

public class ReplyDeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReplyDeleteAction");
		
		request.setCharacterEncoding("utf-8");
		
		// 일반댓글 : 댓글을 작성한 글, 작성한 댓글의 정보를 받아옴.
		int currentCate = Integer.parseInt(request.getParameter("cate_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println("re_num : "+request.getParameter("re_num"));
		int re_num = Integer.parseInt(request.getParameter("re_num"));
		System.out.println(currentCate+" "+ board_num+" "+page+" "+re_num);
		

		ReplyDAO dao = ReplyDAO.getInstance();
		int result = dao.deleteReplyAction(re_num);
		if(result == 1) System.out.println("댓글 삭제 성공");
		
		request.setAttribute("currentCate", currentCate);
		request.setAttribute("board_num", board_num);
		request.setAttribute("page", page);

		ActionForward forward = new ActionForward();

		forward.setRedirect(false); // dispatcher 방식으로 포워딩
		forward.setPath("/BoardDetailAction.board?cate_num="+currentCate+"&board_num="+board_num+"&page="+page);
		
		return forward;
	}
}
