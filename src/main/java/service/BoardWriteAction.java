package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dao.CateDAO;
import dto.MemberDTO;

public class BoardWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardWriteAction");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		CateDAO cateDAO = CateDAO.getInstance();
		System.out.println("cate_num: "+request.getParameter("cate_num"));
		
		// 공유 설정
		request.setAttribute("member", memberDTO);
		request.setAttribute("boardName", cateDAO.getCateName(Integer.parseInt(request.getParameter("cate_num"))));
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 	// dispatcher 방식으로 포워딩
		forward.setPath("./board/boardWrite.jsp"); // 글 작성폼
		
		return forward;
	}
}
