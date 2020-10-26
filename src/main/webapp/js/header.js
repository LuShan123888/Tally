if (window.localStorage.getItem("userID") === null) {
    document.getElementById("accountBar").innerHTML = `
    <a href="index.jsp">登录 / 注册</a>`;
} else {
    let username = window.localStorage.getItem("username");
    username = username.substr(1); //删除首字符
    username = username.substring(0, username.length - 1); //删除最后末字符
    document.getElementById("accountBar").innerHTML = `
    <a id="SignOutButton" style="cursor:pointer ">登出</a>
    <a href="#">${username}</a>`;

}
if (document.getElementById("SignOutButton") != null) {
    document.getElementById("SignOutButton").addEventListener('click', event => {
        event.preventDefault();
        window.localStorage.clear();
        let xhr = new XMLHttpRequest();
        xhr.open('GET', "UserServlet?action=signOut", true);
        xhr.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                window.location.href = "index.jsp";
            } else if (this.status === 404) {
                console.log("请求的网页不存在");
            }
        }
        xhr.send();
    });
}