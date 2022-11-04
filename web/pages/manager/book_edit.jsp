<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
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

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">编辑图书</span>
    <div>
        <a href="manager/bookservlet?action=queryBooks">返回图书管理</a>
        <a href="order_manager.jsp">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>
</div>

<div id="main">
    <form action="manager/bookservlet" method="post">
        <input type="hidden" name="action" value="${param.method}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <input type="hidden" name="bookid" value="${requestScope.book.bookid}"/>
                <td><input name="bookname" type="text" value="${requestScope.book.bookname}"/></td>
                <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<div id="bottom">
			<span>
				书城.Copyright &copy;2022
			</span>
</div>
</body>
</html>