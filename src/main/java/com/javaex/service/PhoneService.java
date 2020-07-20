package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDaoMybatis;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {

	@Autowired
	PhoneDaoMybatis phoneDao;
	
	public List<PersonVo> list(){
		
		return phoneDao.getPersonList();
	}
	
	public int write(PersonVo personVo) {
		return phoneDao.personInsert(personVo);
	}
	
	public PersonVo updateForm(int id) {
		return phoneDao.getPerson(id);
	}
	
	public int update(PersonVo vo) {
		return phoneDao.personUpdate(vo);
	}
	
	public int delete(int id) {
		return phoneDao.personDelete(id);
	}
	
	public void writeByAjax(PersonVo personVo) {
		phoneDao.insertByAjax(personVo);
	}
}
