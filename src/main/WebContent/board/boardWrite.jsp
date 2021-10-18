<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWrite</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%-- <c:import url="../layout/header.jsp" /> --%>
<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/boardWrite.css"
	rel="stylesheet">
<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
	<div class="body_main">
		<div class="b"></div>
		<!-- 서브 타이틀 -->
		<div class="subTitle_wrap">
			<div class="subTitle_inner">
				<h2>${boardName}글쓰기</h2>
			</div>
		</div>
		<div class="container">
			<form action="${pageContext.request.contextPath}/BoardWrite.do"
				method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="title">제목</label> <input type="text"
						class="form-control" id="title" placeholder="제목을 입력하세요."
						name="title">
				</div>

				<div class="form-group">
					<label for="writer">작성자</label> <input type="text"
						class="form-control" id="writer" readonly="readonly" name="writer"
						value="${board_nick}">
				</div>

				<div class="form-group">
					<label for="contents">Contents:</label>
					<textarea rows="20" cols="50" class="form-control" id="contents"
						placeholder="내용을 입력하세요." name="contents"></textarea>
				</div>

				<button class="btngo">등록</button>
				<input type="button" id="btn_add" class="btn_add" value="Add File">
				<div id="files"></div>
			</form>
			<a class="listgo" href="./boardList.jsp">목록으로..</a>
		</div>
		<script type="text/javascript">
		 var files = ' <div class="form-group tt">     <label for="file"></label>      <br>       <div class="col-sm-11">          <input type="file" class="form-control" id="file" name="files">       </div>       <div class="col-sm-1">          <input type="button" class="del" value="X">       </div>     </div>';
		   $('#files').empty(); //remove vs empty ; 나 포함 전체 지우기 vs 자식만 지우기
		   var check = 0;
		   var index = 0; //index 번호
		   
		   $('#files').on("click", ".del", function() {
		      //event.preventDefault();
		      //alert("del");
		      //$("#files div:last").remove(); //선택된 게 지워지질 않아 ㅜㅠ
		      //1. $(this).closest(".tt").remove(); //가장 가까운 거!!
		      //2. $(this).parent().parent().remove();
		      //3. $(this).parents(".form-group").remove();
		      $(this).parentsUntil("#files").remove();
		      check--;
		   });   //add file은 버튼을 눌러야 추가되는데, 추가되기 전에 이벤트가 실행되므로 이벤트가 실행되지 않는다.
		         
		   $('#btn_add').click(function() {
		      //alert(files);
		      if(check<5){
		         $('#files').append(files);
		         check++;
		      }else {
		         alert("최대 5개까지 가능합니다.");
		      }
		   });
		 
			$("#write").click(function() {
				//다른 input들 검증.
				if($("#contents").summernote('isEmpty')) {
					alert("내용을 입력해주세요.");
				}else {
					$("#frm").submit();
				}
			});
		var formData = null;
		//summer Note
		$("#contents").summernote(
				{
					height : 400,
					minHeight: null,             // set minimum height of editor
					maxHeight: null,             // set maximum height of editor
					focus: true,      
					callbacks : {
						onImageUpload : function(file) {
							var formData = new FormData();
							formData.append('file', file[0]);
							$.ajax({
								type : "POST",
								url : "./summerFile",
								data : formData,
								enctype : "multipart/form-data",
								cache : false,
								contentType : false,
								processData : false,
								success : function(data) {
									data = data.trim();
									console.log(data);
									data = '../summernote/'+data;
									console.log(data);
									$('#contents').summernote('insertImage', data);
									console.log("썸머");
									formData.delete('file');
								}
							});
						},
						//OnImageUpload End
						onMediaDelete : function(files) {
							var fileName = $(files[0]).attr('src');
							console.log(fileName);
							fileName = fileName.substring(fileName.lastIndexOf('/')+1);
							console.log(fileName);
							$.ajax({
								type : "POST",
								url : "./summerFileDelete",
								data : {
									fileName : fileName
								},
								success : function(data) {
									console.log(data);
								}
							});
						}
					//onMediaDelete End
					}
				});
		
		
		</script>
	</div>
</body>
</html>