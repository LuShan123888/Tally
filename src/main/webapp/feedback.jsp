<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户反馈</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/feedback.css" type="text/css">
    <link rel="shortcut icon" href="img/accountBook.png">
</head>
<jsp:useBean id="feedback" scope="session" class="com.example.bean.FeedbackBean"/>
<body>
<%@ include file="header.jsp" %>
<div class="content">
    <div id="welcomeContainer">
        <h1 id="welcomeText">你喜欢这个网站吗?</h1>
        <span id="countdown">告诉我们你的想法</span>
    </div>
    <form id="feedbackForm">
        <div class="inputBar">
            <label for="nickname">昵称:</label>
            <input type="text" id="nickname" maxlength="15">
        </div>
        <div class="inputBar">
            <label for="email">邮箱:</label>
            <input type="email" id="email" maxlength="20">
        </div>
        <div class="inputBar">
            <label for="rates" style="width:80%;">请给这个网站打分:</label>
            <select id="rates" default="10">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10" selected>10</option>
            </select>
        </div>
        <div class="suggestion">
            <label for="suggestion">你认为有哪些地方需要改进?</label>
            <textarea id="suggestion" maxlength="2000"></textarea>
        </div>
        <input type="submit" value="提交">
    </form>
</div>
<%@ include file="footer.jsp" %>
<script src="js/feedback.js"></script>
</body>
</html>
