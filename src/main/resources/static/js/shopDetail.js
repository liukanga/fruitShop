function showDetails(fsugar, forganicAcid, fso, fvt, fmeat, fmoisture, fquality){
	const detail = document.getElementById("fdetail");
	const fsg = document.getElementById("fsugar");
	const foa = document.getElementById("forganicAcid");
	const fsoo = document.getElementById("fso");
	const fvtt = document.getElementById("fvt");
	const fmt = document.getElementById("fmeat");
	const fmo = document.getElementById("fmoisture");
	const fqu = document.getElementById("fquality");

	// alert(fsugar+"/n"+forganicAcid+"/n"+fso+"/n"+fvt+"/n"+fmeat+"/n"+fmoisture+"/n"+fquality)
	if (fsugar !== null){
		fsg.innerHTML = "糖分："+fsugar;
	}else{
		fsg.innerHTML = "糖分：暂无数据";
	}
	if (forganicAcid !== null){
		foa.innerHTML = "有机酸："+forganicAcid;
	}else{
		foa.innerHTML = "有机酸：暂无数据";
	}
	if (fso !== null){
		fsoo.innerHTML = "糖酸比："+fso;
	}else{
		fsoo.innerHTML = "糖酸比：暂无数据";
	}
	if (fvt !== null){
		fvtt.innerHTML = "维生素："+fvt;
	}else{
		fvtt.innerHTML = "维生素：暂无数据";
	}
	if (fmeat !== null){
		fmt.innerHTML = "肉质："+fmeat;
	}else{
		fmt.innerHTML = "肉质：暂无数据";
	}
	if (fmoisture !== null){
		fmo.innerHTML = "水分："+fmoisture;
	}else{
		fmo.innerHTML = "水分：暂无数据";
	}
	if (fquality !== null){
		fqu.innerHTML = "保质期："+fquality;
	}else{
		fqu.innerHTML = "保质期：暂无数据";
	}

	detail.style.display = "block";

}

function closeDe(){
	const detail = document.getElementById("fdetail");
	detail.style.display = "none";
}

function toShopList() {
	window.location = "/shop/shopList";
}

function toCart(sid){

	window.location = "/user/toMyCart?sid="+sid;
}

function addComment(uid, shid) {

	const content = document.getElementById("content").value;

	var comment = {
		"userId": uid,
		"content": content,
		"shopId": shid
	};

	fetch('/addComment',
		{
			body: JSON.stringify(comment),
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
			if (result.success===true){
				alert("评论成功！");
				window.location = "/shop/toShop?id="+shid;
			}else {
				alert("评论失败，请重新尝试！");
				window.location = "/shop/toShop?id="+shid;
			}
		})

}