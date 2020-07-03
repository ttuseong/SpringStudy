package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

//리턴할 때 redirect가 있으면 redirect로, 없으면 forword로 처리됩니다.
@Controller
public class Redirect {
	@RequestMapping("/write")
	public String write(@ModelAttribute PersonVo vo) {
		System.out.println(vo.toString());
	
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(vo);
		
		//redirect
		return "redirect:/phone/list";
	}
	
//	@RequestMapping("/write")
//	public String write(@ModelAttribute PersonVo vo) {
//		System.out.println(vo.toString());
//	
//		PhoneDao phoneDao = new PhoneDao();
//		phoneDao.personInsert(vo);
//		
		//forword
//		return "WEB-INF/views/list.jsp";
//	}
}
