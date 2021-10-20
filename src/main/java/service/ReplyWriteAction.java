package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;
import dto.MemberDTO;
import dto.ReplyDTO;

public class ReplyWriteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReplyWriteAction");
		
		MemberDTO member = new MemberDTO();
		
		member = (MemberDTO)request.getSession().getAttribute("member");
		
		
		
		int currentCate = Integer.parseInt(request.getParameter("cate_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(currentCate+" "+ board_num+" "+page);
		
		ReplyDTO reply = new ReplyDTO();
		reply.setRe_writer(member.getMem_nick());
		reply.setRe_content(request.getParameter("re_content"));
		reply.setBoard_num(board_num);
		
		
		ReplyDAO dao = ReplyDAO.getInstance();
		int result = dao.replyWrite(reply);
		if(result == 1) System.out.println("글작성 성공");
		

		ActionForward forward = new ActionForward();

		forward.setRedirect(false); // dispatcher 방식으로 포워딩
		forward.setPath("./BoardDetailAction.board?cate_num=$"+currentCate+"&board_num="+board_num+"&page="+page);
		
		return forward;
	}
}
