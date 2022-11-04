<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">后台管理系统</span>
    <div>
        <a href="manager/bookservlet?action=page">图书管理</a>
        <a href="order_manager.jsp">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>
</div>

<div id="main">
    <h1>欢迎进入后台管理系统</h1>
</div>

<div id="bottom">
		<span>
			书城.Copyright &copy;2022
		</span>
</div>
</body>
</html>