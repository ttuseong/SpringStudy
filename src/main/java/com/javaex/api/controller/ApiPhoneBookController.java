package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/api/phonebook")
public class ApiPhoneBookController {
	@Autowired
	private PhoneService phoneService;
	
	@ResponseBody
	@RequestMapping("/insert")
	public PersonVo list(@ModelAttribute PersonVo personVo){
		
		System.out.println(personVo.toString() + "*****************************");
		
		phoneService.write(personVo);
		
		return personVo;
	}
}
