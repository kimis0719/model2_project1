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
<style>
<c:import url="../css/header.css" /> 
</style>
</head>
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
          <li><a href="../BoardListAction.do?cate_num=${c.cate_num}">공지</a></li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">일상●취미 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <c:forEach var="c" items="${catelist}">
            	<!-- cate_code가 2(일상취미)에 해당하는 게시판 정보중 이름을 가져온다. -->
				<c:if test="${c.cate_code == 2}">	
					<li><a href="../BoardListAction.do?cate_num=${c.cate_num}"> ${c.cate_name}</a></li>
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


