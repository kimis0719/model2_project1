package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.MemberDTO;

public class BoardWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardWriteAction");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// 공유 설정
		request.setAttribute("member", memberDTO);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 	// dispatcher 방식으로 포워딩
		forward.setPath("./boardWrite.board"); // 글 작성폼
		
		return forward;
	}
}
