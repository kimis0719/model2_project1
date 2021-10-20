//회원가입
package service;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberDAO;
import dto.MemberDTO;
import dao.MemberDAO;

public class Member implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Member");
		
		String path = request.getRealPath("memberupload");
		System.out.println("path:"+ path);
		
		int size = 1024 * 1024;		// 1MB
		
		MultipartRequest multi =
			new MultipartRequest(request,
								 path,		// 업로드 디렉토리
								 size,		// 업로드 파일크기(1MB)
								 "utf-8",   // 한글 인코딩
			new DefaultFileRenamePolicy()); // 중복파일 문제 해결
		
		MemberDTO member = new MemberDTO();
		member.setMem_id(multi.getParameter("mem_id"));
		member.setMem_nick(multi.getParameter("mem_nick"));
		member.setMem_pass(multi.getParameter("mem_pass"));
		member.setMem_email(multi.getParameter("mem_email"));
		member.setMem_phone(multi.getParameter("mem_phone"));
		member.setMem_img(multi.getParameter("mem_img"));
		
		
		
		MemberDAO dao =MemberDAO.getInstance();
		int result =dao.insert(member);
		if(result == 1) {
			System.out.println("회원 가입 성공");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/login.jsp");
		
		return forward;
	}
	

}
