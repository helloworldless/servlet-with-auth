<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Authentication</title>
</head>
<style>
    body {
        font-family: 'Open Sans', sans-serif;
        text-align: center;
    }
</style>
<body>
    <h1>Authentication</h1>
    <p>Please authenticate to access the app</p>
    <form method="POST" action="requestAuth">
        <label for="userName">
            <span>User name:&nbsp;</span>
            <input id="userName" type="text" name="userName" />
            <button type="submit">Submit</button>
        </label>
    </form>
</body>
</html>