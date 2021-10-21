package service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.BoardFileDTO;
import dto.MemberDTO;

public class BoardWrite implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("BoardWrite");
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		String path = request.getRealPath("boardupload");
		System.out.println("path:"+ path);
		
		int size = 10 * 1024 * 1024;		// 10MB
		
		MultipartRequest multi =
			new MultipartRequest(request,
								 path,		// 업로드 디렉토리
								 size,		// 업로드 파일크기(1MB)
								 "utf-8",   // 한글 인코딩
			new DefaultFileRenamePolicy()); // 중복파일 문제 해결
		
		BoardDTO board = new BoardDTO();
		System.out.println("multi.boardtitle: "+multi.getParameter("board_title"));
		board.setBoard_title(multi.getParameter("board_title"));
		board.setBoard_content(multi.getParameter("board_content"));
		board.setBoard_memnum(memberDTO.getMem_num());
		board.setBoard_nick(multi.getParameter("board_nick"));
		System.out.println("multi.catenum: "+multi.getParameter("cate_num"));
		board.setCate_num(Integer.parseInt(multi.getParameter("cate_num")));
		
		List<BoardFileDTO> boardFileDTOs = new ArrayList<BoardFileDTO>();
		
		Enumeration e = multi.getFileNames();
		while(e.hasMoreElements()) {
			String n = (String)e.nextElement();
			System.out.println(n);
			BoardFileDTO boarFileDTO = new BoardFileDTO();
			boarFileDTO.setBoard_num(board.getBoard_num());
			boarFileDTO.setFile_fName(multi.getFilesystemName(n));
			boarFileDTO.setFile_oName(multi.getOriginalFileName(n));
			
			boardFileDTOs.add(boarFileDTO);
		}
		
//		if(boardFileDTOs.size() > 0) {
//			
//		}
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.insert(board);
		if(result == 1) System.out.println("글작성 성공");
		
//		System.out.println("board.cate_num : "+board.getCate_num());
//		request.setAttribute("cate_num", board.getCate_num());
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.board?cate_num="+multi.getParameter("cate_num"));
		
		return forward;
	}
}
