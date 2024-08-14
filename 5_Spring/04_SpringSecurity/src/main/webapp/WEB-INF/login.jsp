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
                   <h1>로그인</h1>
                   <form id="frm">
				아이디 : <input type="text" name="id"><br>
				비밀번호 : <input type="text" name="password"> <br>
				
				<input type="submit" value="로그인" id="login">
				</form>

		<script>
		$("#login").click((e)=>{
			e.preventDefault(); // 기존 이벤트 제거 
			$.ajax({
				url : "/login",
				type : "post",
				data : $("#frm").serialize(), // 폼태그의 모든 값들 한꺼번에 전송 
				success : function(data){
					console.log(data) // 토큰 값 확인 ! 
					// 토큰 값 -> localStorage에 저장 (브라우저내의 임시 저장 공간) 삭제하지 않는한 계속 남아 있음 or 강제로 지우지 않는 이상 
					localStorage.setItem("token",data)
					location.href="/";
					
				}
				
				
			});
			
		});
		
		</script>
</body>
</html>