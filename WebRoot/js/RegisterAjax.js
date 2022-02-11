function FaceRegister() {
    setTimeout(function () {
        img = getFace();
        $.ajax({
            type:"post",
            url:"http://localhost:8080/facelogin_eclipse/user/register",//后台接口
            data:{
            	"imgId":$("#imgId").val(),
                "imgStr":img,
                "imgType":"BASE64"
            },
            dataType:"json",
            success:function (data) {
                console.log(data);
                var start = data["start"]
                if(start == true){
                	alert(data["msg"])
                }
                else{
                	alert(data["errorMsg"])
                    Facelogin();
                }
            },
            error:function () {
                alert("人脸信息已存在");
            },
            async:true
        })
    },500);
}

