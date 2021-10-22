package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.MemberDTO;

public class BoardUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardUpdate 왔다");
		
		// 업로드할 디렉토리 위치를 구해옴
		String path = request.getRealPath("boardupload");
		System.out.println("path:" + path);
		
		int size = 1024 * 1024;		// 첨부파일의 크기(단위: Byte) : 1MB
		
		// 첨부파일은 MultipartRequest 객체를 생성하면서 업로드가 된다.
		MultipartRequest multi = 
				new MultipartRequest(request,
									 path,		// 업로드할 디렉토리 위치
									 size,      // 첨부파일의 크기 : 1MB
									 "utf-8",   // 인코딩 타입 설정
				new DefaultFileRenamePolicy()); // 중복문제 해결
				
//		int num = Integer.parseInt(multi.getParameter("num"));	
//		String nowpage = multi.getParameter("page");
//		
//		String writer = multi.getParameter("writer");
//		String subject = multi.getParameter("subject");
//		String email = multi.getParameter("email");
//		String content = multi.getParameter("content");
//		String passwd = multi.getParameter("passwd");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		int board_num = Integer.parseInt(multi.getParameter("board_num"));
		System.out.println("board_num: "+board_num);
		int board_up_memnum = Integer.parseInt(multi.getParameter("board_up_memnum"));
		System.out.println("board_up_memnum: "+board_up_memnum);
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoard_num(board_num);
		boardDTO.setBoard_title(multi.getParameter("board_title"));
		boardDTO.setBoard_content(multi.getParameter("board_content"));
		boardDTO.setBoard_nick(multi.getParameter("board_nick"));
		boardDTO.setBoard_up_memnum(board_up_memnum);
//		boardDTO.setCate_num(Integer.parseInt(multi.getParameter("cate_num")));
		
		// 클라이언트가 업로드한 파일명 (오리지널 파일명)
		String upload0 = multi.getOriginalFileName("boardupload");
		
		// 실제 서버에 저장된 파일명
		String upload = multi.getFilesystemName("boardupload");
		
//		board.setUpload(upload);   첨부파일을 수정하지 않으면 NULL값이 저장된다.
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.update(boardDTO);
		if(result == 1) System.out.println("글수정 성공");
//		BoardDataBean old = dao.getContent(num);
//
//		if(upload != null){					// 첨부 파일을 수정한 경우
//			board.setUpload(upload);
//		}else{								// 첨부 파일을 수정하지 않은 경우
//			board.setUpload(old.getUpload());
//		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.board?cate_num="+multi.getParameter("cate_num"));
		
		return forward;
	}
}
