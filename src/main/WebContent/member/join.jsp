<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<title>회원가입 페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 외부파일 불러오기 -->
<script src="<%=request.getContextPath() %>/member/join.js"></script>

</head>
<body>

	<jsp:include page="../layout/header.jsp" />
		
	<div class="header">
		<h1>중앙 커뮤니티</h1>
		<form>
			<input type="text" name="search" placeholder="통합검색...">
			<button class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> 검색
			</button>
		</form>
	</div>


	<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
  <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="./CateListAction.do">홈</a>
    </div>
    <div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="./BoardListAction.do?cate_num=${c.cate_num}">공지</a></li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">일상●취미 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <c:forEach var="c" items="${catelist}">
            	<!-- cate_code가 2(일상취미)에 해당하는 게시판 정보중 이름을 가져온다. -->
				<c:if test="${c.cate_code == 2}">	
					<li><a href="./BoardListAction.do?cate_num=${c.cate_num}"> ${c.cate_name}</a></li>
				</c:if>
			  </c:forEach>
            </ul>
          </li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">스포츠 <span class="caret"></span></a>
            <ul class="dropdown-menu">
               <c:forEach var="c" items="${catelist}">
				<c:if test="${c.cate_code == 3}">	
					<li><a href=""> ${c.cate_name}</a></li>
				</c:if>
			  </c:forEach>
            </ul>
          </li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">게임 <span class="caret"></span></a>
            <ul class="dropdown-menu">
               <c:forEach var="c" items="${catelist}">
				<c:if test="${c.cate_code == 4}">	
					<li><a href=""> ${c.cate_name}</a></li>
				</c:if>
			  </c:forEach>
            </ul>
          </li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">연예 <span class="caret"></span></a>
            <ul class="dropdown-menu">
               <c:forEach var="c" items="${catelist}">
				<c:if test="${c.cate_code == 5}">	
					<li><a href=""> ${c.cate_name}</a></li>
				</c:if>
			  </c:forEach>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>  
		<div class="rightcolumn">
			<div class="card">
				<a href="loginForm.jsp"><button class="btn 로그인">로그인</button></a>
				<a href="join.jsp"><button class="btn 회원가입">회원가입</button></a>
			</div>
			
			<div class="card">
				<h3>Popular Post</h3>
				<div class="fakeimg">
					<p>Image</p>
				</div>
				<div class="fakeimg">
					<p>Image</p>
				</div>
				<div class="fakeimg">
					<p>Image</p>
				</div>
			</div>
			<div class="card">
				<h3>Follow Me</h3>
				<p>Some text..</p>
			</div>
			
		</div>
	</div>

	<div class="row">
		<div class="leftcolumn">
		<div class="card">
<div class="container">
		<div style="padding: 100px;">
		<form method="post" action="<%=request.getContextPath() %>/Member.member"
			enctype="multipart/form-data">
			<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="4"><h4>회원가입</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:110px;"><h6>아이디</h6></td>
						<td><input class="form-control" type="text" id="mem_id" name="mem_id" placeholder="아이디" maxlength="20"></td>
						<td style="width:100px;"><button class="btn btn-default" id="idcheck" type="button"><h6>ID중복체크</h6></button></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>닉네임</h6></td>
						<td><input class="form-control" type="text" id="mem_nick" name="mem_nick" placeholder="닉네임" maxlength="40"></td>
						<td style="width:100px;"><button class="btn btn-default" id="nickcheck" type="button">닉네임 체크</button></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>비밀번호</h6></td>
						<td><input class="form-control" type="password" id="mem_pass" name="mem_pass" placeholder="비밀번호" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>비밀번호 확인</h6></td>
						<td><input class="form-control" type="password" id="mem_pass2" name="mem_pass2" placeholder="비밀번호 확인" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>이메일</h6></td>
						<td><input class="form-control" type="email" id="mem_email" name="mem_email" placeholder="이메일" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width:140px;"><h6>프로필사진</h6></td>
						<td><input class="form-control" type="file" id="mem_img" name="mem_img"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>핸드폰번호</h6></td>
						<td><input class="form-control" type="text" id="mem_phone" name="mem_phone" placeholder="핸드폰번호" maxlength="20"></td>
					</tr>
					<tr>
						<td style="text-align:right" colspan="2"><input class="btn btn-default pull-right" type="submit" value="회원가입"></td>
					</tr>
				</tbody>	
			</table>
		</form>
	  </div>	
	</div>
 </div>
 </div>
 <jsp:include page="../layout/rightcolumn.jsp" />
</div>


	
<jsp:include page="../layout/footer.jsp" />

</body>

</html>