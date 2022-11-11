<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <base href="http://localhost:8080/bookstore/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script src="static/script/jquery-3.6.1.js"></script>
    <script type="text/javascript">
        $(function () {

            //失去焦点时，使用ajxs判断用户名是否已存在
            $("#username").blur(function () {
                var username = this.value;
                $.getJSON("http://localhost:8080/bookstore/userservlet",
                    "action=existUsername&username=" + username,
                    function (data) {
                        if (data.result)
                            $("span.errorMsg").text("用户名已存在");
                        else
                            $("span.errorMsg").text("用户名可用");
                    }
                )
            })

            /**
             * 单击验证码图片更新验证码，
             * 单机时会修改src属性使其发起新的请求获取验证码，
             * 为了防止浏览器缓存造成无法更新，所以在请求末尾加上当前时间作为请求参数
             */
            $("#codeimg").click(function () {
                this.src = "kaptcha?d=" + new Date();
            })

            //检查表单内容
            $("#sub_btn").click(function () {
                //判断用户名是否合法
                let usernameText = $("#username").val();
                let usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(usernameText)) {
                    $("span.errorMsg").text("用户名不合法");
                    return false;
                }

                //判断密码是否合法，数字字母下划线，长度5-12
                let password = $("#password").val();
                let passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(password)) {
                    $("span.errorMsg").text("密码不合法");
                    return false;
                }

                //判断两次密码是否相同
                let repwd = $("#repwd").val();
                if (password != repwd) {
                    $("span.errorMsg").text("用户密码与确认密码不一致");
                    return false;
                }

                //邮箱地址是否合法
                let email = $("#email").val();
                let emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(email)) {
                    $("span.errorMsg").text("邮箱地址不合法");
                    return false;
                }

                //验证码是否为空
                let code = $("#code").val();
                if (code == null || code == "") {
                    $("span.errorMsg").text("验证码不能为空");
                    return false;
                }

                $("span.errorMsg").text("");
            })
        })
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.jpg">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册会员</h1>
                    <a href="pages/user/login.jsp">立即登录</a>
                    <span class="errorMsg">${empty requestScope.errorMge ? "" : requestScope.errorMge}</span>
                </div>
                <div class="form">
                    <form action="userservlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="5~12的数字字母或下划线" autocomplete="off" tabindex="1"
                               name="username" id="username" value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="5~12的数字字母或下划线" autocomplete="off" tabindex="1"
                               name="password" id="password" value="${requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd" value="${requestScope.repwd}"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
                        <img id="codeimg" alt="验证码" src="kaptcha" style="float: right; margin-right: 40px" ; width="80px" ;
                             height="40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="bottom">
			<span>
				书城.Copyright &copy;2022
			</span>
</div>
</body>
</html>