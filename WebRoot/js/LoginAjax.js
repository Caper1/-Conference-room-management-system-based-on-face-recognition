function Facelogin() {
	var id= $("#yuangongid").val();
	alert("woshishabi");
    setTimeout(function () {
        img = getFace();
        
        $.ajax({
            type:"post",
            url:"http://localhost:8080/meeting/user/login",//后台接口
            data:{
                "imgStr":img,
                "imgType":"BASE64"
            },
            dataType:"json",
            success:function (data) {
                console.log(data);
                var start = data["start"]
                if(start == true&&id==data["userId"]){
                	alert("欢迎您："+id);
                	window.location.href="userindex.html";
                }
                else{
                	console.log(data["errorMsg"])
                    Facelogin();
                }
            },
            error:function () {
                alert("连接服务器失败")
            },
            async:true
        })
        
    },500);
}

