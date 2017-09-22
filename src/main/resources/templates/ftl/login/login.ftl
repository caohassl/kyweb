<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link href="templates/css/common/common.css" type="text/css" rel="stylesheet">
    <link href="templates/css/login/login.css" type="text/css" rel="stylesheet">
    <title>登陆界面</title>
</head>
<script type="text/javascript" src="templates/js/common/jquery.min.js"></script>
<script type="text/javascript">
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
                    "<p class=\"err\" style='color:red;font-size: 16px;'></p>"+
                    "</div></div>";

            $(".main").html(loginHtml);
        }
    }

    /*校验用户是否登录成功*/
    function isLoginSuccess(){
        var name=$(".name").val();
        var password=$(".password").val();
        if(name==null||name==""){
            $(".err").html("用户名不能为空");
            return
        }
        if(password==null||password==""){
            $(".err").html("密码不能为空");
            return
        }
        $.ajax({
            type: "post",
            url: "/kyweb/userController/checkLogin",    //向springboot请求数据的url
            data: {
                name:name,
                password:password
            },
            success: function (data) {
            if(data.result){
                var url=window.location.href;
                url=url+"userController/loginSuccess?name="+name;
                window.location.href=url;
            }else {
                $(".err").html("帐号密码不正确，请校验");
            }
            }
        });
    }

    $(function () {
        changeFirstPage();
    });
</script>
<body>
<div class="main">
    <div class="login_ico">
        <p ><em class="secondTime" style="color: red;">5</em>&nbsp;秒后进入登录页面......</p><br/>
        <img src="templates/img/zzb.png">
    </div>
    <div class="statement"><p>
        曾经有一份真挚爱情放在我面前但是我没有珍惜，等到失去时我才后悔莫及，人世间最痛苦的事莫过于此，如果上天再给我一次从来的机会我会给那个女孩说三个字：我爱你！如果非要在这份感情加段期限的话，我想是一万年
        <p>
        <p>一一一 至尊宝</p>
    </div>
</div>
</body>
</html>