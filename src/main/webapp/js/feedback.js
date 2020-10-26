document.getElementById("feedbackForm").addEventListener('submit', event => {
    event.preventDefault();
    let nickname = document.getElementById("nickname").value;
    let email = document.getElementById("email").value;
    let rates = document.getElementById("rates").value;
    let suggestion = document.getElementById("suggestion").value;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "FeedbackServlet?action=addFeedback", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    xhr.onreadystatechange = function () {
        if (this.status === 200 && this.readyState === 4) {
            let msg = JSON.parse(this.responseText);
            if (msg.message === "addFeedbackSuccessfully") {
                document.getElementById("welcomeContainer").style.opacity="0";
                sleep(600).then(() => {
                    document.getElementById("welcomeText").innerHTML = "提交成功";
                    document.getElementById("countdown").innerHTML = "将在3s后转到主页";
                    document.getElementById("welcomeContainer").style.opacity="1";
                    let x = 3;
                    const int = setInterval(function () {
                        x--;
                        document.getElementById("countdown").innerHTML = "将在" + x + "s后转到主页";
                        if (x === 0) {
                            clearInterval(int);
                            window.location.href = "main.jsp";
                        }
                    }, 1000);
                });
            } else {
                console.log(this.responseText);
            }
        } else if (this.status === 404) {
            console.log("请求的网页不存在");
        }
    }
    xhr.send("nickname=" + nickname + "&email=" + email + "&rates=" + rates + "&suggestion=" + suggestion);
});

// 等待一段时间再执行
function sleep(time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}
