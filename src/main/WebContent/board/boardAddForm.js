// 유효성 검사
$(document).ready(function(){	
	$("form").submit(function(){
			if($("#catecode").val() == ""){
				alert("카테고리 코드를 선택해 주세요");
				$("#mem_id").focus();
				return false;
			}else if($("#catename").val() == ""){
				alert("게시판 이름을 입력해 주세요");
				$("#mem_id").focus();
				return false;
			}
	}); // submit() end	
});// ready() end