<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员注册页面</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.jpg">
        <div>
            <span>欢迎<span class="um_span">${sessionScope.username}</span>光临书城</span>
            <a href="order/order.jsp">我的订单</a>
            <a href="userservlet?action=logout">注销</a>&nbsp;&nbsp;
        </div>
    </div>

    <div id="main">
        <h1>登录成功 <a href="index.jsp">转到主页</a></h1>
    </div>

    <div id="bottom">
        <span>
            书城.Copyright &copy;2022
        </span>
    </div>
</body>
</html>