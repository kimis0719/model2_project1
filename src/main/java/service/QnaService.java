package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import dto.QnaDTO;
import util.Pager;

public class QnaService {

	public ActionForward qnaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaService");
		ActionForward actionForward = new ActionForward();
		QnaDAO qnaDAO = QnaDAO.getInstance();

		Pager pager = new Pager();
		System.out.println(pager.getCurPage());
		System.out.println(request.getParameter("curPage"));
		if (request.getParameter("curPage") != null) {
			pager.setCurPage(Integer.parseInt(request.getParameter("curPage")));
			System.out.println(request.getParameter("curPage"));
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
}
