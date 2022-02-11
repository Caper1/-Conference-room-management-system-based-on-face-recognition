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
<script type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>
<div class="layui-form-item" id="demoTable">
     <label class="layui-form-label">会议室地点</label>
    <div class="layui-input-inline">
      <input type="text" id="meetlocation1" name="meetlocation1" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
</div>
 <div class="layui-form-item">
 <label class="layui-form-label">会议开始时间</label>
    <div class="layui-input-inline">
      <input type="" name="meetstarttime1" id="meetstarttime1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete="off" class="layui-input ">
    </div>

  <label class="layui-form-label">会议结束时间</label>
   <div class="layui-input-inline">
      <input type="" name="meetendtime1" id="meetendtime1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete="off" class="layui-input ">
    </div>
     <button type="button" id="searchbtn" data-type="reload" class="layui-btn layui-btn-normal">查询</button>
 </div>
<table id="test" lay-filter="demo"></table>

<script type="text/html" id="barDemo">
  {{#if(d.shstatus==0){}}
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">撤销会议</a>

  {{#}else if(d.shstatus==10){}}
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看审核意见</a>
  {{#}else{}}
  {{#if(d.meetstatus==0){}}
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看审核意见</a>
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="tongzhi">邮件通知</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">撤销会议</a>
  {{#}else if(d.meetstatus==1){}}
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看审核意见</a>
  {{#}else if(d.meetstatus==2){}}
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看审核意见</a>
  {{#}else if(d.meetstatus==3){}}
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看审核意见</a>
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="chexiaotongzhi">撤销通知</a>	
{{#}}}
  {{#}}}
	
</script>
<script type="text/html" id="buttonTpl1">
{{#if(d.meetstatus==3){}}
<button class="layui-btn layui-btn-primary layui-btn-xs">已撤销</button>
{{#}else if(d.shstatus==11){}}
{{#if(d.meetstatus==0){}}
	<button class="layui-btn layui-btn-primary layui-btn-xs">未开始</button>
{{#}else if(d.meetstatus==1){}}
<button class="layui-bg-red">进行中</button>
{{#}else{}}
 <button class="layui-btn layui-btn-primary layui-btn-xs">已结束</button>
{{#}}}
{{#}else{}}
<button class="layui-btn layui-btn-primary layui-btn-xs">无</button>
{{#}}}
</script>
<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/html" id="buttonTpl">
                {{# if(d.shstatus == 11){ }}
                <button class="layui-btn layui-btn-primary layui-btn-xs">已审核通过</button>
				{{# }else if(d.shstatus==10){ }}
				<button class="layui-bg-red">已审核拒绝</button>
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
    ,method:'POST'
    ,height: 560
    ,url: './MeetfindbyNameServlet' //数据接口
    ,page: false //开启分页
    ,cols: [[ //表头
    	{type: 'checkbox', fixed: 'left'}
      ,{field: 'meetname', title: '会议主题', width:120}
      ,{field: 'meetlocation', title: '会议地点',width:100, sort: true}
      ,{field: 'meetsqr', title: '会议发起人',width:100, sort: true,hide:true}
      ,{field: 'meetcontext', title: '会议简介',width:100, sort: true}
      ,{field: 'meetjoin', title: '会议参与人',width:100, sort: true}
      ,{field: 'meetstarttime', title: '开始时间',width:100 } //可隐藏该列
      ,{field: 'meetendtime', title: '结束时间',width:100, sort: true} 
      ,{field: 'shstatus', title: '审核状态',width:50, sort: true,hide:true}
      ,{field: 'shstatus', title:'审核状态', templet: '#buttonTpl', width: 110, align: 'center'}
      ,{field: 'meetstatus', title: '会议状态',width:50, sort: true,hide:true}
      ,{field: 'meetstatus', title:'会议状态', templet: '#buttonTpl1', width: 110, align: 'center'}
      ,{field: 'meetstatus', title:'会议状态', width: 90, align: 'center',hide:true}
       ,{fixed: 'right', width: 270, align:'center', title: '操作',toolbar: '#barDemo'}
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
    }

});

//监听工具条实现查看详细信息功能
table.on('tool(demo)',function(obj){
			var data=obj.data;
			var layEvent=obj.event;
			var layer=layui.layer;
			if(obj.event==='detail'){
				//layer.msg('id'+data.id);
				layer.open({
						type : 2,
						title : '审核意见',
						content : './MeetSelectServlet1?id=' + data.id,
						shade : 0.5,
						area : [ '600px', '400px' ],
						maxmin : true
					});
			}else if(obj.event=='tongzhi'){
				//layer.msg(data.id);
				layer.confirm('发邮件通知给'+data.meetjoin+'吗？', function(index) {
					//layer.msg('name：' + data.id + ' 的查看操作');
					$.ajax({
						type : "post",
						url : "./MeetTongzhiServlet",
						data:{
						id:data.id
						},
						dataType : "json",
						success:function (data){
							console.log("!!!!!!!!!");
						},
						error:function(data)
						{
							console.log("!!!!!!!!!!!!");
						}
					});
					layer.close(index);	
					});
			}else if (obj.event === 'delete') {
					//layer.msg('id：' + data.id + ' 的查看操作');
					layer.confirm('真的要撤销会议吗', function(index) {
					//layer.msg('name：' + data.id + ' 的查看操作');
						$.ajax({
							type : "get",
							url : "./MeetDeleteServlet?id=" + data.id,
							dataType : "json"
						});
						layer.close(index);
					});
 
				} else if(obj.event=='donedelete')
				{
					layer.msg("会议已撤销，不可重复撤销！！");
				}
				else if(obj.event=='chexiaotongzhi')
				{	
					layer.confirm('发送撤销通知给'+data.meetjoin+'吗？', function(index) {
					$.ajax({
						type : "post",
						url : "./MeetChexiaoServlet",
						data:{
						id:data.id
						},
						dataType : "json",
						success:function (data){
							console.log("!!!!!!!!!");
						},
						error:function(data)
						{
							console.log("!!!!!!!!!!!!");
						}
					});
					layer.close(index);	
					});
					
				}
	
});

//表格重载实现多条件查询并回显
	var $ = layui.$, active = {
    reload: function(){
      var meetlocation1=$('#meetlocation1').val();
      var meetstartime1=$('#meetstarttime1').val();
      var meetendtime1=$('#meetendtime1').val();
      //执行重载
      table.reload('testReload', {
        page: {
          curr: 1 //重新从第 1 页开始
        }
        ,where: {
          key: {
            meetlocation:meetlocation1,
            meetstartime:meetstartime1,
            meetendtime:meetendtime1
          }
        }
      });
    }
  };
  //按钮点击事件出发
  $('#searchbtn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });

});
</script>
</body>
</html>