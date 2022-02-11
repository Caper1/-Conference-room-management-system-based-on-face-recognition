<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>会议管理</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>

<table id="test" class="layui-hide" lay-filter="demo"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="todaymeet">查看今日会议</a>
</script>
<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./layui/jquery-3.3.1.js"></script>
<script type="text/html" id="buttonTpl">
                 {{# if(d.roomstatus == 1){ }}
                <button class="layui-btn layui-btn-xs">空闲</button>
				{{# }else if(d.roomstatus==0){ }}
				<button class="layui-bg-red">占用</button>
                 {{# }else { }}
                <button class="layui-btn layui-btn-primary layui-btn-xs">待审核</button>
                {{# } }}
</script>
<script>
layui.use(['table','laypage'], function(){
  var table = layui.table;
  var laypage=layui.laypage;
  //方法级渲染
  table.render({
  
    elem: '#test'
    ,toolbar: 'default'
    ,height: 560
    ,url: './RoomSelectAllServlet' //数据接口
    ,page: false //开启分页
    ,cols: [[ //表头
    	{type: 'checkbox', fixed: 'left'}
      ,{field: 'roomname', title: '会议室名称', width:200}
      ,{field: 'roomlocation', title: '会议室地点',width:200, sort: true}
      ,{field: 'roomcap', title: '容纳人数',width:200, sort: true}
      ,{field: 'roomstatus', title: '会议状态',width:120, sort: true,hide:true}
       ,{field: 'roomstatus', title:'会议室状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
       ,{field: 'right', width: 300, align:'center', title: '操作',toolbar: '#barDemo'}
    ]]
    ,id: 'testReload'
  });

//监听工具条，实现预约与查看会议室具体信息
table.on('tool(demo)',function(obj){
	var data=obj.data;
	var layEvent=obj.event;
	var layer=layui.layer;
	
	if(obj.event=='todaymeet'){
		layer.open({
			type : 2,
			area: ['2000px', '2000px'],
			title : '查看今日会议',
			content :'./todaymeet.jsp?meetlocation='+data.roomlocation,
			shade : 0.5,
			area : [ '600px', '400px' ],
			maxmin : true
		})
	}
	
})
});
</script>
</body>
</html>