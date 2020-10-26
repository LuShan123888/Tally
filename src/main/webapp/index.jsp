<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录注册</title>
    <link rel="stylesheet" href="css/loginSignup.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="img/accountBook.png">
</head>
<body>
<%@ include file="header.jsp" %>
<div id="welcomeContainer">
    <h1>登录成功!</h1>
    <span id="countdown">将在3s后转到主页</span>
</div>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form id="signUpForm">
            <h1>注册</h1>
            <label>
                <input id="signUpUsername" type="text" placeholder="用户名" maxlength="15"
                       required="required">
            </label>
            <label>
                <input id="signUpEmail" type="email" placeholder="邮箱" maxlength="20"
                       required="required">
            </label>
            <label>
                <input id="signUpPassword" type="password" placeholder="密码" maxlength="15"
                       required="required">
            </label>
            <span class="message" id="signUpFailedText"></span>
            <button type="submit">注册</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form id="loginForm">
            <h1>登录</h1>
            <label>
                <input id="loginUsername" type="text" placeholder="用户名" maxlength="15"
                       required="required">
            </label>
            <label>
                <input id="loginPassword" type="password" placeholder="密码" maxlength="15"
                       required="required">
            </label>
            <a href="#" id="forget">忘记密码?</a>
            <span class="message" id="loginFailedText"></span>
            <button type="submit">登录</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>已有账户?</h1>
                <h5>请使用账号密码登录</h5>
                <button class="ghost" id="signIn">登录</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>没有账户?</h1>
                <h5>现在注册加入我们</h5>
                <button class="ghost" id="signUp">注册</button>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="footer.jsp" %>
<script src="js/loginSignup.js"></script>
</html>