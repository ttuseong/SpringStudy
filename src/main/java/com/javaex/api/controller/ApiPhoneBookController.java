package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/api/phonebook")
public class ApiPhoneBookController {
	@Autowired
	private PhoneService phoneService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<PersonVo> list(){
		List<PersonVo> list = phoneService.list();
		
		System.out.println("api/list" + list.toString());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public PersonVo insert(@RequestBody PersonVo personVo){
		
		phoneService.writeByAjax(personVo);
		
		return personVo;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public int delete(@RequestParam("id") int id) {
		System.out.println(id);
		return phoneService.delete(id);
	}
}
