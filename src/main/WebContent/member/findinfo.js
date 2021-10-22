$(document).ready(function(){	
	
	// 유효성 검사
	$("form").submit(function(){


		
		if($("#mem_id").val() == ""){
			alert("ID를 입력하세요");
			$("#mem_id").focus();
			return false;
		}else if($("#mem_nick").val() == ""){
			alert("닉네임를 입력하세요");
			$("#mem_nick").focus();
			return false;
		}else if($("#mem_email").val() == ""){
			alert("email을 입력해주세요.");
			$("#mem_email").focus();
			return false;
		}
	}); // submit() end		
	
});  // ready() end