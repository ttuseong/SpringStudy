![spring](https://user-images.githubusercontent.com/38309884/86424289-1d35fc80-bd1d-11ea-8454-cbb33c29a765.png)
  
① ~ ⑦은 사용자가 요청했을 때 진행 순서  
②, ④, ⑤는 ①의 기능들입니다.  
③은 개발자가 만들어주는 부분으로 servlet이 아닌 class 파일로 만듭니다.  
⑥ View는 jsp 파일입니다.
  
## Handler Mapping  
요청 정보를 기준으로 어떤 컨트롤러를 사용할 지 결정하는 역할  
(@Controller, @RequestMapping에 대한 처리 역할)  
  
## ModelAndView  
개발자가 만든 Controller의 처리 결과를 보여줄 view와 사용할 값을 전달하는 역할  
  
## View Resolver  
Controller가 리턴한 뷰 정보를 통해 뷰를 찾는 역할  