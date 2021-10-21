package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import dto.MemberDTO;
import dto.QnaDTO;
import util.Pager;

public class QnaService {

	//글 목록
	public ActionForward qnaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaList 들어왔냐");
		
		ActionForward actionForward = new ActionForward();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");

		//페이징 처리
		Pager pager = new Pager();
		System.out.println("pager의 현재페이지 : "+pager.getCurPage());
		System.out.println("request의 현재페이지 : "+request.getParameter("curPage"));
		if (request.getParameter("curPage") != null) {
			pager.setCurPage(Integer.parseInt(request.getParameter("curPage")));
		}
		System.out.println(pager.getCurPage());

		pager.makeRow();
		pager.makePage(qnaDAO.qnaCount());

		List<QnaDTO> qnaList = qnaDAO.qnaList(pager);
		/* System.out.println("qnaList:" + qnaList); */

		request.setAttribute("lists", qnaList);
		request.setAttribute("pager", pager);
		request.setAttribute("member", memberDTO);

		actionForward.setRedirect(true);
		actionForward.setPath("./qnaList.jsp");

		return actionForward;
	}//qnaList end
	
	//글 작성폼
	public ActionForward writeForm(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaWriteForm 들어왔냐");
		
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}//writeForm end
	
	//글 작성
	public ActionForward write(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaWrite 들어왔냐");
		
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}//write end
	
	//글 수정폼
	public ActionForward updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaUpdateForm 들어왔냐");
		
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}//updateForm end
	
	//글 수정
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaUpdate 들어왔냐");
		
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}//update end
	
	//글 삭제
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaDelete 들어왔냐");
		
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}//delete end
}
