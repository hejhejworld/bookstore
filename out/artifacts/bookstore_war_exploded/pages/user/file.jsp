<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>file</title>
    <base href="http://localhost:8080/bookstore/">
</head>
<body>
    <form enctype="multipart/form-data" method="post" action="file">
        用户名<input type="text" name="username">
        <div>file<input type="file" name="file"></div>
        <div><input type="submit"></div>

    </form>
</body>
</html>