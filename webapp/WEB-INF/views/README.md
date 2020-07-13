# el
JSP의 출력 문법을 대체하는 표현 언어입니다.  

- 예시
	1. 파라미터에 있는 a의 값을 가져오는 방법
${param.a}
	2. 파라미터 외 값을 받아오는 방법
${reqeustScope.a}
	3.	2번에서 객체 Scope 부분을 생략한 방법
${a}  
생략해서 사용할 경우 page, request, session, application 순으로 우선 순위가 높습니다.

- 자주 사용되는 내장 객체
  
|내장 객체                       |설명                         |
|-------------------------------|-----------------------------|
|pageScope           |page Scope에 접근하기 위한 객체|
|reqeustScope           |request Scope에 접근하기 위한 객체|
|sessionScope|session Scope에 접근하기 위한 객체|
|applicationScope           |application Scope에 접근하기 위한 객체|
|param          |파라미터 값을 가져오기 위한 객체|
|header|헤더 값을 가져오기 위한 객체|
|cookie            |쿠키 값을 가져오기 위한 객체|
|initParam            |JSP 초기 파라미터를 가져오기 위한 객체|
|pageContext|pageContext 객체에 접근하기 위한 객체|

# jstl
JSTL은 태그를 통해 JSP 코드를 관리하는 라이브러리로서, JSP의 가독성이 좋아집니다.
  
주로 조건문과 반복문을 사용할 때 사용됩니다.
```
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
```
라이브러리이기 때문에 임포트 과정이 필요하고, 위에 내용이 임포트 내용입니다.
  
- if문  
```
<c:if test="조건">
	조건이 참일 때 실행됩니다.
</c:if>
```
if-else는 사용이 불가능하기 때문에 필요한 경우 choose문으로 대체해서 사용합니다.
-  choose문
```
<c:choose>
	<c:when test="조건1">
		조건1이 참일 때 실행됩니다.
	</c:when>
	<c:when test="조건2">
		조건1이 참일 때 실행됩니다.
	</c:when>
	<c:otherwise>
		모든 조건이 참이 아닐 때 사용됩니다.
	</c:otherwise>
```
if문과 choose문에 test가 있는데 이는 예약어라 다른 내용으로 변경이 불가능합니다.
- foreach문
1. 배열처럼 사용하는 방법
```
<c:forEach var="사용할 값" begin="시작값" end="끝값" step="증가값">
	반복 내용
</c:forEach>
```
  
2. 배열, 리스트에서 값을 하나씩 얻는 방법
```
<c:forEach items=${el로 가져온 배열이나  리스트} var="사용할 값"
	반복 내용
</c:forEach>
```
- 그외 추가적으로 활용가능한 속성들
cout: 루프 실행 횟수  
first: 현재 실행이 루프의 첫 번째 실행인 경우  
end: 현재 실행이 루프의 마지막 실행인 경우  
