
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
첫 번째 사진처럼 Maven 프로젝트로 전환시키면 두 번째 사진처럼 pom.xml이 나온다. 
이 pom을 통해 개발자는 라이브러리 추가가 가능하다.
  
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