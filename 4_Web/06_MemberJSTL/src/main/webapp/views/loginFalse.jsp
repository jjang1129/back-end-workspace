<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.Cookie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>로그인 </h1>
 
 
   
  	<form action="/login" method="post">
          아이디 : <input type="text" name="id"> <br>
          비밀번호 : <input type="password" name="password"  > <br>
          <input type="submit" value="로그인" ${ count >= 5 ? 'disabled' : '' }>
          <p style="color: red">아이디 또는 비밀번호가 틀렸습니다</p>
          <p>              ${count}회 실패                  </p>
        
  	
        
   
         </form>
             

</body>
</html>