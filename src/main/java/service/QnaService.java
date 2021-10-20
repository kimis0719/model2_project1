package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import dto.QnaDTO;
import util.Pager;

public class QnaService {

	//글 목록
	public ActionForward qnaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaService");
		ActionForward actionForward = new ActionForward();
		QnaDAO qnaDAO = QnaDAO.getInstance();

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

		actionForward.setRedirect(true);
		actionForward.setPath("./qna/qnaList.jsp");

		return actionForward;
	}
	
	public ActionForward write(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}
	
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}
	
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionForward actionForward = new ActionForward();
		return actionForward;
	}
}
