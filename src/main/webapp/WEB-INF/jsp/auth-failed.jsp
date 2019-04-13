<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Authentication Failed</title>
</head>
<style>
    body {
        font-family: 'Open Sans', sans-serif;
        text-align: center;
    }
</style>
<body>
    <h1>Authentication Failed</h1>
    <%
        String contextPath = request.getContextPath();
        out.println(String.format("<p><a href=%s/auth>Try again</a></p>", contextPath));
    %>
</body>
</html>