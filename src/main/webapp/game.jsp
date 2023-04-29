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
<h1 class="textInCenter">Test</h1>
<div class="textInCenter">${game.getGamerName()}</div>
<div class="textInCenter" id="eventDescriptor">${nextNode.getEventDescription()}</div>
<div class="textInCenter" id="decisionButtons">
    <button onclick="start(true)">${nextNode.getPositiveDecision()}</button>
    <button onclick="start(false)">${nextNode.getNegativeDecision()}</button>
</div>
<c:if test="${gameEnd == true}">
    <script>
        $("#eventDescriptor").hide();
        $("#decisionButtons").hide();
    </script>
    <h1 class="textInCenter">${resultText.toString()}</h1>
    <div class="textInCenter">
        <button value="restart" onclick="restart(value)">Start again</button>
        <button value="mainMenu" onclick="restart(value)">Main menu</button>
    </div>
</c:if>

<script>
    function start(decision) {
        let decisionStr = "decision=" + decision;
        window.location='/logic?' + decisionStr;
    }
    function restart(value) {
        if ("restart" === value) {
            $.ajax({
                url: '/restart',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                async: false,
                success: function () {
                    window.location='/start';
                }
            });
        } else {
            $.ajax({
                url: '/restart',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                async: false,
                success: function () {
                    window.location='/welcome.html';
                }
            });
        }
    }
</script>
</body>
</html>