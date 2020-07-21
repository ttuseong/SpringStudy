<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/file/upload" enctype="multipart/form-data">
		<table>
			<colgroup>
				<col style="width: 600px;">
				<col style="width: 220px;">
			</colgroup>
			<tr>
				<td class="text-left"><input type="file" name="file"></td>
				<td class="text-right"><button type="submit">파일업로드</button></td>
			</tr>
		</table>
	</form>
</body>
</html>