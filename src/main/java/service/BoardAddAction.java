package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardAddAction");
		
		String path = request.getRealPath("boardupload");	// 업로드 할 곳 설정
		System.out.println("path:" + path);
		
		int size = 1024 * 1024 ; // 1MB
		
		MultipartRequest multi = 
				new MultipartRequest(request, 
										path,	// 업로드 디렉토리
										size,	// 업로드 파일 크기
									 "UTF-8",	// 한글 인코딩
				new DefaultFileRenamePolicy());	//중복 문제 해결 
		
		BoardDTO board = new BoardDTO();
		board.setBoard_title(multi.getParameter("board_title"));
		board.setBoard_content(multi.getParameter("board_content"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.insert(board);	// 원문 글작성
		if(result == 1) System.out.println("글작성 성공");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.do");
		
		return forward;
	}

}
