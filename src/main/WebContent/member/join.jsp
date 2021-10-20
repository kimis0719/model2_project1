<!-- 회원가입 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.js"></script>

<style>
  .btn-default {
      background: #EC5E5E;
      color: #fff;
   }
  .btn-default:hover {
      background: #EC5E5E;
      color: #000;
   }
   thead th{
	background-color :#EC5E5E;
	color: white;
	text-align: center;
}
  </style>

<!-- 외부파일 불러오기 -->
<script src="<%=request.getContextPath() %>/member/join.js"></script>
</head>
<body>
	<div class="container">
		<div style="padding: 100px;">
		<form method="post" action="<%=request.getContextPath() %>/Member.member"
			enctype="multipart/form-data">
			<table class="table table-bordered table-hover" style="text-align: center; border: 5px solid #dddddd">
				<thead>
					<tr>
						<th colspan="4"><h4>회원가입</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:110px;"><h6>아이디</h6></td>
						<td><input class="form-control" type="text" id="mem_id" name="mem_id" placeholder="아이디" maxlength="20"></td>
						<td style="width:140px;"><button class="btn btn-default" id="idcheck" type="button"><h6>ID중복체크</h6></button></td>
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
</body>
</html>