// document.getElementById("transactions-date").addEventListener('click', event => {
//     console.log(document.getElementById("transactions-date").value);
// });
document.getElementById("transactionButton").addEventListener('click', event => {
    document.getElementById("transactionButton").src = "img/billActive.png";
    document.getElementById("outflowButton").src = "img/outflowNormal.png";
    document.getElementById("inflowButton").src = "img/inflowNormal.png";
    // document.getElementById("transactionContainer").style.display = "flex";
    // document.getElementById("outflowContainer").style.display = "none";
    // document.getElementById("inflowContainer").style.display = "none";
    document.getElementById("outflowContainer").style.transform = "translateX(100%)";
    document.getElementById("inflowContainer").style.transform = "translateX(100%)";
    document.getElementById("transactionContainer").style.transform = "translateX(0)";
});
document.getElementById("outflowButton").addEventListener('click', event => {
    document.getElementById("transactionButton").src = "img/billNormal.png";
    document.getElementById("outflowButton").src = "img/outflowActive.png";
    document.getElementById("inflowButton").src = "img/inflowNormal.png";
    // document.getElementById("transactionContainer").style.display = "none";
    // document.getElementById("outflowContainer").style.display = "flex";
    // document.getElementById("inflowContainer").style.display = "none";
    document.getElementById("transactionContainer").style.transform = "translateX(100%)";
    document.getElementById("inflowContainer").style.transform = "translateX(100%)";
    document.getElementById("outflowContainer").style.transform = "translateX(0)";
});
document.getElementById("inflowButton").addEventListener('click', event => {
    document.getElementById("transactionButton").src = "img/billNormal.png";
    document.getElementById("outflowButton").src = "img/outflowNormal.png";
    document.getElementById("inflowButton").src = "img/inflowActive.png";
    // document.getElementById("transactionContainer").style.display = "none";
    // document.getElementById("outflowContainer").style.display = "none";
    // document.getElementById("inflowContainer").style.display = "flex";
    document.getElementById("transactionContainer").style.transform = "translateX(100%)";
    document.getElementById("outflowContainer").style.transform = "translateX(100%)";
    document.getElementById("inflowContainer").style.transform = "translateX(0)";
});
window.onload = getTransactions();

function getTransactions() {
    if (window.localStorage.getItem("type") === "\"normal\"") {
        let xhr = new XMLHttpRequest();
        xhr.open('GET', "TransactionServlet?action=getTransaction", true);
        xhr.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                let msg = JSON.parse(this.responseText);
                if (msg[msg.length - 1].message === "getTransactionSuccessfully") {
                    msg.forEach(function (element) {
                        if (element.flow === "inflow") {
                            let oDiv = document.createElement('div');
                            oDiv.innerHTML = `       <span>日期:${element.date}</span>
                                                <span>类别:${element.type}</span>
                                                <span>标记:${element.remark}</span>
                                                <span>金额:${element.amount}</span>
                                               <span style="flex-basis: 100%;">备注:${element.note}</span>
                            `;
                            oDiv.classList.add("transactionItem");
                            document.getElementById("inflowBox").appendChild(oDiv);
                        } else if (element.flow === "outflow") {
                            let oDiv = document.createElement('div');
                            oDiv.innerHTML = `       <span>日期:${element.date}</span>
                                                <span>类别:${element.type}</span>
                                                <span>标记:${element.remark}</span>
                                                <span>金额:${element.amount}</span>
                                               <span style="flex-basis: 100%;">备注:${element.note}</span>
                            `;
                            oDiv.classList.add("transactionItem");
                            document.getElementById("outflowBox").appendChild(oDiv);
                        }
                    })
                    // console.log(this.responseText);
                } else {
                    console.log(this.responseText);
                }
            } else if (this.status === 404) {
                console.log("请求的网页不存在");
            }
        }
        xhr.send();
    } else {
        let xhr = new XMLHttpRequest();
        xhr.open('GET', "FeedbackServlet?action=getFeedback", true);
        xhr.onreadystatechange = function () {
            if (this.status === 200 && this.readyState === 4) {
                let msg = JSON.parse(this.responseText);
                if (msg[msg.length - 1].message === "getFeedbackSuccessfully") {
                    document.getElementById("content").classList.add("showFeedback");
                    document.getElementById("content").innerHTML = null;
                    msg.forEach(function (element) {
                        let oDiv = document.createElement('div');
                        oDiv.innerHTML = `<span>昵称:${element.nickname}</span>
                                          <span>评分:${element.rates}</span>
                                          <span style="flex-basis: 100%">邮箱:${element.email}</span>
                                          <span style="flex-basis: 100%">建议:${element.suggestion}</span>
                            `;
                        oDiv.classList.add("feedbackItem");
                        document.getElementById("content").appendChild(oDiv);
                    })
                    console.log(this.responseText);
                } else {
                    // console.log(this.responseText);
                }
            } else if (this.status === 404) {
                console.log("请求的网页不存在");
            }
        }
        xhr.send();
    }
}

document.getElementById("transactionButton").addEventListener('click', event => {
    document.getElementById("inflowBox").innerHTML=null;
    document.getElementById("outflowBox").innerHTML=null;
    getTransactions();
})

document.getElementById("outflowContainer").addEventListener('submit', event => {
    event.preventDefault();
    let date = document.getElementById("outflowDate").value;
    let type = document.getElementById("outflowType").value;
    let remark = document.getElementById("outflowRemark").value;
    let amount = document.getElementById("outflowAmount").value;
    let note = document.getElementById("outflowNote").value;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "TransactionServlet?action=addTransaction", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    xhr.onreadystatechange = function () {
        if (this.status === 200 && this.readyState === 4) {
            let msg = JSON.parse(this.responseText);
            if (msg.message === "addTransactionSuccessfully") {
                document.getElementById("messageBanner").style.opacity = "1";
                sleep(1500).then(() => {
                    document.getElementById("messageBanner").style.opacity = "0";
                    console.log(this.responseText);
                });
            } else {
                document.getElementById("message").style.color = "black";
                document.getElementById("message").innerHTML = "提交失败";
                document.getElementById("messageBanner").style.opacity = "1";
                sleep(1500).then(() => {
                    document.getElementById("messageBanner").style.opacity = "0";
                    console.log(this.responseText);
                });
                console.log(this.responseText);
            }
        } else if (this.status === 404) {
            console.log("请求的网页不存在");
        }
    }
    xhr.send("date=" + date + "&type=" + type + "&remark=" + remark + "&amount=" + amount + "&note=" + note + "&flow=outflow");

});
document.getElementById("inflowContainer").addEventListener('submit', event => {
    event.preventDefault();
    let date = document.getElementById("inflowDate").value;
    let type = document.getElementById("inflowType").value;
    let remark = document.getElementById("inflowRemark").value;
    let amount = document.getElementById("inflowAmount").value;
    let note = document.getElementById("inflowNote").value;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "TransactionServlet?action=addTransaction", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    xhr.onreadystatechange = function () {
        if (this.status === 200 && this.readyState === 4) {
            let msg = JSON.parse(this.responseText);
            if (msg.message === "addTransactionSuccessfully") {
                document.getElementById("messageBanner").style.opacity = "1";
                sleep(1500).then(() => {
                    document.getElementById("messageBanner").style.opacity = "0";
                    console.log(this.responseText);
                });
            } else {
                document.getElementById("message").style.color = "black";
                document.getElementById("message").innerHTML = "提交失败";
                document.getElementById("messageBanner").style.opacity = "1";
                sleep(1500).then(() => {
                    document.getElementById("messageBanner").style.opacity = "0";
                    console.log(this.responseText);
                });
                console.log(this.responseText);
            }
        } else if (this.status === 404) {
            console.log("请求的网页不存在");
        }
    }
    xhr.send("date=" + date + "&type=" + type + "&remark=" + remark + "&amount=" + amount + "&note=" + note + "&flow=inflow");

});

// 等待一段时间再执行
function sleep(time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}

