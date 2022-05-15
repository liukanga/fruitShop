var login_btn = document.querySelector(".login-btn");

login_btn.addEventListener("click", function () {

    var aNumber = document.getElementById("accountNumber").value;
    var pwd = document.getElementById("password").value;
    var level = document.getElementById("level").value;
    // var accessCode = document.getElementById("accessCode").value;

    if(aNumber===''||pwd===''){
        alert("账号、密码、验证码均不能为！");
    }
    var user = {
        "accountNumber": aNumber,
        "password": pwd,
        "level": level
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
            if(result.isSuccess === true || result.success === true){
                alert("登录成功！");
                if(level==='网站管理员'){
                    window.location = "/admin/shopList";
                }else if (level==='学生'){
                    window.location = "/shop/shopList";
                }else {
                    window.location = "/user/"+ aNumber +"/fruitList"
                }
            }else{
                alert("登录失败,请重新登录！");
                window.location = "/loginPage";
            }

        })
});



function switchKaptcha(){
    window.location = "/loginPage";
}

function pwd() {

}

