package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class Update implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Update");
		
		int mem_num = Integer.parseInt(request.getParameter("mem_num"));
		
		System.out.println("mem_num : " + mem_num);
		
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("mem_num : " + mem_num);
		request.setCharacterEncoding("UTF-8");
		System.out.println("mem_num : " + mem_num);
		
		// 출력을 위한 out객체 생성
		PrintWriter out = response.getWriter();
		
		MemberDTO member = new MemberDTO(); // DTO 객체 생성
				
		  member.setMem_num(Integer.parseInt(request.getParameter("mem_num")));
		  member.setMem_id(request.getParameter("mem_id"));
		  member.setMem_nick(request.getParameter("mem_nick"));
		  member.setMem_pass(request.getParameter("mem_pass"));
		  member.setMem_email(request.getParameter("mem_email"));
		  member.setMem_img(request.getParameter("mem_img"));
		  member.setMem_phone(request.getParameter("mem_phone"));
//		  member.setMem_up_memnum(Integer.parseInt(request.getParameter("mem_up_memnum")));
		  member.setMem_yn(request.getParameter("mem_yn"));
//		  member.setMem_grade(Integer.parseInt(request.getParameter("mem_grade")));
		 
		 
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO old = dao.getMember(member.getMem_id());
		
		// 비밀번호 비교
		
		if(old.getMem_pass().equals(member.getMem_pass())) {  // 비밀번호 일치시
			int result = dao.update(member);  // 회원 정보 수정
			if(result == 1) System.out.println("수정 성공");
		}else {												  // 비밀번호 불일치시
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다!');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/mypage.jsp");
		
		return forward;
	}

}
