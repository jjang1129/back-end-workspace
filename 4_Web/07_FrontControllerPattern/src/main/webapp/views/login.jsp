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
         
        
  	<form action="front" method="post">
  	<input type="hidden" name="command" value="login">
          아이디 : <input type="text" name="id"> <br>
          비밀번호 : <input type="password" name="password"  > <br>
          <input type="submit" value="로그인" ${ ck.value.equals("ck") ? 'disabled' : '' }>
          <p style="color: red">아이디 또는 비밀번호가 틀렸습니다</p>
          <p>              ${count}회 실패        ${ck.value.equals("ck")}       </p>
        
  	
       
   
         </form>
         
        <script>
        	console.log(document.cookie === 'ck=ck');
        </script>
             
             
</body>
</html>