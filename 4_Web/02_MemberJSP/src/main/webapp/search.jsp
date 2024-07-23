<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Member member = (Member)request.getAttribute("member"); %>
<h1>회원 조회 결과</h1>

<%if(member == null){ %>
	<h1>일치하는 아이디의 회원이 없습니다 ㅠㅠ </h1>
<% }else {%>
	<ul>
	<li>아이디 : <%=member.getId() %> </li>
	<li>비밀번호 : <%=member.getPassword() %> </li>
	<li>이름 : <%=member.getName() %></li>
	</ul>	
<% } %>


</body>
</html>