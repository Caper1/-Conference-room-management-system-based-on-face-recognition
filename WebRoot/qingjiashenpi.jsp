<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<table id="test" lay-filter="demo"></table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="shenhe">审核</a>
</script>
<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./layui/jquery-3.3.1.js"></script>
<script type="text/html" id="buttonTpl">
				{{#if(d.qdstatus==2){}}
				<button class="layui-btn layui-btn-primary layui-btn-xs">未审核</button>
				{{#}else if(d.qdstatus==20){}}
				<button class="layui-btn layui-btn-primary layui-btn-xs">审核拒绝</button>
				{{#}else{}}
				<button class="layui-btn layui-btn-primary layui-btn-xs">审核通过</button>
				{{#}}}
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
    ,url: './qingjiaSelectServlet' //数据接口
    ,page: false //开启分页
    ,cols: [[ //表头
    	{type: 'checkbox', fixed: 'left'}
    	,{field: 'id', title: '会议ID', width:100, sort: true, fixed: 'left'}
      ,{field: 'meetname', title: '会议主题', width:100, sort: true, fixed: 'left'}
      ,{field: 'meetlocation', title: '会议地点', width:100}
      ,{field: 'qdname', title: '请假人', width:60}
      ,{field: 'qingjiayuanyin', title: '请假原因', width:200}
      ,{field: 'qdstatus', title: '审核状态', width:80,hide:true}
      ,{field: 'qdstatus', title:'审核状态', templet: '#buttonTpl',width: 80, align: 'center'}
       ,{fixed: 'right', width: 250, align:'center', title: '操作',toolbar: '#barDemo'}
    ]]
    ,id: 'testReload'
  });
  //监听工具栏事件
   //监听头工具栏事件
  table.on('toolbar(demo)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id)
    ,data = checkStatus.data; //获取选中的数据
    switch(obj.event){
      case 'add':
        layer.msg('添加');
        layer.open({
						type : 2,
						title : '添加员工信息',
						content : './UserTableInert.jsp',
						shade : 0.5,
						area : [ '600px', '400px' ],
						maxmin : true
					});
      break;
      case 'refresh':
      	 location.reload();
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

  //监听工具条，实现查看详细信息、编辑与删除功能
  table.on('tool(demo)', function(obj) {
				var data = obj.data;
				var layEvent = obj.event;
				var layer=layui.layer;
				if (obj.event === 'shenhe') {
					layer.msg('name：' + data.name + ' 的查看操作');
					layer.open({
						type : 2,
						title : '审核界面',
						content : 'qngjiashenpi1.jsp?meetid='+data.id+'&qdname='+data.qdname+'&qingjiayuanyin='+data.qingjiayuanyin,
						shade : 0.5,
						area : [ '600px', '400px' ],
						maxmin : true
					});
				} 
			});
			
			//表格重载实现多条件查询并回显
	var $ = layui.$, active = {
    reload: function(){
      var depart=$('#depart').val();

      //执行重载
      table.reload('testReload', {
        page: {
          curr: 1 //重新从第 1 页开始
        }
        ,where: {
          key: {
            departname: depart,
          }
        }
      });
    }
  };
   //按钮点击事件出发
  $('#btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});

</script>

<script type="text/javascript">
layui.use('form', function () {
      var form = layui.form; 
//页面打开时异步加载数据,查询信道
        $(function () {
           $.ajax({
               type: "POST",
               url: "./DepartSelectServlet",
               dataType:"json",
               success: function (data) {
                   $.each(data, function (index, item) {
                       $("#depart").append(new Option(item.departname));
                   });
                   layui.form.render("select");
               },error: function () {
                   alert("查询信道失败")
               }
           })
        });
});
</script>
</body>
</html>