package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//mysite를 만들었을 때 Controller의 역할에 따라 url이 board나 user 등이 추가되었고 그 다음에 list, update와 같은 역할에 대한 내용이 왔습니다
//ex) localhost:8088/user/list

//Spring에서 controller에 대한 url추가

//방법 1. RequestMapping할 때 controller에 대한 url을 추가하는 방법
//@Controller
//public class base2 {
//	@RequestMapping("/user/list")
//	public String list() {
//		
//		return "";
//	}
//	
//	@RequestMapping("/user/update")
//	public String update() {
//		
//		return "";
//	}
//}

//방법2. @Controller 아래에 @RequestMapping로 묶는 방법

@Controller
@RequestMapping("/user")
public class Base2{
	@RequestMapping("/list")
	public String list() {
		
		return"";
	}
}

//두 방법 모두 브라우저에서 localhost:8088/user/list로 입력해야 접근이 가능하다

