var login_btn = document.querySelector(".login-btn");

login_btn.addEventListener("click", function () {

    var aid = document.getElementById("aid").value;
    var pwd = document.getElementById("password").value;
    var status = document.getElementById("status").value;

    if(aid===''||pwd===''){
        alert("账号或密码不能为！");
    }
    if(status==='0'){
        alert("请选择身份！");
    }
    var user = {
        "id": aid,
        "name": null,
        "password": pwd,
        "status": status,
        "novels": [],
        "duration": null,
        "details": null
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



})