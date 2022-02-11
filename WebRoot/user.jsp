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
<form class="layui-form" action="">
 <div class="layui-form-item">
<div class="layui-inline">
      <label class="layui-form-label">按部门搜索</label>
      <div class="layui-input-inline">
        <select name="depart" id="depart" lay-verify="required" lay-filter="depart" lay-search="">
          <option value="">请选择部门</option>
        </select>
      </div>
    </div>
    <button type="button" id="btn" data-type="reload" class="layui-btn">查询</button>
 </div>
</form>
<table id="test" lay-filter="demo"></table>
<script type="text/html" id="toolbarDemo">
<button type="button" class="layui-btn layui-btn-sm" lay-event="add">员工入职</button>
<div class="layui-inline" lay-event="refresh"><i class="layui-icon layui-icon-refresh-3"></i></div>

</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="update">更新</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">员工离职</a>
</script>
<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/html" id="buttonTpl">
                {{#  if(d.zhiwei == 1){ }}
                <button class="layui-btn layui-btn-xs">已审核</button>
                {{#  } else { }}
                <button class="layui-btn layui-btn-primary layui-btn-xs">未审核</button>
                {{#  } }}
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
    ,url: './UserSelectAllServlet' //数据接口
    ,method:'post'
    ,page: false //开启分页
    ,cols: [[ //表头
    	{type: 'checkbox', fixed: 'left'}
      ,{field: 'id', title: 'ID', width:100, sort: true, fixed: 'left'}
      ,{field: 'name', title: '员工姓名', width:100}
      ,{field: 'sex', title: '性别', width:60}
      ,{field: 'tel', title: '联系电话', width:130}
      ,{field: 'email', title: '电子邮箱', width:150}
      ,{field: 'bumen', title: '所属部门', edit:'text',width:100, sort: true}
      ,{field: 'zhiwei', title: '职位', edit:'text',width:60,} //可隐藏该列
      //,{field: 'zhiwei', title:'审核状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
      ,{field: 'time', title: '入职时间', width: 200}
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
				if (obj.event === 'detail') {
					layer.msg('name：' + data.name + ' 的查看操作');
					layer.open({
						type : 2,
						title : '员工信息',
						content : './UserTableSelectServlet?id=' + data.id,
						shade : 0.5,
						area : [ '600px', '400px' ],
						maxmin : true
					});
				} else if (obj.event === 'delete') {
					//layer.msg('id：' + data.id + ' 的查看操作');
					layer.confirm('真的删除行么', function(index) {
					//layer.msg('name：' + data.id + ' 的查看操作');
						obj.del();
						$.ajax({
							type : "get",
							url : "./UserTableDleteServlet?id=" + data.id,
							dataType : "json"
						});
						layer.close(index);
					});
 
				} else if (obj.event === 'update') {
					//layer.alert('编辑行：<br>'+ JSON.stringify(data))										
					$.ajax({
						type : "post",
						data : data,
						url : "./UserTableUpdateServlet",
						dataType : "json"
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