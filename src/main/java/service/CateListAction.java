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
		
		// 게시판 정보를 받을 리스트 생성
		List<CateDTO> catelist = new ArrayList<CateDTO>();
		
		// cate_code 1 ~ 5 까지의 게시판 정보 가져오기
		for(int i = 1; i <=5; i++) {
			CateDAO dao = CateDAO.getInstance();
			int cate = i;
			
			// 게시판정보(게시판 번호, 카테고리번호, 게시판 이름) 받아올 리스트 생성
			List<CateDTO> list = dao.getcatelist(cate);
			
			// 게시판정보 catelist에 추가
			catelist.addAll(list);
		}
		System.out.println("catelist : "+catelist);
		// 게시판정보 공유설정
		request.setAttribute("catelist", catelist);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("/board/mainPage.jsp");
		
		
		return forward;
	}

}
