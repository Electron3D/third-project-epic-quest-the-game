<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Epic Quest: The Game</title>
    <link href="static/styles.css" rel="stylesheet">
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
</head>
<body>
<h1 class="textInCenter">Test</h1>
<div class="textInCenter">${game.getGamerName()}</div>
<div class="textInCenter">${nextNode.getEventDescription()}</div>
<div class="textInCenter">
    <button onclick="start(true)">${nextNode.getPositiveDecision()}</button>
    <button onclick="start(false)">${nextNode.getNegativeDecision()}</button>
</div>

<script>
    function start(decision) {
        let decisionStr = "decision=" + decision;
        window.location='/logic?' + decisionStr;
    }
</script>
</body>
</html>