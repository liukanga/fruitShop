function switchTo(value) {
    if(value===1){
        window.location = "/user/toUserList";
    }else if(value===2){
        window.location = "/novel/query/allBooks";
    }else if(value===3){
        var uid = document.getElementById("cUserId").value;
        alert(uid);
        window.location = "/user/toHomePage?uid="+uid;
    }else{
        window.location = "/user/loginPage"
    }
}
const de = document.querySelector(".cDetails");
const signOut = document.querySelector(".signOut");
const currentUser = document.querySelector(".ccUser");
currentUser.addEventListener("mouseover", function () {
    de.style.display = "block";
    signOut.style.display = "block";
});
currentUser.addEventListener("click", function () {
    de.style.display = "none";
    signOut.style.display = "none";
});