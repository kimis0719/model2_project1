package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import dto.BoardDTO;
import dto.MemberDTO;
import dto.QnaDTO;
import util.Pager;

public class QnaService {

	//글 목록
	public ActionForward qnaList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QnaList 들어왔냐");
		
		ActionForward actionForward = new ActionForward();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");

		//페이징 처리
		Pager pager = new Pager();
//		System.out.println("pager의 현재페이지 : "+pager.getCurPage());
//		System.out.println("request의 현재페이지 : "+request.getParameter("curPage"));
		if (request.getParameter("curPage") != null) {
			pager.setCurPage(Integer.parseInt(request.getParameter("curPage")));
		}
//		System.out.println(pager.getCurPage());

		pager.makeRow();
		pager.makePage(qnaDAO.qnaCount());

		List<QnaDTO> qnaList = qnaDAO.qnaList(pager);
		/* System.out.println("qnaList:" + qnaList); */

		request.setAttribute("lists", qnaList);
		request.setAttribute("pager", pager);
		request.setAttribute("member", memberDTO);

		actionForward.setRedirect(true);
		actionForward.setPath("./qnaList.jsp");

		return actionForward;
	}//qnaList end
	
	//글 작성폼
	public ActionForward writeForm(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaWriteForm 들어왔냐");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		request.setAttribute("member", memberDTO);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("./qnaWrite.jsp");
		
		return actionForward;
	}//writeForm end
	
	//글 작성
	public ActionForward write(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaWrite 들어왔냐");
		
		QnaDTO qnaDTO = new QnaDTO();
		int memnum = Integer.parseInt(request.getParameter("qna_memnum"));
		System.out.println("memnum: "+ memnum);
		int sec = Integer.parseInt(request.getParameter("qna_sec"));
		System.out.println("sec: "+ sec);
		
		qnaDTO.setQna_title(request.getParameter("qna_title"));
		qnaDTO.setQna_memnum(memnum);
		qnaDTO.setQna_writer(request.getParameter("qna_writer"));
		qnaDTO.setQna_content(request.getParameter("qna_content"));
		qnaDTO.setQna_sec(sec);
		qnaDTO.setQna_step(0);
		qnaDTO.setQna_depth(0);
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		int result = qnaDAO.write(qnaDTO);
		if(result == 1) System.out.println("문의작성 성공");
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("./qnaList.jsp");
		
		return actionForward;
	}//write end
	
	//글 수정폼
	public ActionForward updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaUpdateForm 들어왔냐");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		QnaDTO qnaDTO = qnaDAO.selectOne(qna_num);
		
		request.setAttribute("member", memberDTO);
		request.setAttribute("qna", qnaDTO);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("./qnaUpdate.jsp");
		
		return actionForward;
	}//updateForm end
	
	//글 수정
	public ActionForward update(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaUpdate 들어왔냐");
		
		QnaDTO qnaDTO = new QnaDTO();
		int num = Integer.parseInt(request.getParameter("qna_num"));
		System.out.println("num: "+ num);
		int sec = Integer.parseInt(request.getParameter("qna_sec"));
		System.out.println("sec: "+ sec);
		
		qnaDTO.setQna_num(num);
		qnaDTO.setQna_title(request.getParameter("qna_title"));
		qnaDTO.setQna_content(request.getParameter("qna_content"));
		qnaDTO.setQna_sec(sec);
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		int result = qnaDAO.update(qnaDTO);
		if(result == 1) System.out.println("문의수정 성공");
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("./qnaList.jsp");
		
		return actionForward;
	}//update end
	
	//글 삭제
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaDelete 들어왔냐");
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("./qnaList.jsp");
		
		return actionForward;
	}//delete end
	
	// 답변폼
	public ActionForward answerForm(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaAnswerForm 들어왔냐");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		QnaDTO qnaDTO = qnaDAO.selectOne(qna_num);
		
		request.setAttribute("member", memberDTO);
		request.setAttribute("question", qnaDTO);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("./qnaAnswer.jsp");
		
		return actionForward;
	}//answerForm end
	
	// 답변
	public ActionForward answer(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		System.out.println("QnaAnswer 들어왔냐");
		
		QnaDTO qnaDTO = new QnaDTO();
		int memnum = Integer.parseInt(request.getParameter("qna_memnum"));
		System.out.println("memnum: "+ memnum);
		int sec = Integer.parseInt(request.getParameter("qna_sec"));
		System.out.println("sec: "+ sec);
		int ref = Integer.parseInt(request.getParameter("qna_ref"));
		System.out.println("ref: "+ ref);
		
		qnaDTO.setQna_title(request.getParameter("qna_title"));
		qnaDTO.setQna_memnum(memnum);
		qnaDTO.setQna_writer(request.getParameter("qna_writer"));
		qnaDTO.setQna_content(request.getParameter("qna_content"));
		qnaDTO.setQna_sec(sec);
		qnaDTO.setQna_ref(ref);
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		int result = qnaDAO.answer(qnaDTO);
		if(result == 1) System.out.println("답변작성 성공");
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("./qnaList.jsp");
		
		return actionForward;
	}//answer end
	
	// 답변 수정폼
	public ActionForward answerUpdateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AnswerUpdateForm 들어왔냐");

		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));

		QnaDAO qnaDAO = QnaDAO.getInstance();
		QnaDTO qnaDTO = qnaDAO.selectOne(qna_num);

		request.setAttribute("member", memberDTO);
		request.setAttribute("qna", qnaDTO);

		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("./qnaAnswerUpdate.jsp");

		return actionForward;
	}// updateForm end

	// 답변 수정
	public ActionForward answerUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AnswerUpdate 들어왔냐");

		QnaDTO qnaDTO = new QnaDTO();
		int num = Integer.parseInt(request.getParameter("qna_num"));
		System.out.println("num: " + num);
		int sec = Integer.parseInt(request.getParameter("qna_sec"));
		System.out.println("sec: " + sec);

		qnaDTO.setQna_num(num);
		qnaDTO.setQna_title(request.getParameter("qna_title"));
		qnaDTO.setQna_content(request.getParameter("qna_content"));
		qnaDTO.setQna_sec(sec);

		QnaDAO qnaDAO = QnaDAO.getInstance();
		int result = qnaDAO.update(qnaDTO);
		if (result == 1)
			System.out.println("문의수정 성공");

		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("./qnaList.jsp");

		return actionForward;
	}// update end

	// 답변 삭제
	public ActionForward answerDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AnswerDelete 들어왔냐");

		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("./qnaList.jsp");

		return actionForward;
	}// delete end
}
