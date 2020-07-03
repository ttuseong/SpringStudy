package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

//url에서 값을 읽는 두가지 방법

//방법 1-1
//url로 전달된 값의 이름과 일치하는 값을 가져오는 방식
//@Controller
//public class GetSet {
//	@RequestMapping("/write")
//	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp, @RequestParam("company") String company) {
//		System.out.println(name + ", " + hp + ", " + company);
//		return "redirect:/phone/list";
//	}
//}

//방법 1-2
//값을 읽을 때 없는 값에 대해 기본 값 설정하는 방법
//@RequestMapping("/write")
//public String write(@RequestParam("name") String name, @RequestParam("hp") String hp,
//					@RequestParam(value="company", required = false, defaultValue = "000") String company) {
//	System.out.println(name + ", " + hp + ", " + company);
//	return "redirect:/phone/list";
//}

//방법 2
//url로 전달된 값을 class로 묶는 방법
//조건 1. 기본 생성자가 있어야한다.
//조건 2. 넘어온 값들을 넣어줄 생성자가 있어야한다.
//조건 3. 넘어온 값의 이름이랑 class에 있는 변수의 이름이 일치해야한다.
//ex) localhost:8088/user/list?name="하이"로 온 경우 class에 name이라는 변수가 있어야한다.
//조건 4.setter가 있어야한다.

//@RequestMapping("/write")
//public String write(@ModelAttribute PersonVo vo) {
//	System.out.println(vo.toString());
//
//	PhoneDao phoneDao = new PhoneDao();
//	phoneDao.personInsert(vo);
//	
//	//리턴할 때 redirect가 없으면 포워드
//	return "redirect:/phone/list";
//}

//jsp로 값을 보내는 방법
//그동안 HttpServlet을 상속받았기 때문에 requset와 session을 통해 jsp로 값을 전달했는데
//Front Controller와 역할을 나눔으로써 상속할 필요가 없어졌고 request와 session을 사용하지 못하게 되었습니다.
//그래서 값을 전달하기 위해 새롭게 model이 추가되었습니다.
//@RequestMapping(value = "/list", method=RequestMethod.GET)
//public String list(Model model) {
//	System.out.println("list");
//	
//	PhoneDao phoneDao = new PhoneDao();
//	List<PersonVo> list = phoneDao.getPersonList();
//	
//	System.out.println(list.toString());
//	
//	model.addAttribute("list", list);
//	
//	return "/WEB-INF/views/list.jsp";
//}