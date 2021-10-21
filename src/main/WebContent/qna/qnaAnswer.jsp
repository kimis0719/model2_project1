<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qna Answer</title>
<c:import url="../layout/boot.jsp" />
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/qnaWrite.css" rel="stylesheet">
</head>
<body>
	<div id="popWrap">
			<div id="popHead">
				<div class="popHeadEnd">
					<h1>문의답변 작성</h1>
				</div>
			</div>
			<div class="popBody_con">
				<div class="pop_qna_wrap">
					<div class="tbl_wrap">
						<table class="tbl">
							<caption>문의답변 작성</caption>
							<colgroup>
								<col style="width:25%">
								<col style="width:75%">
							</colgroup>
							<tbody>
							<!-- 제목 -->
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">문의제목</label>
									</th>
									<td class="alignL">
										<input type="text" disabled="disabled" value="${question.qna_title}" maxlength="60" size="79">
									</td>
								</tr>
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">문의내용</label>
									</th>
									<td class="alignL">
										<textarea disabled="disabled" rows="10" cols="80">${question.qna_content}</textarea>
									</td>
								</tr>
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">답변내용</label>
									</th>
									<td class="alignL">
										<textarea name="qna_content" id="popCont" rows="10" cols="80" placeholder="답변 내용을 작성해 주세요"></textarea>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				
			<!-- 버튼 -->
				<div class="btn_wrap">
					<input type="hidden" name="qna_writer" value="${member.mem_id}">
					<input type="hidden" name="qna_memnum" value="${member.mem_num}">
					<input type="hidden" name="qna_title" value="${question.qna_title}">
					<input type="hidden" name="qna_ref" value="${question.qna_num}">
					<input type="hidden" name="qna_sec" value="${question.qna_sec}">
					<button id="btnSave" class="popbtn popbtn1" title="등록"><span>등록</span></button>
					<button id="btnClose" class="popbtn popbtn2" title="취소"><span>취소</span></button>
				</div>
			</div>
	</div>
	
<script type="text/javascript">

	//등록 버튼
	$('#btnSave').click(function(){
		var title = $('input[name="qna_title"]').val();
		var memnum = $('input[name="qna_memnum"]').val();
		var writer = $('input[name="qna_writer"]').val();
		var content = $('#popCont').val();
		var ref = $('input[name="qna_ref"]').val();
		var secret = $('input[name="qna_sec"]').val();

		if(writer == null || writer == ""){
			alert("로그인 후 이용하세요");
			self.close();
		}else {
		
			if (content != "") {
		
				$.ajax({
					type : "POST",
					url : "./qnaAnswer.qna",
					data : {
						qna_title: title,
						qna_memnum: memnum,
						qna_writer : writer,
						qna_content : content,
						qna_ref : ref,
						qna_sec : secret
					},
					success : function(data) {
						//if (data > 0) {
							opener.location.reload();
							self.close();
						//} else {
						//	alert("잠시 후에 다시 시도해주세요.");
						//}
					},
					error : function() {
						alert("잠시 후에 다시 시도해주세요.");
					}
				});
			} else {
				alert("답변내용을 입력해주세요.");
			}//if contents
		}//if writer
	});//클릭버튼

	//취소 버튼
	$('#btnClose').click(function() {
		window.close();
	});
</script>
</body>
</html>