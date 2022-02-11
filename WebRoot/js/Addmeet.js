var add = $("#btn").click(function(){
		var meetname=$("#meetname").val();
		var meetlocation=$("#meetlocation").val();
		var meetsqr=$("#meetsqr").val();
		var meetcontext=$("#meetcontext").val();
		var selectArr = demo2.getValue('nameStr');
		var meetstarttime=$("#meetstarttime").val();
		var meetendtime=$("#meetendtime").val();
		var shstatus=$("#shstatus").val();
		var meetstatus=$("#meetstatus").val();
		var yuanyin=document.getElementById("yuanyin").value;
		
		$.ajax({
			type:"post",

			url:"./MeetAddServlet",
			data:{
				"meetname":meetname,
				"meetlocation":meetlocation,
				"meetsqr":meetsqr,
				"meetcontext":meetcontext,
				"meetjoin":selectArr,
				"meetstarttime":meetstarttime,
				"meetendtime":meetendtime,
				"shstatus":shstatus,
				"meetstatus":meetstatus,
				"yuanyin":yuanyin
			},
			dataType:"json",
			success:function(){
			  alert("添加成功");
		      layer.close(layer.index);
			  window.parent.location.reload();
			}
			})
			
		});

        	
        
