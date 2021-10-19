/**
 * 
 */
function orderListToURL(url) {
	location.href = url;
}

$(document).ready(function() {
	$("form").submit(function() {
		if ($("#searchselect").val() == "") {
			alert("검색할 항목을 선택하세요.");
			return false;
		}
		if ($("#searcharea").val() == "") {
			alert("검색어를 입력하세요.");
			$("#searcharea").focus();
			return false;
		}
	});
});



