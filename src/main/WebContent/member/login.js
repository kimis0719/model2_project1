$(document).ready(function(){
	$("form").submit(function(){
		
		if($.trim($("#mem_id").val())==""){
			alert("ID를 입력하세요");
			$("#mem_id").focus();
			return false;
		}
		
		if($.trim($("#mem_pass").val())==""){
			alert("비밀번호를 입력하세요");
			$("#mem_pass").focus();
			return false;
		}
		
	});
});