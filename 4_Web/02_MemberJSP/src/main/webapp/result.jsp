<%--
   JSP Element 
   1) 지시어 %@ ~ % : 컨테이너에게 알려줄 내용 지정 
   2) 스클릿틀릿 %~%: 자바 코드는 이안에 지정 
   3) 출력문 %=~% : 출력하는 내용 지정 

 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
  <%-- jsp 주석 : 소스보기 화면에 보이지 않음  --%>
  <!-- HTML 주석 : 소스보기 화면에 보임 -->
  <% Boolean check =(Boolean)(request.getAttribute("check"));
     System.out.println(check); if(!check){ %>
    	<%-- 가입 성공시  --%>
		    	   <h1>회원가입 완료되었습니다..!</h1>
		   <% String name=(String)request.getAttribute("name"); %>
		  
		  <h2><%=name %>님, 환영합니다!</h2>
		 
    	  
     <%  } else { %>
    	<%-- 가입 실패시  --%>
    	 <h1>회원 가입 실패 ㅠㅠ</h1>
    <%     }   %>
  
  

  
   

   
  
  
  
 
   
    
  </body>
</html>
