<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script src="static/script/jquery-3.6.1.js"></script>
    <script type="text/javascript">
        $(function () {

            // 给 【删除】绑定单击事件
            $("a.deleteItem").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() +"】吗?")
            });
            // 给清空购物车绑定单击事件
            $("#clear").click(function () {
                return confirm("你确定要清空购物车吗?");
            })

            //更改购物车商品数量文本框时发生change事件
            $(".updateCount").change(function () {

                var name = $(this).parent().parent().find("td:first").text();
                var id = $(this).attr('bookid');
                //因为我把value写成了value()，在这里卡了半个多小时，我真的会谢。——来自凌晨四点的无语。
                var count = this.value;

                if (confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?")) {
                    location.href = "http://localhost:8080/bookstore/cartservlet?action=updateCount&count=" + count + "&id=" + id;
                } else {
                    this.value = this.defaultValue;
                }
            });
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
    <span class="wel_word">购物车</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.username}</span>访问书城</span>
        <a href="pages/order/order.jsp">我的订单&nbsp;</a>
        <a href="index.jsp">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
		<c:if test="${empty sessionScope.cart.items}">
			<tr>
                <td colspan="5">
			    	<a href="index.jsp">当前购物车为空，点击返回首页</a>
		    	</td>
            </tr>
		</c:if>
		<c:if test="${not empty sessionScope.cart.items}">
			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td>
                        <input type="text" style="width: 80px;" class="updateCount"
                               value="${entry.value.count}" bookid="${entry.value.id}">
                    </td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a class="deleteItem" href="cartservlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
				</tr>
			</c:forEach>
		</c:if>
    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clear" href="cartservlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderservlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<div id="bottom">
		<span>
			书城.Copyright &copy;2022
		</span>
</div>
</body>
</html>