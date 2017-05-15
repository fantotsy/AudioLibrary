<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="/AudioLibrary/resources/css/home.css">

        <script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript" ></script>
        <script type="text/javascript">
        $(document).ready(function() {
            $("#test").click(function(){
                $.get("/AudioLibrary/test");
            });
        });
        </script>

    </head>
    <body>
        <h1>${greeting}</h1>
        <form action="play" method="get">
            <label for="audio-selection">Choose audio</label>
            <input id="audio-selection" name="audio" type="file">
            <input type="submit"/>
        </form>
        <button id="test">AJAX</button>
    </body>
</html>