<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet">
<style>
</style>
</head>
<div class="header">

	<a href="./MainPageAction.board"><img class="logo" src="${pageContext.request.contextPath}/layout/img/logo.png" width="40" height="55"></a>
	<h1>중앙 커뮤니티</h1>
		<div class="UnifiedSearch"> 
		<form action="BoardSearchAction.board?cate_num=${currentCate}" method=post accept-charset="utf-8">
			<select name="sel" id="sel">
								<option value="board_title">제목</option>
								<option value="board_content">내용</option>
								<option value="board_nick">작성자</option>
							</select> 
			<input type="text" name="find" id="find" placeholder="검색...">
			<button type="submit" class="btn btn-info">
			<span class="glyphicon glyphicon-search"></span> 검색
			</button>
	</form>
	</div>
</div>


<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
  <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="./MainPageAction.board">홈</a>
    </div>
    <div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="./BoardListAction.board?cate_num=1">공지</a></li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">일상●취미 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <c:forEach var="c" items="${catelist}">
            	<!-- cate_code가 2(일상취미)에 해당하는 게시판 정보중 이름을 가져온다. -->
				<c:if test="${c.cate_code == 2}">	
					<li><a href="./BoardListAction.board?cate_num=${c.cate_num}"> ${c.cate_name}</a></li>
				</c:if>
			  </c:forEach>
            </ul>
          </li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">스포츠 <span class="caret"></span></a>
            <ul class="dropdown-menu">
               <c:forEach var="c" items="${catelist}">
				<c:if test="${c.cate_code == 3}">	
					<li><a href="./BoardListAction.board?cate_num=${c.cate_num}"> ${c.cate_name}</a></li>
				</c:if>
			  </c:forEach>
            </ul>
          </li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">게임 <span class="caret"></span></a>
            <ul class="dropdown-menu">
               <c:forEach var="c" items="${catelist}">
				<c:if test="${c.cate_code == 4}">	
					<li><a href="./BoardListAction.board?cate_num=${c.cate_num}"> ${c.cate_name}</a></li>
				</c:if>
			  </c:forEach>
            </ul>
          </li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">연예 <span class="caret"></span></a>
            <ul class="dropdown-menu">
               <c:forEach var="c" items="${catelist}">
				<c:if test="${c.cate_code == 5}">	
					<li><a href="./BoardListAction.board?cate_num=${c.cate_num}"> ${c.cate_name}</a></li>
				</c:if>
			  </c:forEach>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>

</nav>  