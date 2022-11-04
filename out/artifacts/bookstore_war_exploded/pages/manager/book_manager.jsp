<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script src="static/script/jquery-3.6.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                //confirm返回一个boolean值，点击确认时返回true，点击取消时返回false。返回false时click事件不执行
                return confirm("确认删除图书" + $(this).parent().parent().find("td:first").text() + "?");
            })
            //指定页面跳转
            $("#jumpBtn").click(function () {
                let currentPage = $("#pn_input").val();
                location.href = "http://localhost:8080/bookstore/manager/bookservlet?action=page&currentPage=" + currentPage;
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">图书管理</span>
    <div>
        <a href="order_manager.jsp">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.bookname}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookservlet?action=queryBookById&bookid=${book.bookid}&method=updateBook">修改</a>
                </td>
                <td><a class="deleteClass" href="manager/bookservlet?action=deleteBook&bookid=${book.bookid}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?method=addBook">添加图书</a></td>
        </tr>
    </table>
    <div id="page_nav">
        <c:if test="${requestScope.page.currentPage > 1}">
            <a href="manager/bookservlet?action=page&currentPage=1">首页</a>
            <a href="manager/bookservlet?action=page&currentPage=${requestScope.page.currentPage - 1}"> 上一页</a>
            <a href="manager/bookservlet?action=page&currentPage=${requestScope.page.currentPage - 1}">${requestScope.page.currentPage - 1}</a>
        </c:if>

        【${requestScope.page.currentPage}】

        <c:if test="${requestScope.page.currentPage < requestScope.page.pageTotal}">
            <a href="manager/bookservlet?action=page&currentPage=${requestScope.page.currentPage + 1}">${requestScope.page.currentPage + 1}</a>
            <a href="manager/bookservlet?action=page&currentPage=${requestScope.page.currentPage + 1}">下一页</a>
            <a href="manager/bookservlet?action=page&currentPage=${requestScope.page.pageTotal}"> 末页</a>
        </c:if>
        共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
        到第<input name="pn" id="pn_input" value="${param.currentPage}"/>页
        <input id="jumpBtn" type="button" value="确定">
    </div>
</div>

<div id="bottom">
		<span>
			书城.Copyright &copy;2022
		</span>
</div>
</body>
</html>