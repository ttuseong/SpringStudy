# Controller
Clinet의 요청을 어떻게 처리할지 정의하고 어떻게 응답할지 결정하는 곳
  
# API Controller
ajax를 통해 접근할 컨트롤러
  
# Service
프로그램에서 실세계의 규칙에 따라 데이터를 생성·표시·저장·변경하는 곳

# 예시
1. 사용자가 웹 브라우저에 url을 입력해서 서버에 요청을 보낸다
2. controller에서 url에 맞게 입력을 받고 응답에 필요한 값을 얻기 위해 service를 호출합니다.
3. service는 Dao를 통해 데이터를 받거나 받은 데이터를 이용하여 controller에서 필요한 값을 만들어줍니다.
4. service에서 필요한 값을 받은 controller은 사용자에게 값을 전달합니다.
  
# DAO
Data Access Object로 데이터에 접근하기 위해 만든 클래스입니다.  
현재 데이터는 데이터베이스에 저장했기 때문에 데이터베이스에 접근해서 사용자의 요청을 처리합니다.
# Vo
Value Object로 값을 저장하기 위해 만든 클래스입니다.