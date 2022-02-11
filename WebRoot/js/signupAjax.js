function Facesignup(){
	setTimeout(function(){
		img=getFace(); //获取摄像头图片
		$.ajax({
			type:"post",
			url:"../SignServletFace",
			data:{
				"imgStr":img,
				"imgType":"BASE64",
				"meetid": GetQueryString("meetid")
			},
			dataType:"json",
			success:function(data)
			{
				console.log(data);
				var start=data["start"]
				if(start==true)
					{
					alert("签到成功，欢迎您"+data["userId"]);
					location.reload();
					}else{
						alert(data["errorMsg"]);
	                	console.log(data["errorMsg"]);
	                    Facesignup();
	                }
			},
			 error:function () {
	                alert("连接服务器失败")
	            },
	            async:true
			
		})
		
	},500);
}