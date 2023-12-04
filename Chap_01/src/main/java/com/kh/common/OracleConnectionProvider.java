package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionProvider {
	private static final String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUser = "khbank";
	private static final String jdbcPaswword = "khbank";
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPaswword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SQLException("JDBC 드라이버를 찾을 수 없습니다.", e);
		}
	}
}
