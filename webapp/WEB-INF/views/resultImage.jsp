<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<div id="file">
		<div>
			<img id="resultImg" src="${pageContext.request.contextPath }/upload/${imgName }">
		</div>	
	</div>
	<a href="${pageContext.request.contextPath }/file/form">이미지 첨부 페이지</a>
	<a href="${pageContext.request.contextPath }/phone/list">폰북으로 이동</a>
</body>
</html>