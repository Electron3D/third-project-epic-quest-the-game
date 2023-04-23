<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Epic Quest: The Game</title>
    <link href="static/styles.css" rel="stylesheet">
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
</head>
<body>
<div class="welcomePage">
    <h1>Epic Quest</h1>
    <h3>The Game</h3>
</div>
<div class="welcomePage">
    <button onclick="start()">Start adventure</button>
    <button onclick="statLoad()">Stats</button>
</div>

<script>
    function start() {
        $.ajax({
            url: '/start',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            async: false,
            success: function () {
                location.reload();
            }
        });
    }
    function statLoad() {
        /*$.ajax({
            url: '/stat',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            async: false,
            success: function () {
                location.reload();
            }
        });*/
    }
</script>
</body>
</html>