package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateMember implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("UpdateMember");
		HttpSession session = request.getSession(); 
		String mem_id = (String)session.getAttribute("mem_id"); // 세션 객체를 사용하여 id값을 가져옴
		// 저장된 value값이 String형 데이터이기 때문에 String클래스로 다운캐스팅해야함
		
		MemberDAO dao = MemberDAO.getInstance(); 
		MemberDTO member = dao.getMember(mem_id); // 1명의 상세정보를 구해옴
		System.out.println("수정폼:"+member);
		
		// 공유 설정
		request.setAttribute("member", member);
		
		ActionForward forward = new ActionForward();
		
		// request객체로 공유가 된 경우에는 dispatcher방식으로 포워딩해야 view페이지에서 공유한 값을 사용할 수 있다
		forward.setRedirect(false);
		forward.setPath("/member/updateform.jsp");
		
		return forward;
	}

}
