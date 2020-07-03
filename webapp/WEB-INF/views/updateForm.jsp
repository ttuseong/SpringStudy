<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 수정폼</h1>
	<p>
		전화번호를 수정하려면 <br>
		아래 항목을 수정하고 "수정" 버튼을 클릭하세요.
	</p>
	<form action = "/study/phone/update" method = "get">
		이름(name) : <input type = "text" name = "name" value="${vo.name }"> <br>
		핸드폰(hp) : <input type = "text" name = "hp" value="${vo.hp }"> <br>
		회사(company) : <input type = "text" name = "company" value="${vo.company }"><br>
		<input type = "hidden" name = "personId" value="${vo.personId }">
		<button type = "submit">수정</button>
	</form>
</body>
</html>