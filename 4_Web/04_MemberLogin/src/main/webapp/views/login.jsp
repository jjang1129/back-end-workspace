<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>   <!-- 로그인 : 아이디, 비밀번호 입력 받아서 
                          호출 : /login, 방식 : post 
                          LoginServlet : 세션 데이터 바인딩! 
                          index.jsp로 이동 -> 로그인 된 경우 
                  -->
         <h1>로그인 </h1>
         
         <form action="/login" method="post">
          아이디 : <input type="text" name="id"> <br>
          비밀번호 : <input type="password" name="password"> <br>
          <input type="submit" value="로그인">
         </form>
             
</body>
</html>