package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CateDAO;
import dto.CateDTO;

public class CateListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CateListAction");
		
		int cate = 1;
		
		CateDAO dao = CateDAO.getInstance();
		
		List<CateDTO> catelist = dao.getcatelist(cate);
		System.out.println("catelist : "+catelist);
		
		request.setAttribute("catelist", catelist);
		request.setAttribute("cate", cate);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./board/mainPage.jsp");
		
		
		return forward;
	}

}
