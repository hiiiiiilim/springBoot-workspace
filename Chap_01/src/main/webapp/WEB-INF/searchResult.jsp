<%@page import="java.util.List"%>
<%@page import="com.kh.model.vo.DTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%
 	List<DTO> userList = (List<DTO>) request.getAttribute("user_name");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�˻����</title>
</head>
<body>
	<h1>��ȸ���</h1>
	<table border="1">
		<thead>
			<tr>
				<th>����� ��ȣ</th>
				<th>����� id</th>
				<th>����� �̸�</th>
				<th>����� ����</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(DTO user : userList){
			%>
				<tr>
					<td><%=user.getUser_number() %></td>
					<td><%=user.getUser_id() %></td>
					<td><%=user.getUser_name() %></td>
					<td><%=user.getUser_age() %></td>
				</tr>
			<%		
				}
			%>
		</tbody>
	</table>
</body>
</html>