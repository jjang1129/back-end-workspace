<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>로그인 </h1>
  <% Member mem =(Member)session.getAttribute("info"); 
  	Integer count = (Integer) request.getAttribute("count");
  		String value= null;
  %>
  <% if(count >=5 ) 
	  { Cookie c1 = new Cookie("id", "ddd");
		c1.setMaxAge(20);
		response.addCookie(c1); 
 	value=c1.getValue();
 	System.out.println(value);
 	value.equals("ddd");
 	System.out.println(value.equals("ddd"));
 	}
	  %>
  	<form action="/login" method="post">
          아이디 : <input type="text" name="id"> <br>
          비밀번호 : <input type="password" name="password" ${value.equals("ddd") ? 'disabled' : ''}> <br>
          <input type="submit" value="로그인">
          <p style="color: red">아이디 또는 비밀번호가 틀렸습니다</p>
        
  	
        
       <% if( count > 0){ %>
           <p> <%= count %>회 실패</p>
          
     <%  } %>
         </form>
             

</body>
</html>