package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.DTO;

public class DAO {
	//사용자를 조회하기 위해 작성할 sql 문을 생성
	
	//사용자가 있는지 확인하기 위해 전체 사용자를 조회하는 sql문을 작성
	//1. 사용자가 있는지 확인하기 위해 전체 사용자를 조회하는 sql문
	//1. 사용자가 있는지 확인하기 위해 전체 사용자를 조회하는 sql문
	public static List<DTO> selectAllUsers() throws SQLException {
		// 1-1 커넥션 연결하기 위한 getConnection()
		Connection conn = JDBCTemplate.getConnection();
		// 1-2 PreparedStatement = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 1-3 List로 조회된 내용을 모두 담을 수 있는 배열 생성
		List<DTO> userList = new ArrayList<>();
		
		String query = "SELECT * FROM TEST_USER";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		// 전체 출력같은 경우 while 문을 이용해서 전체 출력
		while (rs.next()) {
			DTO user = new DTO();
			user.setUser_number(rs.getInt("USER_NUMBER"));
			user.setUser_id(rs.getString("USER_ID"));
			user.setUser_name(rs.getString("USER_NAME"));
			user.setUser_age(rs.getInt("USER_AGE"));
			userList.add(user);
		}
		return userList;
	}
	
	//2.내가 검색한 사용자가 있는지 확인하기 위해 입력한 사용자를 조회하는 sql문
	public static List<DTO> selectUserById(String userId) throws SQLException{
		Connection conn = JDBCTemplate.getConnection();
		
		List<DTO> userList = new ArrayList<>();
		
		String sql = "select * from test_user where user_id =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userId);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			DTO user = new DTO();
			user.setUser_number(rs.getInt("USER_NUMBER"));
			user.setUser_id(rs.getString("USER_ID"));
			user.setUser_name(rs.getString("USER_NAME"));
			user.setUser_age(rs.getInt("USER_AGE"));
			userList.add(user);
		}
		return userList;
	}
}
