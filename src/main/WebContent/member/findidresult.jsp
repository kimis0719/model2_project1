<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ID찾기 결과창</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<style>
 .btn-default {
     	 background: #EC5E5E;
     	 color: #fff;
   }
</style>

</head>
<body>

<jsp:include page="../layout/header.jsp" />

<div class="row">
		<div class="leftcolumn">
		<div class="card">
<div class="container" style="padding: 350px;">
<div class="jumbotron">
  <h2>ID 찾기</h2>
  <form action="<%=request.getContextPath()%>/SearchId.">
    <div>
      <h5>회원님의 ID는: ${mem_id} 입니다.</h5>
      			
    </div>
  </form>
  <div>
  <input type="button" class="btn btn-default" value="비번찾기" onClick="location.href='<%=request.getContextPath() %>/member/searchpw.jsp'">
  </div>
  </div>
</div>
 </div>
 </div>
 <jsp:include page="../layout/rightcolumn.jsp" />
 </div>

<jsp:include page="../layout/footer.jsp" />
</body>
</html> 