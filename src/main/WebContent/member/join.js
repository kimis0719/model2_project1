$(document).ready(function(){	
	
	// ID 중복검사
	$("#idcheck").click(function(){
		if($("#mem_id").val()==""){
			alert("ID를 입력하세요");
			$("#mem_id").focus();
			return false;
		}else{
			
			var id = $("#mem_id").val();	
			
			$.ajax({
				type:"post",
				url:"/projectb/Idcheck.do",
				data:{"id":mem_id},
				datatype:"text",
				success:function(data){

					if(data==1){	// 중복 ID
						$("#myid").text("중복ID");	//"# "여기안에 뭘 넣어야될지를 모르겠음..ㅠ
						$("#mem_id").val("").focus();
					}else{			// 사용 가능한 ID
						$("#myid").text("사용 가능한 ID");
						$("#mem_nick").focus();	
					}					
				}
			});			
		}		
	});
	
	
	// 유효성 검사
	$("form").submit(function(){
		
		if($("#mem_id").val() == ""){
			alert("ID를 입력하세요");
			$("#mem_id").focus();
			return false;
		}		
		if($("#mem_nick").val()==""){
			alert("닉네임을 입력하세요");
			$("#mem_nick").focus();
			return false;
		}
		if($("#mem_pass1").val()==""){
			alert("비밀번호를 입력하세요");
			$("#mem_pass1").focus();
			return false;
		}		
		if($("#mem_pass2").val()==""){
			alert("비밀번호 확인을 입력하세요");
			$("#mem_pass2").focus();
			return false;
		}		

		if($("#mem_email").val()==""){
			alert("EMail 주소를 입력하세요");
			$("#mem_email").focus();
			return false;
		}

		if($("#mem_phone").val()==""){
			alert("핸드폰 번호를 선택하세요");
			$("#mem_phone").focus();
			return false;
		}

		if(isNaN($("#mem_phone").val())){
			alert("숫자만 입력하세요");
			$("#mem_phone").val("").focus();
			return false;
		}
	}); // submit() end		
	
});  // ready() end