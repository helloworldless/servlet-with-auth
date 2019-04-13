<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
</head>
<style>
    body {
        font-family: 'Open Sans', sans-serif;
        text-align: center;
    }
</style>
<body>
    <h1>Home</h1>
    <%
        String userName = (String) request.getAttribute("userName");
        out.println(String.format("<p>Welcome to the app, %s</p>", userName));
    %>
    <%
        String contextPath = request.getContextPath();
        out.println(String.format("<p><a href=%s/clearCookie>Clear cookie and try again</a></p>", contextPath));
    %>
</body>
</html>