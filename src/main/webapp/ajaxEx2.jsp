<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<title>Insert title here</title>
<script>
$(document).ready(function() {
	$("#btn-1").click(function() {
		$.ajax({
			type: "post",
			url: "/replies/new",
			contentType: "application/json",
			data: '{"bno":133,"reply":"ex2덧글","replyer":"user01"}',
			complete: function(jqXHR, status) {
				console.log("complete");
				console.log(status);
				console.log(jqXHR);
			}
		});
	});
	
	$("#btn-2").click(function() {
		$.ajax({
			type: "post",
			url: "/replies/new",
			contentType: "application/json",
			data: '{/* "bno":130, */"reply":"새 댓글~","replyer":"user01"}',
			complete: function(jqXHR, status) {
				console.log("complete");
				console.log(status);
				console.log(jqXHR);
			}
		});
	});
	
	$("#btn-3").click(function() {
		$.ajax({
			type: "post",
			url: "/replies/new",
			contentType: "application/json",
			data: '{"bno":133,"reply":"★새 댓글★","replyer":"user01"}',
			complete: function(jqXHR, status) {
				if(status == "success") {
					console.log("등록 성공");
					console.log(jqXHR.responseText);
				} else if (status == "error") {
					console.log("등록 실패");
				}
				console.log("complete");
				console.log(status);
				console.log(jqXHR);
			}
		});
	});
	
	$("#btn-4").click(function() {
		$.ajax({
			url: "/replies/pages/130/1",
			type: "get",
			complete: function(jqXHR, status) {
				if (status === "success") {
					console.log(jqXHR.responseText);
				}
			}
		});
	});
});

</script>
</head>
<body>
<h1>AJAX ex 2</h1>
<div>
<button id="btn-1">댓글 등록</button>
</div>

<div>
<button id="btn-2">댓글 등록 실패</button>
</div>

<div>
<button id="btn-3">댓글 등록 성공 OR 실패</button>
</div>

<div>
<button id="btn-4">댓글 등록 성공 OR 실패</button>
</div>
</body>
</html>







