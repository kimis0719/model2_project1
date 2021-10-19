package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDelete");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board-num"));
		String page = request. getParameter("page");
		String mem_pass = request.getParameter("mem_pass");
		
		String path = request.getRealPath("boardupload");
		System.out.println("path:" + path);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO old = dao.getDetil("mem_pass");
		
		// 비번 비교
		if(old.getmem_pass().equals(mem_pass)) {	// 비번 일치시
			int result = dao.delete(mem_pass);		// 글삭제
			if(result == 1) System.out.println("삭제 성공");
			
			
		}else {	// 비번 불일치시
			out.println("<script>");
			out.println("alert('비번이 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.do?page="+page);
		
		return forward;
	}

}
