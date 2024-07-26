<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 전체회원보기 : views/allMember.jsp에 리스트 출력  -->
         <h1>전체 회원 보기 </h1>
         
          <table border="1">
     <tr>
       <th>번호</th>
      <th>아이디</th>       
      <th>비밀번호</th>    
      <th>이름</th>   
     </tr> 
     
   
    <c:forEach items="${list}" var="member" varStatus="status" >
    
       	<tr>
       	<%-- index : 0부터, count : 1부터 시작  --%>
       	<td>${status.count}</td>
        <td>${member.id}</td>
        <td> ${member.password}</td>
        <td>${member.name}</td>
       </tr>
    
      
      </c:forEach>
      
      <p>${list.get(6)}</p>
      
      
  
         
</body>
</html>