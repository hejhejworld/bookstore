<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script src="static/script/jquery-3.6.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button.addToCart").click(function () {
                let bookid = $(this).attr("bookid");
                location.href = "http://localhost:8080/bookstore/cartservlet?action=addItem&id=" + bookid;
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.username}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a>
        </c:if>
        <c:if test="${not empty sessionScope.username}">
            <span>欢迎<span class="um_span">${sessionScope.username}</span>光临书城</span>
            <a href="order/order.jsp">我的订单</a>
            <a href="userservlet?action=logout">注销</a>&nbsp;&nbsp;
            <a href="index.jsp">返回</a>
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">

    <div id="book">

        <div class="book_cond">
            <form action="clientbookservlet" method="get">
                <input type="hidden" name="action" value="queryBooksByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>

        <div style="text-align: center">
            <span>您的购物车中有
                <c:if test="${empty sessionScope.cart.totalCount}"> 0 </c:if>
                <c:if test="${not empty sessionScope.cart.totalCount}"> ${sessionScope.cart.totalCount} </c:if>
                件商品
            </span>
            <div>
                <c:if test="${not empty sessionScope.lastItemName}">
                    <span style="color: red">
                            ${sessionScope.lastItemName}
                    </span>已添加到购物车
                </c:if>
            </div>
        </div>

        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="static/img/default.jpg"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.bookname}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button id="bookadd" class="addToCart" bookid="${book.bookid}">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <div id="page_nav">
        <c:if test="${requestScope.page.currentPage > 1}">
            <a href="${requestScope.page.url}&currentPage=1">首页</a>
            <a href="${requestScope.page.url}&currentPage=${requestScope.page.currentPage - 1}"> 上一页</a>
            <a href="${requestScope.page.url}&currentPage=${requestScope.page.currentPage - 1}">${requestScope.page.currentPage - 1}</a>
        </c:if>

        【${requestScope.page.currentPage}】

        <c:if test="${requestScope.page.currentPage < requestScope.page.pageTotal}">
            <a href="${requestScope.page.url}&currentPage=${requestScope.page.currentPage + 1}">${requestScope.page.currentPage + 1}</a>
            <a href="${requestScope.page.url}&currentPage=${requestScope.page.currentPage + 1}">下一页</a>
            <a href="${requestScope.page.url}&currentPage=${requestScope.page.pageTotal}"> 末页</a>
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