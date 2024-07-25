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
     <h1>회원 검색 결과</h1>
       <h2>아이디 : <%=member.getId() %> </h2>
         <h2>비밀번호 : <%=member.getPassword() %> </h2>
           <h2>이름 : <%=member.getName() %> </h2>
</body>
</html>