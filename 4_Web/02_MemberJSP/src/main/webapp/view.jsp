<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
  %>
  <%@page import="java.util.ArrayList"  %>
 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%ArrayList<Member> list =(ArrayList<Member>)request.getAttribute("list"); 
  %>
  <%-- search 랑 매피할 SearchServlet 생성 
  search.jsp 결과 보여주기  --%>
  <h2> 회원 조회 </h2>
  <form action="search">
  검색할 회원 아이디를 입력해주세요 <br>
  <input type="text" name="id">
  <input type="submit" value = "조회">
  </form>
    <h1>전체 리스트 </h1>
    
     <table border="1">
     <tr>
      <th>아이디</th> 
     
         
      <th>비밀번호</th>
       
      <th>이름</th>
      
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
  
    
    
   
    
     
      
    <%-- getAttribute로 리스트로 가지고 오시고 for문 활용!  --%>
    
    
     </table>
</body>
</html>