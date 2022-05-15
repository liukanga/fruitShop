var reg_btn = document.querySelector(".reg-btn");

reg_btn.addEventListener("click", function (){

    var name = document.getElementById("name").value;
    var pwd = document.getElementById("password").value;
    var status = document.getElementById("status").value;
    var address = document.getElementById("address").value;
    var contract = document.getElementById("contract").value;
    var description = document.getElementById("description").value;

    if(name===''){
        alert("昵称不能为空！");
        self.location = "/reg";
    }
    if(pwd===''){
        alert("密码不能为空！");
        self.location = "/reg";
    }
    if(status==='0'){
        alert("请选择身份！");
        self.location = "/reg";
    }

    var user = {
        "username": name,
        "password": pwd,
        "level": status,
        "address": address,
        "contract": contract,
        "description": description
    };

    fetch(
        '/user/register',
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
            if(result.isSuccess == true || result.success == true){
                alert("注册成功！您的账号为："+result.data.accountNumber);
                window.location = "/loginPage";
            }else{
                alert("注册失败,请重新尝试！");
                self.location = "/reg";
            }
        })


})

