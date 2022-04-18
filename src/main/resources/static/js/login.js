var login_btn = document.querySelector(".login-btn");

login_btn.addEventListener("click", function () {

    var aNumber = document.getElementById("accountNumber").value;
    var pwd = document.getElementById("password").value;
    var accessCode = document.getElementById("accessCode").value;

    if(aNumber===''||pwd===''||accessCode===''){
        alert("账号、密码、验证码均不能为！");
    }
    var user = {
        "accountNumber": aNumber,
        "password": pwd,
        "accessCode": accessCode
    };

    fetch(
        '/user/login',
        {
            body: JSON.stringify(user),
            cache: 'no-cache',
            headers: {
                'content-type': 'application/json'
            },
            method: 'POST'
        }
    )
        .then(function (response) {
            return response.json();
        })
        .then(function (result) {
            if(result.isSuccess == true || result.success== true){
                alert("登录成功！"+status);

                if(status==='1'){
                    window.location = "/user/toUserList";
                }else{
                    window.location = "/novel/toNovelList/"+aid;
                }
            }else{
                alert("登录失败,请重新登录！");
                self.location = "/user/loginPage";
            }

        })
});



function switchKaptcha(){

    var p = document.getElementById("aCode");
    p.src="http://localhost:8028/kaptcha.png";
}

