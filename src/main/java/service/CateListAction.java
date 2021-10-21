package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dao.CateDAO;
import dto.BoardDTO;
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
			System.out.println("catelist"+i+" : "+catelist.get(i-1));
		}
		
		int page = 1;
		
		BoardDAO bdao = BoardDAO.getInstance();
		
		
		List<BoardDTO> noticelist = bdao.getboardlist(1);
		List<BoardDTO> freelist = bdao.getboardlist(2);
		List<BoardDTO> dailylist = bdao.getboardlist(3);
		List<BoardDTO> sclist = bdao.getboardlist(4);
		List<BoardDTO> bslist = bdao.getboardlist(5);
		List<BoardDTO> d2list = bdao.getboardlist(6);
		List<BoardDTO> ff14list = bdao.getboardlist(7);
		List<BoardDTO> movielist = bdao.getboardlist(8);
		List<BoardDTO> tvlist = bdao.getboardlist(9);
		System.out.println("noticelist:"+ noticelist);
		
		
		// 게시판정보 공유설정
		request.setAttribute("catelist", catelist);
		
		request.setAttribute("noticelist", noticelist);
		request.setAttribute("freelist", freelist);
		request.setAttribute("dailylist", dailylist);
		request.setAttribute("sclist", sclist);
		request.setAttribute("bslist", bslist);
		request.setAttribute("d2list", d2list);
		request.setAttribute("ff14list", ff14list);
		request.setAttribute("movielist", movielist);
		request.setAttribute("tvlist", tvlist);
		request.setAttribute("page", page);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);  // dispatcher 방식으로 포워딩
		forward.setPath("/mainpage.jsp");
		
		
		return forward;
	}

}
