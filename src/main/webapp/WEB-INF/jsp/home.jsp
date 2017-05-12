<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="/AudioLibrary/resources/css/home.css">
    </head>
    <body>
        <h1>${greeting}</h1>
        <form action="play" method="get">
            <label for="audio-selection">Choose audio</label>
            <input id="audio-selection" name="audio" type="file">
            <input type="submit"/>
        </form>
    </body>
</html>