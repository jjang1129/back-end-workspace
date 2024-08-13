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
             <h1>회원가입</h1>
             
             <form id="frm">
              아이디 : <input type="text" name="id" id="id"><br>
              비밀번호 : <input type="password" name="password" id="password"> <br>
              이름 : <input type="text" name="name" id="name"> <br>
              <input type="button" value="가입" id="btn">             
             </form>
             
             <div id="result"></div>
             
             
             <script>
             $("#btn").click(()=>{
            	 const id  = $("#id").val()
            	 const password = $("#password").val()
            	 const name = $("#name").val()
            	 
            	 
            	 
            	 $.ajax({
            		type : "post", // post 방식으로 
            		url : "/serial", // /serial로 
            	 	data : {           //$("#frm").serialize() 묶어서 보낼 수 있음 
            			id:id,
            			password:password,
            			name:name,
            		}, // id,password, name값 넘겨서 회원가입 하고 
            		 
            		success : function(result){
            			console.log(result)
            			$("#result").html("아이디 : " +result.id +"<br>"+"비밀번호 : " + result.password +"<br>"+"이름 : " + result.name);
            			if(result.length === 0){
            				$("#result").html("중복된아이디 입니다 ")
            			}
            		}
            	//	error: function(){
            	//		alert("회원가입 실패!");
            	//	}
            		
            		
            		
            		 // 돌아와서 result에 정보기재 
            	 });
             })
             
             
             
             </script>
</body>
</html>