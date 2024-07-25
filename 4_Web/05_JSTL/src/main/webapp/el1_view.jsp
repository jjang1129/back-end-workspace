<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
              <% int a =1; %>
              <h2> 1) 기존 방식 </h2>
              <p> request : <%=request.getAttribute("result")%></p>
              <p> session : <%=session.getAttribute("result2") %></p>
             
                 <p> session : <%=a %></p>

             <%--
                EL 
                 - Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술 
                 - 바인딩한 ${값}이 사용한다.
             
              --%>
              <h2> 2) EL </h2>
              <p> request :  ${requestScope.result}  </p>
              <p> session :  ${sessionScope.result2}  </p>
              <p> ${result2}  </p>
</body>
</html>