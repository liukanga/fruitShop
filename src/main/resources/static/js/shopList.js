function toShop(id) {

    window.location = "/shop/toShop?id="+id;

}

function queryShop() {
    const value = document.getElementById("shop_name").value;

    if(value === '' || value === null){
        window.location = "/shop/shopList";
    }else{
        window.location = "/shop/queryShop?name="+value;
    }



}