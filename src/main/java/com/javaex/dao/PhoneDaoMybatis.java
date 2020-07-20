package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDaoMybatis {
	@Autowired
	private SqlSession sqlsession;
	
	//업데이트용 검색
	public PersonVo getPerson(int no) {
		
		System.out.println(no);
		
		PersonVo vo = sqlsession.selectOne("phonebook.getPerson", no);
		
		return vo;
	}
	
	// 사람 리스트(검색할때)
	public List<PersonVo> getPersonList() {
		List<PersonVo> list =  sqlsession.selectList("phonebook.getList");
		
		return list;
	}

	// 사람 추가
	public int personInsert(PersonVo personVo) {
		int count;
		
		count = sqlsession.insert("phonebook.personInsert", personVo);
		
		return count;
	}

//	// 사람 수정
	public int personUpdate(PersonVo personVo) {
		int count = 0;
		
		count = sqlsession.update("phonebook.personUpdate", personVo);
		
		return count;
	}

	// 사람 삭제
	public int personDelete(int personId) {
		int count = 0;
		
		count = sqlsession.delete("phonebook.personDelete", personId);
		
		return count;
	}
	
	public void insertByAjax(PersonVo personVo) {
		sqlsession.insert("phonebook.insertByAjax", personVo);
	}

}