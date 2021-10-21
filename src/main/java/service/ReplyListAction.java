package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;
import dto.MemberDTO;
import dto.ReplyDTO;

public class ReplyListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReplyListAction");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		// 일반댓글 : 댓글을 작성한 글 정보를 받아옴
		int currentCate = Integer.parseInt(request.getParameter("cate_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(currentCate+" "+ board_num+" "+page);
		
		String mem_nick = request.getParameter("mem_nick");
		String content = request.getParameter("re_content");
		
		ReplyDTO reply = new ReplyDTO();
		reply.setRe_writer(memberDTO.getMem_nick());
		reply.setRe_content(content);
		reply.setBoard_num(board_num);
		
		
		ReplyDAO dao = ReplyDAO.getInstance();
		int result = dao.replyWrite(reply);
		if(result == 1) System.out.println("글작성 성공");
		
		// 대댓글 : 댓글을 작성한 댓글의 정보를 가져옴
		
		

		ActionForward forward = new ActionForward();

		forward.setRedirect(false); // dispatcher 방식으로 포워딩
		forward.setPath("./BoardDetailAction.board?cate_num=$"+currentCate+"&board_num="+board_num+"&page="+page);
		
		return forward;
	}
}
