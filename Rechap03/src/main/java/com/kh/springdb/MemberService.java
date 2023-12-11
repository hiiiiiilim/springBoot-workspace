package com.kh.springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.vo.MemberVO;
import com.kh.springdb.model.vo.dao.MemberDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberdao;
	
	public void insertMember(MemberVO member) {
		memberdao.insertMember(member);
	}
}
