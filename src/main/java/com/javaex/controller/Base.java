//package com.javaex.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

//url에 localhost:8088/path/list를 입력하면 list.jsp로 포워드해줍니다.

//value에 들어간 값이 받게 될 url이 됩니다.
//method에 들어간 값은 get과 post 방식 중 어떤 방식으로 받을 지 결정하고 두 방법 모두 사용할 경우 괄호를 이용해서 묶습니다.
//@Controller
//public class base {
//	@RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
//	public String list() {
//		
//		return "/WEB-INF/views/list.jsp";
//	}
//}

//GET만 받는 경우

//@Controller
//public class base {
//	@RequestMapping(value = "/list", method= RequestMethod.GET)
//	public String list() {
//		
//		return "/WEB-INF/views/list.jsp";
//	}
//}

//POST만 받는 경우

//@Controller
//public class base {
//	@RequestMapping(value = "/list", method= RequestMethod.POST)
//	public String list() {
//		
//		return "/WEB-INF/views/list.jsp";
//	}
//}


//축약형
//method를 안쓴 경우 GET과 POST 방식 모두 받는 것이 기본 값으로 설정되고, method가 없기 때문에 값을 구분할 필요가 없어서 value도 생략이 가능합니다.
//@Controller
//public class Base {
//
//	@RequestMapping("/list")
//	public String list() {
//		
//		return "/WEB-INF/views/list.jsp";
//	}
//}

//View Resolver에서 추가적인 셋팅을 한 경우
//리턴 부분에서 포워딩에 공통적인 부분을 생략할 수 있게 도와준다
//@Controller
//public class Base {
//
//	@RequestMapping("/list")
//	public String list() {
//		
//		return "list";
//	}
//}

//작성 팁 : @con을 입력 후 Ctrl + Space를 누르면 목록에 @Controller이 나타나고 엔터를 누르면 자동으로 임포트 작업도 이루어집니다
//       같은 방법으로 @req를 입력한 후 Ctrl + Space를 누르면 목록에@RequestMapping가 나타납니다.

