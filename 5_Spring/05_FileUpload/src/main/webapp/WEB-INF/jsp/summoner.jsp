<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>롤 전적 검색</title>
</head>
<body>
<h1>롤 전적 검색</h1>
<form action="/summoner" method="get">
    <input type="text" name="gameName" placeholder="소환사 이름" required />
     <input type="text" name="tagLine" placeholder="태그" required />
    <button type="submit">검색</button>
</form>

<c:if test="${not empty summoner}">
    <h2>소환사 정보</h2>
    <p>ID: ${summoner.puuid}</p>
    <p>이름: ${summoner.gameName}</p>
    <p>태그: ${summoner.tagLine}</p>
</c:if>

<h1>${codeList}</h1>
<h1>첫번째 경기의 승패 여부눈? ${test}</h1>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
