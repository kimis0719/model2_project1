<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<title>마이 페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="<%=request.getContextPath() %>/member/login.js"></script>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial;
	padding: 10px;
	background: #EEEEEE;
	position: relative;
}

body {
	opacity: 1;
}

/* Header/Blog Title */
.header {
	padding: 30px;
	text-align: center;
	background: #EEEEEE;
}

.header h1 {
	font-size: 40px;
}

input[id=totalfind] {
	width: 130px;
	box-sizing: border-box;
	border: 5px solid #EC5E5E;
	border-radius: 4px;
	font-size: 15px;
	background-color: white;
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
	-webkit-transition: width 0.4s ease-in-out;
	transition: width 0.4s ease-in-out;
	outline: none;
}

input[id=totalfind]:focus {
	width: 50%;
}

  .affix {
    top:0;
    width: 100%;
    z-index: 9999 !important;
  }
  .navbar {
    margin-bottom: 0px;
  }

  .affix ~ .container-fluid {
   position: relative;
   top: 50px;
  }

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
	float: left;
	width: 75%;
}

/* Right column */
.rightcolumn {
	float: left;
	width: 25%;
	background-color: #f1f1f1;
	padding-left: 20px;
}

/* Fake image */
.fakeimg {
	background-color: #aaa;
	width: 100%;
	padding: 20px;
}

/* Add a card effect for articles */
.card {
	background-color: white;
	padding: 20px;
	margin-top: 20px;
}

/* Set a style for all buttons */
.btn {
	border: none;
	color: white;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
}



.btn-info {
	background-color: #EC5E5E;
}

.btn-info:hover {
	background-color: #EC5E5E;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

#myBtn {
	display: none;
	position: fixed;
	bottom: 20px;
	right: 30px;
	z-index: 99;
	font-size: 18px;
	border: none;
	outline: none;
	background-color: #EC5E5E;
	color: white;
	cursor: pointer;
	padding: 15px;
	border-radius: 4px;
}

#myBtn:hover {
	background-color: #555;
}

/* Footer */
.footer {
	padding: 25px;
	text-align: center;
	background-color: #222222;
	color: #919191;
	margin-top: 25px;
}

.btn-default {
     	 background: #EC5E5E;
     	 color: #fff;
   }
   
 a {
		color: black;
   }

   

/* footer address a{
    display: block; /* a 태그는 인라인요소라 수평으로 출력돼서 블록으로 강제로 수직으로 출력되도록 함*/
} */


/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.leftcolumn, .rightcolumn {
		width: 100%;
		padding: 0;
	}
}
}
</style>
</head>
<body>

	<div class="header">
		<h1>중앙 커뮤니티</h1>
		<form>
			<input type="text" name="search" id="totalfind"placeholder="통합검색...">
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
      <a class="navbar-brand" href="<%=request.getContextPath() %>/MainPageAction.board">홈</a>
    </div>
    <div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="./BoardListAction.board?cate_num=${c.cate_num}">공지</a></li>
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

	<div class="row">
		<div class="leftcolumn">
		<div class="jumbotron">
  <nav class="navbar navbar-default">
  <div class="container-fluid">

    <ul class="nav navbar-nav">
      <li class="active"><a href="./MainPageAction.board">Home</a></li>
      <li><a href="<%=request.getContextPath()%>/UpdateMember.Mypage">내 정보 수정</a></li>
      <li><a href="./BoardListAction.board">내가 작성한 글 보기</a></li>
      <li><a href="#">나의 댓글 모음</a></li>
      <li><a href="#">문의하기</a></li>
      <li><a href="./Delete.Mypage">회원 탈퇴</a></li>
    </ul>
  </div>
</nav>

     </div>
 	</table>
  </form>
  </div>
</div>
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

	<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>

	<script>
		//Get the button
		var mybutton = document.getElementById("myBtn");

		// When the user scrolls down 20px from the top of the document, show the button
		window.onscroll = function() {
			scrollFunction()
		};

		function scrollFunction() {
			if (document.body.scrollTop > 20
					|| document.documentElement.scrollTop > 20) {
				mybutton.style.display = "block";
			} else {
				mybutton.style.display = "none";
			}
		}

		// When the user clicks on the button, scroll to the top of the document
		function topFunction() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
	</script>

	<div class="footer">
		<!-- 로고 추가 -->
		<p>Copyright© All rights reserved.</p>
		<dl>
			<dt>주소: 서울특별시</dt>
			<dt>상호: CHC</dt>
			<dt>담당자: 홍길동</dt>
			<dt>연락처: 111-1111-1111</dt>
		</dl>
		<h6>본 사이트에서는 각종 청소년유해정보로부터 청소년을 보호하고자 관련법률에 따라 19세미만의 청소년들이 유해정보에
			접근할 수 없도록 청소년취급방침을 마련하여 시행하고 있습니다. 또한 청소년의 건전한 성장을 저해하는 음란 · 불법 등의
			유해정보와 비윤리적 · 반사회적 행위에 대해서는 엄격하게 제재하고 있습니다.</h6>
	</div>


</body>

</html>





