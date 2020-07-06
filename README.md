
 # DispatchedServlet & MVC

![spring](https://user-images.githubusercontent.com/38309884/86424289-1d35fc80-bd1d-11ea-8454-cbb33c29a765.png)
  
① ~ ⑦은 사용자가 요청했을 때 진행 순서  
②, ④, ⑤는 ①의 기능들입니다.  
③은 개발자가 만들어주는 부분으로 servlet이 아닌 class 파일로 만듭니다.  
⑥ View는 jsp 파일입니다.
  
### Handler Mapping  
요청 정보를 기준으로 어떤 컨트롤러를 사용할 지 결정하는 역할  
(@Controller, @RequestMapping에 대한 처리 역할)  
  
### ModelAndView  
개발자가 만든 Controller의 처리 결과를 보여줄 view와 사용할 값을 전달하는 역할  
  
### View Resolver  
Controller가 리턴한 뷰 정보를 통해 뷰를 찾는 역할  
  
# Maven
jar 파일을 다운받아 프로젝트에 추가할 경우 그것과 연관된 다른 종속 라이브러리 또한 찾아야 하는 불편함이 있는데 Maven을 통해서 일관성 있는 라이브러리간의 의존관계 (의존성) 관리를 할 수 있다.  
  
### 설정방법
![maven setting](https://user-images.githubusercontent.com/38309884/86428217-2d52d980-bd27-11ea-9a6b-f7dc7f646298.png)
![pom](https://user-images.githubusercontent.com/38309884/86429026-3b095e80-bd29-11ea-8f0c-ecf190da8190.png)
<br>첫 번째 사진처럼 Maven 프로젝트로 전환시키면 두 번째 사진처럼 pom.xml이 나온다. 
이 pom을 통해 개발자는 라이브러리 추가가 가능하다.

### 에러 잡는 법
가끔 문법에 문제가 없는데 에러 표시가 나올 경우가 있습니다.  
이 경우 Maven을 통해 설치한 모든 파일을 지우고 다시 설치하는 방법으로 에러를 해결할 수 있습니다.  
  
![clean](https://user-images.githubusercontent.com/38309884/86512060-827f1000-be39-11ea-94b3-88d777798634.png)

![updateproject](https://user-images.githubusercontent.com/38309884/86512059-81e67980-be39-11ea-8c6d-3d551b9f1a7f.png)
![update](https://user-images.githubusercontent.com/38309884/86512061-8317a680-be39-11ea-9112-72a7a46078ab.png)
  
업데이트를 할 때 Force Update of Snapshos/Releases를 클릭 후 진행해야 합니다.

### 라이브러리 추가 방법

![pom setting](https://user-images.githubusercontent.com/38309884/86429579-f5e62c00-bd2a-11ea-8ab2-b9d7c184cb1d.png)
  
위에 사진은 Spring을 사용하기 위해 라이브러리를 추가하는 것으로 여러 dependency를 추가할 예정이기 때문에 dependencies로 묶고 Spring에 사용될 라이브러리는 버전이 같아야하기 때문에 위에 properties로 버전에 대한 내용을 따로 묶었습니다.
  
![maven libraries](https://user-images.githubusercontent.com/38309884/86429603-07c7cf00-bd2b-11ea-804f-777f002a90a0.png)
  
설정 후 파일을 저장하면 Libraries에 MavenDependencies가 생기고 그 안에 jar 파일이 추가된 것을 확인할 수 있습니다.
  
### 라이브러리 검색 방법
![maven search](https://user-images.githubusercontent.com/38309884/86430437-4068a800-bd2d-11ea-8795-198425e96b99.png)
  
필요한 라이브러리를 검색을 하면 Maven Repository와 연결된 링크들이 나옵니다.
  
![maven version](https://user-images.githubusercontent.com/38309884/86430451-478fb600-bd2d-11ea-8b8e-f75491e684a4.png)
  
클릭하면 여러 버전들이 나오고 사용할 버전을 클릭합니다.  
  
![maven code](https://user-images.githubusercontent.com/38309884/86430459-4c546a00-bd2d-11ea-97d4-1fdce22fdac3.png)
클릭을 하면 다음과 같은 화면으로 이동되고 dependency 부분을 복사하여 pom.xml에 추가합니다.  
  
### pool
pool에 대한 개념은 웹뿐만 아니라 다양한 분야에서 활용이 되는데 이 개념을 게임 쪽에서 사용하는 것을 예시로 생각하면 쉽게 와닿는 것 같습니다.  
게임을 플레이한다고 가정했을 때 플레이어가 있는 필드에는 매우 많은 몬스터가 있습니다.  플레이어는 이 몬스터들을 잡는 과정에서 그 몬스터에 대한 정보를 없애고 일정 시간이 지난 후에 다시 생성하는 과정이 반복적으로 발생하는데, 만약 플레이어가 한 번에 많은 몬스터를 잡는다면 이 과정이 동시에 발생합니다.  
컴퓨터 입장에서는 부담되는 작업이 동시에 발생하여 렉의 원인이 될 수 있기 때문에 플레이어가 필드로 이동할 때 나오는 로딩 과정에서 몬스터를 미리 메모리에 올려두고 플레이어가 몬스터를 잡을 경우 메모리에서 지우는 과정이 아닌 화면에서만 안 보이게 처리를 하고 일정 시간이 흐른 뒤 다시 보이게 하는 과정을 반복하여 문제를 해결합니다.  
이처럼 특정 수 만큼 미리 메모리에 올려두고 사용이 끝나도 메모리에 계속 남겨두어 다시 사용하는 방법이 pool입니다.
  
### mybatis
XML이나 어노테이션을 사용하여 SQL과 객체를 연결시켜주는 프레임워크  
  
기존에 [JDBC](https://github.com/ttuseong/SpringStudy/blob/master/src/main/java/com/javaex/dao/PhoneDao.java)로 코딩했을 경우 사용자의 입력값과 SQL을 통해 얻게 될 값에 대한 처리가 힘든 점을 보완한 방법으로 설정만 잘 되었다면 [DAO](https://github.com/ttuseong/SpringStudy/blob/master/src/main/java/com/javaex/dao/PhoneDaoMybatis.java)와 [SQL](https://github.com/ttuseong/SpringStudy/blob/master/src/main/resources/mybatis/mappers/phonebook.xml)에 대한 코딩이 간편해진 모습을 확인할 수 있다.
  
[다음 셋팅으로 이동]


[다음 셋팅으로 이동]:https://github.com/ttuseong/SpringStudy/tree/master/webapp/WEB-INF