<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <th>아이디</th>       
      <th>비밀번호</th>    
      <th>이름</th>
      <% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");%>
     </tr> 
    <% for( int i=0; i< list.size(); i++){
    	String id = list.get(i).getId() ;
    	String pwd = list.get(i).getPassword();
    	String name =list.get(i).getName();%>
    	<tr>
        <td><%=id %></td>
        <td> <%=pwd %></td>
        <td><%=name %></td>
       </tr>
       
    	
   <% }%> 
  
         
</body>
</html>