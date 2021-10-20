<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!-- 세션 있는 경우 -->
<c:if test="${sessionScope.mem_id != null}">
	
	<a href="./UpdateMember.do">회원 정보 수정</a> <br><br>
	<a href="./Logout.do">로그아웃</a> <br><br>
	<a href="./DeleteMember.do">회원탈퇴</a> <br><br>
	<a href="./.do">내 글 모음</a> <br><br>
	<a href="./.do">내 추천글 모음</a> <br><br>
	<a href="./.do">내 댓글 모음</a> <br><br>
	<a href="./.do">즐겨찾기</a> <br><br>
	<a href="./.do">관리자에게 문의하기</a> <br><br>
</c:if>

<!-- 세션 없는 경우 -->
<c:if test="${sessionScope.mem_id == null}">
	<a href="<%=request.getContextPath() %>/MemberForm.do">회원가입</a><br><br>
	<a href="<%=request.getContextPath() %>/LoginForm.do">로그인</a><br><br>
</c:if>