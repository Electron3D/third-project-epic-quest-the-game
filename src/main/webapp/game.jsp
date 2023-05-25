<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Epic Quest: The Game</title>
    <link href="static/styles.css" rel="stylesheet">
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="centered">
    <div class="fixedWidth" id="eventName"><h1>${nextNode.getName()}</h1></div>
    <div class="fixedWidth" id="eventDescriptor">${nextNode.getEventDescription()}</div>
    <br>
    <div id="decisionButtons">
        <button onclick="start(true)">${nextNode.getPositiveDecision()}</button>
        <button onclick="start(false)">${nextNode.getNegativeDecision()}</button>
    </div>
    <c:if test="${gameEnd == true}">
        <script>
            $("#eventName").hide();
            $("#eventDescriptor").hide();
            $("#decisionButtons").hide();
        </script>
        <div class="fixedWidth">
            <h1>${resultText.toString()}</h1>
        </div>
        <div>
            <button value="restart" onclick="restart(value)">Start again</button>
            <button value="mainMenu" onclick="restart(value)">Main menu</button>
        </div>
    </c:if>
</div>

<div class="stats">
    <table class="statTable">
        <tr id="header">
            <td>Имя</td>
            <td>Побед</td>
            <td>Проигрышей</td>
        </tr>
        <tr>
            <td>${game.getGamerName()}</td>
            <td>${victoryTimes.toString()}</td>
            <td>${defeatedTimes.toString()}</td>
        </tr>
    </table>
    <hr>
    <p>IP адресс игрока: ${ip.toString()}</p>
</div>

<script>
    function start(decision) {
        let decisionStr = "decision=" + decision;
        window.location='/logic?' + decisionStr;
    }
    function restart(value) {
        if ("restart" === value) {
            let gamerName = "${game.getGamerName()}";
            window.location='/start?gamerName=' + gamerName;
        } else {
            window.location='/welcome.html';
        }
    }
</script>
</body>
</html>