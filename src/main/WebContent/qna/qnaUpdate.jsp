<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qna Update Form</title>
<c:import url="../layout/boot.jsp" />
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/qnaWrite.css" rel="stylesheet">
</head>
<body>
	<div id="popWrap">
			<div id="popHead">
				<div class="popHeadEnd">
					<h1>문의내용 수정</h1>
				</div>
			</div>
			<div class="popBody_con">
				<div class="pop_qna_wrap">
					<div class="tbl_wrap">
						<table class="tbl">
							<caption>문의내용 수정</caption>
							<colgroup>
								<col style="width:25%">
								<col style="width:75%">
							</colgroup>
							<tbody>
							<!-- 제목 -->
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">제목</label>
									</th>
									<td class="alignL">
										<input type="text" name="qna_title" value="${qna.qna_title}" placeholder="제목을 작성해 주세요" maxlength="60" size="79">
										<!-- <textarea name="qna_title" id="popTitle" rows="1" cols="80" placeholder="제목을 작성해 주세요"></textarea> -->
									</td>
								</tr>
							
							<!-- 내용 -->
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">내용</label>
									</th>
									<td class="alignL">
										<textarea name="qna_content" id="popCont" rows="10" cols="80" placeholder="궁금하신 내용을 작성해 주세요">${qna.qna_content}</textarea>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				<!-- 비밀글 -->
					<div class="chk_wrap">
						<label for="secret">
							<c:if test="${qna.qna_sec == 1}">
								<input type="checkbox" checked="checked" name="qna_sec" id="secret" value="1" class="chk"> 비밀글로 문의하기
							</c:if>
							<c:if test="${qna.qna_sec == 0}">
								<input type="checkbox" name="qna_sec" id="secret" value="0" class="chk"> 비밀글로 문의하기
							</c:if>
						</label>
					</div>
				<!-- 공지사항 -->
					<div class="notice_box">
						<h2 class="tit">알아두세요!</h2>
						<ul>
							<li>전화번호, 이메일, 배송지 주소, 환불계좌정보 등 개인정보가 포함된 글은, 비밀글로 문의해 주시기 바랍니다.</li>
							<li>
								부적절한 게시물 등록시 ID이용 제한 및 게시물이 삭제될 수 있습니다.
								<ul>
									<li>- 전화번호, 이메일 주소 등 연락처를 기재하여 할인/직거래 등을 유도</li>
									<li>- 비방/욕설/명예훼손, 가격비교정보, 물품과 관련 없는 광고글 등</li>
									<li>- 다만 상품에 대한 단순 불만, 판매자에게 불리한 내용이라는 이유만으로는 삭제하지 않습니다.</li>
								</ul>
							</li>
							<li>게시글에 회원님의 이메일, 휴대폰번호와 같은 개인 정보의 입력은 금지되어 있으며, 발생하는 모든 피해에 대해 중앙Community는 책임지지 않습니다.</li>
						</ul>
					</div>
				</div>
			<!-- 버튼 -->
				<div class="btn_wrap">
					<input type="hidden" name="qna_num" value="${qna.qna_num}">
					<input type="hidden" name="qna_memnum" value="${member.mem_num}">
					<input type="hidden" name="qna_writer" value="${member.mem_id}">
					<button id="btnSave" class="popbtn popbtn1" title="수정"><span>수정</span></button>
					<button id="btnClose" class="popbtn popbtn2" title="취소"><span>취소</span></button>
				</div>
			</div>
	</div>
<script type="text/javascript">

	//등록 버튼
	$('#btnSave').click(function(){
		if($('input[name="qna_sec"]').is(":checked")){
			$('input[name="qna_sec"]').val(1);
		}else {
			$('input[name="qna_sec"]').val(0);
		}
		
		var num = $('input[name="qna_num"]').val();
		var writer = $('input[name="qna_writer"]').val();
		var title = $('input[name="qna_title"]').val();
		var content = $('#popCont').val();
		var secret = $('input[name="qna_sec"]').val();
		//alert(secret);
		
		if(writer == null || writer == ""){
			alert("로그인 후 이용하세요");
			self.close();
		}else {
			
			if(content != ""){
				
				$.ajax({
					type: "POST",
					url: "./qnaUpdate.qna",
					data: {
						qna_num: num,
						//qna_writer: writer,
						qna_title: title,
						qna_content: content,
						qna_sec: secret
					},
					success: function(data){
						//alert(data);
						/* if(data > 0){  */
							opener.location.reload();
							self.close();
						/* }else{
							alert("s잠시 후에 다시 시도해주세요.");
						} */
					},
					error: function(){
						alert("잠시 후에 다시 시도해주세요.");
					}
				});
						
			}else {
				alert("문의내용을 입력해주세요.");
			}
		}
	});
	
	//취소 버튼
	$('#btnClose').click(function(){
		window.close();
	});
</script>
</body>
</html>