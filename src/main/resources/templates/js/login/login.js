var time = 10;
/*改变首页到登录方法*/
function changeFirstPage() {
    var timeOut = window.setTimeout(changeFirstPage, 1000);
    time = time - 1;
    $(".secondTime").text(time);
    if (time <= 0) {
        window.clearTimeout(timeOut);
        var loginHtml =
            "<div class=\"login_putin\">" +
            "<p>Welcome</p><br/>" +
            "<ul><li>帐  号：<input type=\"text\" class='name' name=\"name\"></li>" +
            "<li>密  码：<input type=\"password\" class='password' name=\"password\"></li></ul>" +
            "<div class=\"login_btn\">" +
            "<input type=\"button\" value=\"登陆\" onclick='isLoginSuccess();'>" +
            "<input type=\"button\" value=\"游客\" >" +
            "<p class=\"err\" style='color:red;font-size: 16px;'></p>" +
            "</div></div>";

        $(".main").html(loginHtml);
    }
}

/*校验用户是否登录成功*/
function isLoginSuccess() {
    var name = $(".name").val();
    var password = $(".password").val();
    if (name == null || name == "") {
        $(".err").html("用户名不能为空");
        return
    }
    if (password == null || password == "") {
        $(".err").html("密码不能为空");
        return
    }
    $.ajax({
        type: "post",
        url: "/kyweb/userController/checkLogin",    //向springboot请求数据的url
        data: {
            name: name,
            password: password
        },
        success: function (data) {
            if (data.result) {
                var url = window.location.href;
                url = url + "userController/loginSuccess?name=" + name;
                window.location.href = url;
            } else {
                $(".err").html("帐号密码不正确，请校验");
            }
        }
    });
}

$(function () {
    changeFirstPage();
});