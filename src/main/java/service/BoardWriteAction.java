package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;

public class BoardWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("BoardWriteAction");
		
		String path = request.getRealPath("boardupload");
		System.out.println("path:"+ path);
		
		int size = 1024 * 1024;		// 1MB
		
		MultipartRequest multi =
			new MultipartRequest(request,
								 path,		// 업로드 디렉토리
								 size,		// 업로드 파일크기(1MB)
								 "utf-8",   // 한글 인코딩
			new DefaultFileRenamePolicy()); // 중복파일 문제 해결
		
		
		
		BoardDTO board = new BoardDTO();
		board.setBoard_title(multi.getParameter("board_title"));
		board.setBoard_content(multi.getParameter("board_content"));
		board.setBoard_memnum(multi.getParameter("board_memnum"));
		board.setBoard_nick(multi.getParameter("board_nick"));
		board.setCate_num(multi.getParameter("cate_num"));
		
		return forward;
	}
}
