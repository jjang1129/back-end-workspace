<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div>
<div>
<c:forEach items="${firstGame.info.participants}" var="game" begin="0" end="4" step="1" varStatus="status"
>
<p>particpant ${game.teamId} ${game.riotIdGameName} / ${game.championName} / ${game.teamPosition}   K/D/A : ${game.kills} / ${game.deaths} / ${game.assists}  ${game.totalDamageDealtToChampions}</p>
</c:forEach>
</div>

<div>
<c:forEach items="${firstGame.info.participants}" var="game" begin="5" end="9" step="1" varStatus="status"
>
<p>particpant ${game.teamId} ${game.riotIdGameName} / ${game.championName} / ${game.teamPosition}   K/D/A : ${game.kills} / ${game.deaths} / ${game.assists}  ${game.totalDamageDealtToChampions}</p>
</c:forEach>
</div>

<c:forEach items="${firstGame.info.teams}" var="game1">
<p>teams ${game1.teamId},${game1.win}</p>

</c:forEach>

</div>

<h1>${codeList}</h1>
<c:forEach items="${result}" var="result">
<c:if test="${result.teamId == 100}">
<h3>블루팀</h3>
</c:if>
<c:if test="${result.teamId == 200}">
<h3>레드팀</h3>
</c:if>
<h3>${result.riotIdGameName}</h3>
<c:if test="${result.win == true}">
<h3>승리</h3>
</c:if>
<c:if test="${result.win == false}">
<h3>패배</h3>
</c:if>
</c:forEach>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
