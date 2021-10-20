/**
 * 
 */
function orderListToURL(url) {
	location.href = url;
}

$(document).ready(function() {
	$("form").submit(function() {
		if ($("#sel").val() == "") {
			alert("검색할 항목을 선택하세요.");
			return false;
		}
		if ($("#find").val() == "") {
			alert("검색어를 입력하세요.");
			$("#find").focus();
			return false;
		}
	});
});


