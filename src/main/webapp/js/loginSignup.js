const SignUpButton = document.getElementById('signUp');
const SignInButton = document.getElementById('signIn');
const container = document.getElementById('container');

SignUpButton.addEventListener('click', function () {
    container.classList.add('right-panel-active')
})

SignInButton.addEventListener('click', function () {
    container.classList.remove('right-panel-active')
})

document.getElementById("signUpForm").addEventListener('submit', event => {
    event.preventDefault();
    let xhr = new XMLHttpRequest();//创建XMLHttpRequest对象
    let username = document.getElementById("signUpUsername").value;
    let email = document.getElementById("signUpEmail").value;
    let password = document.getElementById("signUpPassword").value;
    xhr.open('POST', "UserServlet?action=signup", true);//设置请求的参数
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");//设置请求头的参数
    xhr.onreadystatechange = function () {
        if (this.status === 200 && this.readyState === 4) {//成功响应执行的操作
            let msg = JSON.parse(this.responseText);
            if (msg.message === "signUpSuccessfully") {
                document.getElementById("signIn").click();
                document.getElementById("loginUsername").value = username;
                document.getElementById("loginFailedText").innerHTML = "注册成功! 请输入密码登录";
            } else {
                // console.log(this.responseText);
                document.getElementById("signUpFailedText").innerHTML = "用户名已经被占用了!";
                document.getElementById("signUpUsername").value = "";
            }
        } else if (this.status === 404) {
            console.log("请求的网页不存在");
        }
    }
    xhr.send("username=" + username + "&password=" + password + "&email=" + email);//发送请求
});

document.getElementById("loginForm").addEventListener('submit', event => {
        event.preventDefault();
        let xhr = new XMLHttpRequest();
        let username = document.getElementById("loginUsername").value;
        let password = document.getElementById("loginPassword").value;
        xhr.open('POST', "UserServlet?action=login", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
        xhr.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                let msg = JSON.parse(this.responseText);
                // console.log(msg.message);
                if (msg.message === "loginSuccessfully") {
                    // console.log(this.responseText);
                    window.localStorage.setItem("type", JSON.stringify(msg.type));
                    window.localStorage.setItem("username", JSON.stringify(msg.username));
                    window.localStorage.setItem("userID", JSON.stringify(msg.userID));
                    window.localStorage.setItem("password", JSON.stringify(msg.password));
                    window.localStorage.setItem("email", JSON.stringify(msg.email));
                    document.getElementById("container").style.setProperty('transform', 'rotateY(-90deg)');
                    // document.getElementById("container").style.display = "none";
                    // document.getElementById("welcomeContainer").style.display = "flex";
                    sleep(600).then(() => {
                        document.getElementById("welcomeContainer").style.setProperty('z-index', '100)');
                        document.getElementById("welcomeContainer").style.setProperty('transform', 'rotateY(0deg)');
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
                    // console.log(this.responseText);
                    document.getElementById("loginFailedText").innerHTML = "请输入正确的用户名和密码!";
                    document.getElementById("loginPassword").value = "";
                }
            } else if (this.status === 404) {
                console.log("请求的网页不存在");
            }
        }
        xhr.send("username=" + username + "&password=" + password);
    }
);

document.getElementById("menuLink").addEventListener('click', event => {
    event.preventDefault();
    alert("请先登录!");
})

// 等待一段时间再执行
function sleep(time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}