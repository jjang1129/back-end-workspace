<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<style>
span {
font-weight:  bolder;
font-size:32px;
color: "red";
}
</style>
<body>

           <h1>회원가입</h1>
           
           아이디 : <input type="text" id="id">
           <input type="button" value="아이디 사용하기" id="idCheck" disabled="disabled">
           <span id="idCheckView"></span> 
           
           <!-- 중복체크 버튼을 눌렀을 때 post 방식으로 
            /check로 id값을 넘겨서 결과값은(boolean)을 받아서 
            아이다가 있으면 ID 사용 불가 
            없으면 ID 사용 가능 
            DB는 스키마 : member, 테이블 : member 
            -->
             <!-- jQuery -->
    <script>
    
    $("#id").keyup(()=>{
    	const id= $("#id").val()
    	$.ajax({
    		// 요청 
    		type : "post",
    		url : "/check",
    	   data : "id="+id,	
   		// 응답 
   		    success : function(result){
   		    	
   		    	if(result){
   		    		$("#idCheckView").css("color","green").text("사용가능 ID");
   		    		$("#idCheck").attr("disabled",false);
   		    		
   		    	}else {
   		    		$("#idCheckView").css("color","red").text("사용불가 ID");
   		    		$("#idCheck").attr("disabled",true);
   		    	}
   		    }
    	});
    	
    	
    });
    $("#idCheck").click(()=>{
    	
    	$("#id").prop("readonly",true);
    })
    
    
    
  
    
    
    
    </script>
    
</body>
</html>