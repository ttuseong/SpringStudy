<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/jqueryex/jquery/jquery-1.12.4.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>

	<div>
		<c:forEach items="${list }" var = "vo">
			<table border = "1">
				<colgroup>
					<col style = "width : 120px;">
					<col style = "width : 170px;">
				</colgroup>
				<tbody>
					<tr>
						<td>이름(name)</td>
						<td>${vo.name}</td>
					</tr>
					<tr>
						<td>핸드폰(hp)</td>
						<td>${vo.hp}</td>
					</tr>
					<tr>
						<td>회사(company)</td>
						<td>${vo.company}</td>
					</tr>
					<tr>
						<td><a href="/study/phone/updateForm?id=${vo.personId }">수정</a></td>
						<td><a href="/study/phone/delete?id=${vo.personId }">삭제</a></td>
					</tr>
				</tbody>
			</table>
		<br>
		</c:forEach>
	</div>
	
	
	<button id="regBtn">추가번호 등록</button>
	<!-- <a href = "/study/phone/writeForm">추가번호 등록</a> -->
</body>

<script type="text/javascript">
	

	$("#regBtn").on("click",function(){
		var name = prompt("이름을 입력하세요");
		var hp = prompt("핸드폰 번호를 입력하세요");
		var company= prompt("회사 번호를 입력하세요");
		
		console.log(name + ", " + hp + ", " + company);
		
		addBook(name, hp, company);
	});
	
	function addBook(name, hp, company){
		console.log(name + ", " + hp + ", " + company + "*******************************");
		$.ajax({
			url : "${pageContext.request.contextPath }/api/phonebook/insert",		
			type : "post",
			//contentType : "application/json",
			data : {
				name : name,
				hp : hp,
				company : company
			},

			dataType : "json",
			success : function(result){
				/*성공시 처리해야될 코드 작성*/
				addtable(result);
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	function addtable(data){
		var str = "";
		str += ' <table border = "1">';
		str += ' 	<colgroup>';
		str += ' 		<col style = "width : 120px;">';
		str += ' 		<col style = "width : 170px;">';
		str += ' 	</colgroup>';
		str += ' 	<tbody>';
		str += ' 		<tr>';
		str += ' 			<td>이름(name)</td>';
		str += ' 			<td>'+data.name+'</td>';
		str += ' 		</tr>';
		str += ' 		<tr>';
		str += ' 			<td>핸드폰(hp)</td>';
		str += ' 			<td>'+data.hp+'</td>';
		str += ' 		</tr>';
		str += ' 		<tr>';
		str += ' 			<td>회사(company)</td>';
		str += ' 			<td>'+data.company+'</td>';
		str += ' 		</tr>';
		str += ' 		<tr>';
		str += ' 			<td><a href="/study/phone/updateForm">수정</a></td>';
		str += ' 			<td><a href="/study/phone/delete">삭제</a></td>';
		str += ' 		</tr>';
		str += ' 	</tbody>';
		str += ' </table>';
		str += ' <br>';
		$("div").append(str);
	}
</script>
</html>