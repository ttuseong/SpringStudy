package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDaoMybatis;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneControllerPool {
	//datasource나 mybatis를 사용하여 Dao롤 자동으로 생성할 계획이기 때문에 메소드에 있던 PhoneDao의 생성 부분을
	//필드로 빼고 자동으로 생성해주는 것을 알려줘야하기 때문에 Autowired 어노테이션을 추가합니다.
	@Autowired
	private PhoneDaoMybatis phoneDao;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list");
		List<PersonVo> list = phoneDao.getPersonList();
		
		System.out.println(list.toString());
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(@ModelAttribute PersonVo vo) {
		System.out.println(vo.toString());
		
		phoneDao.personInsert(vo);

		return "redirect:/phone/list";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(Model model, @RequestParam("id") int id) {
		System.out.println("update");

		PersonVo vo = phoneDao.getPerson(id);
		
		model.addAttribute("vo", vo);
		
		return"updateForm";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute PersonVo vo) {
		
		phoneDao.personUpdate(vo);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, @RequestParam("id") int id) {
		
		phoneDao.personDelete(id);
		
		return "redirect:/phone/list";
	}

}
