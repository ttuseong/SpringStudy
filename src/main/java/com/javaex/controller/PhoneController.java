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
	
//	@RequestMapping("/write")
//	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp, @RequestParam("company") String company) {
//		System.out.println(name + ", " + hp + ", " + company);
//		return "redirect:/phone/list";
//	}
	
//	@RequestMapping("/write")
//	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp,
//						@RequestParam(value="company", required = false, defaultValue = "000") String company) {
//		System.out.println(name + ", " + hp + ", " + company);
//		return "redirect:/phone/list";
//	}
	
	
	@RequestMapping("/write")
	public String write(@ModelAttribute PersonVo vo) {//사용할 때 기본 생성자가 있어야한다, 넘어온 파라미터 값이랑 생성자에 있는 파라미터 값이랑 이름이 일치해야한다, set도 있어야함
		System.out.println(vo.toString());

		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(vo);
		
		//리턴할 때 redirect가 없으면 포워드
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
	public String update(Model model, @RequestParam("id") int id) {
		PhoneDao phoneDao = new PhoneDao();
		
		phoneDao.personDelete(id);
		
		return "redirect:/phone/list";
	}

}
