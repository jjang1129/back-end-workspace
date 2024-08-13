<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>

          <h2>Encoding 처리하기</h2>
          닉네임 : <input  id="nick">
          <input type="button" value="닉네임 보내기" id="btn">
          <div id="result"> </div>
                   
         
           <!-- 자바 스크립트 방식  -->
           <!-- get 방식으로 /encoding <-- 닉네임 보내서 : 요청 
           해당 닉네임 받아서 result에 보여주기 물음표 ?  -->
           <!-- 자바스크립트 방식  -->
  <!--  <script>
   let xhr;
   
   function startRequest(){ // 요청에 해당하는 로직을 담는 메서드 
	   const nickname2 = document.querySelector("#nick").value;
	      console.log(document.querySelector("#nick").value);
	      
	   
	   xhr = new XMLHttpRequest();
       xhr.onreadystatechange= callback;
       xhr.open("get","/encoding?nickname="+ encodeURI(encodeURIComponent(nickname2))); //get 방식은 a링크 처럼 데이터 전송시 url로 값이 나옴  = ? 
       
    
       xhr.send(null); // 이때 서버로 전송된다.. 실질적인 요청이 들어간다. send는 post방식에서만 
      
	   
   }
   
   function callback(){ //응답에 해당하는 로직을 담는 메서드 
	   
	   
           if(xhr.readyState === 4){  // 4까지 뜨면 응답을 시작할수있다 
	         if(xhr.status == 200){ // 200이면 성공
	        	
	        //	 alert(xhr.responseText);  // 컨트롤러의 반환 타입이 responseText로 온다 !
	             const result = xhr.responseText;
	        document.querySelector("#result").innerHTML= decodeURI(decodeURIComponent(result));
	         }
           }
       
   }
   
   </script>
    -->
    
    <!-- jQuery -->
    <script >
    
    $("#btn").click(()=>{
    	const nickname= $("#nick").val()
    	$.ajax({
    		// 요청 
    		type : "get",
    		url : "/encoding",
    		data : "nickname=" + encodeURIComponent(nickname),
   		// 응답 
   		    success : function(result){
   		    	$("#result").text(result);
   		    }
    	});
    	
    	
    });
    
 
    
    </script>
    
    
</body>
</html>