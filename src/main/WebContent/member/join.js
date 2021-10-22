$(document).ready(function(){	
	
	// ID 중복검사
	$("#idcheck").click(function(){
		if($("#mem_id").val()==""){
			alert("ID를 입력하세요");
			$("#mem_id").focus();
			return false;
		}else{
			
			var mem_id = $("#mem_id").val();	
			
			$.ajax({
				type:"post",
				url:"/model2_project1/Idcheck.member",
				data:{"mem_id": mem_id},
				datatype:"text",
				success:function(data){
					if(data==1){	// 중복 ID
//						$("#myid").text("중복ID");	//"# "여기안에 뭘 넣어야될지를 모르겠음..ㅠ
						alert("사용중인 ID입니다.")
						$("#mem_id").val("").focus();
					}else{			// 사용 가능한 ID
//						$("#myid").text("사용 가능한 ID");
						alert("사용 가능한 ID입니다.")
						$("#mem_nick").focus();	
					}					
				}
			});			
		}		
	});
	
	//닉네임 중복검사
	$("#nickcheck").click(function(){
		if($("#mem_nick").val()==""){
			alert("닉네임을 입력하세요.");
			$("#mem_nick").focus();
			return false;
		}else{
			var mem_nick = $("#mem_nick").val();
			
			$.ajax({
				type:"post",
				url:"/model2_project1/Nickcheck.member",
				data:{"mem_nick":mem_nick},
				datatype:"text",
				success:function(data){
					if(data==2){
						alert("사용중인 닉네임 입니다.")
						$("#mem_nick").val("").focus();
					}else{
						alert("사용 가능한 닉네임 입니다.")
						$("#mem_pass").focus();
					}
				}	
			});
		}
	});
	
	
	
	
	
	// 유효성 검사
	$("form").submit(function(){
		 var pw = $("#mem_pass").val();
		 var num = pw.search(/[0-9]/g);
		 var eng = pw.search(/[a-z]/ig);
		 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

		 var id = $("#mem_id").val();

		
		if($("#mem_id").val() == ""){
			alert("ID를 입력하세요");
			$("#mem_id").focus();
			return false;
		}else if(id.length < 5 || id.length > 12){
			alert("ID는 5~12자리 이내로 입력해주세요.");
			$("#mem_id").val("").focus();
			return false;
		}else if(id.search(/\s/) != -1){
			alert("ID는 공백 없이 입력해주세요.");
			$("#mem_id").val("").focus();
			return false;
		}else if($("#mem_nick").val()==""){
			alert("닉네임을 입력하세요");
			$("#mem_nick").focus();
			return false;
		}else if($("#mem_pass").val()==""){
			alert("비밀번호를 입력하세요");
			$("#mem_pass").focus();
			return false;
		}else if(pw.length < 8 || pw.length > 15){
			alert("비밀번호는 8~15자리 이내로 입력해주세요.");
			$("#mem_pass").val("").focus();
			$("#mem_pass2").val("");
		    return false;
		}else if(pw.search(/\s/) != -1){
			 alert("비밀번호는 공백 없이 입력해주세요.");
			 $("#mem_pass").val("").focus();
			 $("#mem_pass2").val("");
			 return false;
		}else if( (num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
			 alert("비밀번호는 영문,숫자, 특수문자 중 2가지 이상을 혼합하여 입력해주세요.");
			 $("#mem_pass").val("").focus();
			 $("#mem_pass2").val("");
			 return false;
		}else if($("#mem_pass2").val()==""){
			alert("비밀번호 확인을 입력하세요");
			$("#mem_pass2").focus();
			return false;
		}else if(($("#mem_pass").val()) != ($("#mem_pass2").val())){
			 alert("비번이 일치하지 않습니다.");
			 $("#mem_pass").val("").focus();
			 $("#mem_pass2").val("");
			 return false;
		 }else if($("#mem_email").val()==""){
			alert("EMail 주소를 입력하세요");
			$("#mem_email").focus();
			return false;
		}else if($("#mem_phone").val()==""){
			alert("핸드폰 번호를 선택하세요");
			$("#mem_phone").focus();
			return false;
		}else if(isNaN($("#mem_phone").val())){
			alert("숫자만 입력하세요");
			$("#mem_phone").val("").focus();
			return false;
		}
	}); // submit() end		
	
});  // ready() end