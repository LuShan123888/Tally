<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>记账吧</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <link rel="shortcut icon" href="img/accountBook.png">
    <link rel="stylesheet" href="css/feedbackButton.css" type="text/css">
</head>
<body>
<%@ include file="header.jsp" %>
<div id="messageBanner">
    <span id="message">提交成功</span>
</div>
<div class="content" id="content">
    <div class="slideBar">
        <div class="selectButton ">
            <img id="transactionButton" src="img/billActive.png" alt="" draggable="false">
        </div>
        <div class="selectButton">
            <img id="outflowButton" src="img/outflowNormal.png" alt="" draggable="false">
        </div>
        <div class="selectButton">
            <img id="inflowButton" src="img/inflowNormal.png" alt="" draggable="false">
        </div>
    </div>
    <div class="transaction container" id="transactionContainer">
        <div class="separatorContainer">
            <h1>支出</h1>
            <div class="Box" id="outflowBox">
            </div>
        </div>
        <div class="separatorContainer">
            <h1>收入</h1>
            <div class="Box" id="inflowBox">
            </div>
        </div>
    </div>
    <form class="outflow container" id="outflowContainer">
        <div class="separatorContainer">
            <div class="inputBar">
                <label for="outflowDate">日期:</label>
                <input type="date" id="outflowDate" value="2020-01-01"/>
            </div>
            <div class="inputBar">
                <label for="outflowType">类型:</label>
                <select id="outflowType">
                    <option value="餐饮">餐饮</option>
                    <option value="学习">学习</option>
                    <option value="一般">一般</option>
                    <option value="居家">居家</option>
                    <option value="美容">美容</option>
                    <option value="数码">数码</option>
                    <option value="通讯">通讯</option>
                    <option value="零食">零食</option>
                    <option value="购物">购物</option>
                    <option value="娱乐">娱乐</option>
                    <option value="服饰">服饰</option>
                    <option value="交通">交通</option>
                    <option value="旅行">旅行</option>
                    <option value="社交">社交</option>
                    <option value="学习">学习</option>
                    <option value="运动">运动</option>
                    <option value="医疗">医疗</option>
                    <option value="宠物">宠物</option>
                    <option value="住房">住房</option>
                    <option value="理财">理财</option>
                    <option value="其他">其他</option>
                </select>
            </div>
            <div class="inputBar">
                <label for="outflowRemark">标记:</label>
                <input type="text" id="outflowRemark" maxlength="15">
            </div>
            <div class="inputBar">
                <label for="outflowAmount">金额:</label>
                <input type="text" id="outflowAmount" maxlength="20" oninput="value=value.replace(/[^\d]/g,'')"
                       required>
            </div>
        </div>
        <div class="textarea">
            <label for="outflowNote">备注</label>
            <textarea id="outflowNote" maxlength="2000"></textarea>
            <button type="submit" class="submitButton" id="outflowSubmitButton">提交</button>
        </div>
    </form>
    <form class="inflow container" id="inflowContainer">
        <div class="separatorContainer">
            <div class="inputBar">
                <label for="inflowDate">日期:</label>
                <input type="date" id="inflowDate" value="2020-01-01"/>
            </div>
            <div class="inputBar">
                <label for="inflowType">类型:</label>
                <select id="inflowType">
                    <option value="工资">工资</option>
                    <option value="兼职">兼职</option>
                    <option value="理财收益">理财收益</option>
                    <option value="礼金">礼金</option>
                    <option value="其他">其他</option>
                </select>
            </div>
            <div class="inputBar">
                <label for="inflowRemark">标记:</label>
                <input type="text" id="inflowRemark" maxlength="15">
            </div>
            <div class="inputBar">
                <label for="inflowAmount">金额:</label>
                <input type="text" id="inflowAmount" maxlength="20" oninput="value=value.replace(/[^\d]/g,'')" required>
            </div>
        </div>
        <div class="textarea">
            <label for="inflowNote">备注</label>
            <textarea id="inflowNote" maxlength="2000"></textarea>
            <button class="submitButton" type="submit" id="inflowSubmitButton">提交</button>
        </div>
    </form>
</div>
<div class="fixed">
    <div class="feedback">
        <a href='feedback.jsp' target='_self'>
            <img src="img/review.png" alt="review">
        </a>
    </div>
</div>
<script src="js/main.js"></script>
<%@ include file="footer.jsp" %>
</body>
</html>
