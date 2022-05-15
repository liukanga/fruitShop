function toShop(id) {

    window.location = "/shop/toShop?id="+id;

}

function queryShop() {
    const value = document.getElementById("shop_name").value;

    window.location = "/shop/queryShop?name="+value;

}