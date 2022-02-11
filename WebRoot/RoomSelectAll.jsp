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
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看今日会议</a>
    <a class="layui-btn layui-btn-xs" lay-event="yuyue" >预约</a>
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
<script type="text/html" id="toolbarDemo">
<div class="layui-inline" lay-event="refresh"><i class="layui-icon layui-icon-refresh-3"></i></div>

</script>
<script>
layui.use(['table','laypage'], function(){
  var table = layui.table;
  var laypage=layui.laypage;
  //方法级渲染
  table.render({
  
    elem: '#test'
    ,toolbar: '#toolbarDemo'
    ,height: 560
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,url: './RoomSelectAllServlet' //数据接口
    ,page: false //开启分页
    ,cols: [[ //表头
    	{type: 'checkbox', fixed: 'left'}
      ,{field: 'roomname', title: '会议室名称', width:200}
      ,{field: 'roomlocation', title: '会议室地点',width:200, sort: true}
      ,{field: 'roomcap', title: '容纳人数',width:200, sort: true}
      ,{field: 'roomstatus', title: '会议状态',width:120, sort: true,hide:true}
       ,{field: 'roomstatus', title:'会议室状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
       ,{fixed: 'right', width: 300, align:'center', title: '操作',toolbar: '#barDemo'}
    ]]
    ,id: 'testReload'
  });
  
  //监听头工具栏事件
  table.on('toolbar(demo)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id)
    ,data = checkStatus.data; //获取选中的数据
    switch(obj.event){
      case 'refresh':
        layer.msg('刷新');
        location.reload();
      break;
      case 'update':
        if(data.length === 0){
          layer.msg('请选择一行');
        } else if(data.length > 1){
          layer.msg('只能同时编辑一个');
        } else {
          layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
        }
      break;
      case 'delete':
        if(data.length === 0){
          layer.msg('请选择一行');
        } else {
          layer.msg('删除');
        }
      break;
    };
  });

//监听工具条，实现预约与查看会议室具体信息
table.on('tool(demo)',function(obj){
	var data=obj.data;
	var layEvent=obj.event;
	var layer=layui.layer;
	
	if(obj.event=='yuyue'){
		var roomname=data.roomname;
		if(data.roomstatus==0)
		{
			layer.msg("会议室正在被占用，无法预约！");
		}else
		{	
		layer.open({
			type : 2,
			title : '预约会议界面',
			content :'./addmeet.jsp?roomlocation='+data.roomlocation,
			shade : 0.5,
			area : [ '600px', '400px' ],
			maxmin : true
		})
		}
	}
	
})
});
</script>
</body>
</html>