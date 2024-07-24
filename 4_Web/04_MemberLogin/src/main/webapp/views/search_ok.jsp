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
     
       <h1>아이디 : <%=member.getId() %> </h1>
         <h1>비밀번호 : <%=member.getPassword() %> </h1>
           <h1>이름 : <%=member.getName() %> </h1>
</body>
</html>