package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.DAO;
import com.kh.model.vo.DTO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/selectUser")
public class UserServlet extends HttpServlet {
	
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자로부터 입력받은 데이터 처리 및 DAO 호출 작업을 수행
 		List<DTO> userList;
		try {
	 		//2.값이 일치할 경우 
			userList = DAO.selectAllUsers();
			//1.만약에 비어있지 않거나 null값이 아닐 때는 전제조회
	 		if(userList != null && !userList.isEmpty()) {
	 			request.setAttribute("userList", userList);
	 			request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
	 		}else {
	 	 		//3. 검색 결과가 없을때
	 			request.getRequestDispatcher("/searchError.jsp").forward(request, response);
	 		}
	 		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}

	}

}
