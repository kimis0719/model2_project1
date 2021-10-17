package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CateDAO;
import dto.CateDTO;

public class CateListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CateListAction");
		
		List<CateDTO> catelist = new ArrayList<CateDTO>();
		
		
		for(int i = 1; i <=5; i++) {
			CateDAO dao = CateDAO.getInstance();
			int cate = i;
			
			List<CateDTO> list = dao.getcatelist(cate);
			System.out.println("catelist : "+catelist);
			
			catelist.addAll(list);
		}
		request.setAttribute("catelist", catelist);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("./board/mainPage.jsp");
		
		
		return forward;
	}

}
