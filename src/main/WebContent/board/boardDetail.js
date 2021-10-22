$(document).ready(function() {
	// 유효성 검사
	$("#writereply").click(function() {

		if ($("#re_content").val() == "") {
			alert("댓글을 입력해 주세요");
			$("#re_content").focus();
			return false;
		}
	}); // submit() end		

});  // ready() end