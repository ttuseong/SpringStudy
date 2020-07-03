package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list");
		
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> list = phoneDao.getPersonList();
		
		System.out.println(list.toString());
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	@RequestMapping("/write")
	public String write(@ModelAttribute PersonVo vo) {
		System.out.println(vo.toString());

		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(vo);

		return "redirect:/phone/list";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(Model model, @RequestParam("id") int id) {
		System.out.println("update");
		
		PhoneDao phoneDao = new PhoneDao();
		PersonVo vo = phoneDao.getPerson(id);
		
		model.addAttribute("vo", vo);
		
		return"/WEB-INF/views/updateForm.jsp";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute PersonVo vo) {
		PhoneDao phoneDao = new PhoneDao();
		
		phoneDao.personUpdate(vo);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, @RequestParam("id") int id) {
		PhoneDao phoneDao = new PhoneDao();
		
		phoneDao.personDelete(id);
		
		return "redirect:/phone/list";
	}

}
