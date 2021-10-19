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
		pager.makeRow();
		pager.makePage(qnaDAO.qnaCount());
		
		List<QnaDTO> qnaList = qnaDAO.qnaList(pager);
		
		request.setAttribute("lists", qnaList);
		request.setAttribute("pager", pager);
		
		actionForward.setRedirect(false);
		actionForward.setPath("./qna/qnaList.jsp");
		
		return actionForward;
	}
}
