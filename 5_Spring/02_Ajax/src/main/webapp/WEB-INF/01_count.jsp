<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!--  Ajax (Asynchronous JavaScript and XML) : 비동기적 정보 교환 기법 -->
   <h1>Show Count</h1>
   <input type="button" id="btn" value="count 증가" onclick="startRequest()">
   <p id=result><p>
   
   
   <!-- 자바스크립트 방식  -->
   <script >
   let xhr;
   
   function startRequest(){ // 요청에 해당하는 로직을 담는 메서드 
	   
	   xhr = new XMLHttpRequest();
       xhr.onreadystatechange= callback;
       xhr.open("get","/count"); 
       xhr.send(null); // 이때 서버로 전송된다.. 실질적인 요청이 들어간다.
      
	   
   }
   
   function callback(){ //응답에 해당하는 로직을 담는 메서드 
	   
	   
           if(xhr.readyState === 4){  // 4까지 뜨면 응답을 시작할수있다 
	         if(xhr.status == 200){ // 200이면 성공
	        	// alert(xhr.responseText);  // 컨트롤러의 반환 타입이 responseText로 온다 !
	        	const count = xhr.responseText;
	        	 document.querySelector("#result").innerHTML= count;
	         }
           }
       
   }
   
   </script>
</body>
</html>