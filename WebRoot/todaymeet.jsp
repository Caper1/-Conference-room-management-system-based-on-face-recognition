<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./layui/jquery-3.3.1.js"></script>
<table id="test" lay-filter="demo"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="qiandao">开始签到</a>
</script>
<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./layui/jquery-3.3.1.js"></script>
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
  var meetlocation = GetQueryString("meetlocation");
  //方法级渲染
  table.render({
  
    elem: '#test'
    ,height: 560
    ,url: './TodayMeetServlet?meetlocation='+meetlocation //数据接口
    ,page: false //开启分页
    ,cols: [[ //表头
    	{type: 'checkbox', fixed: 'left'}
      ,{field: 'id', title: '会议ID', width:100, sort: true, fixed: 'left'}
      ,{field: 'meetname', title: '会议主题', width:200}
      ,{field: 'meetstarttime', title: '会议开始时间', width:200}
      ,{field: 'meetendtime', title: '会议结束时间', width:200}
      //,{field: 'email', title: '电子邮箱', width:150}
      //,{field: 'bumen', title: '所属部门', edit:'text',width:100, sort: true}
      //,{field: 'zhiwei', title: '职位', edit:'text',width:60,} //可隐藏该列
      //,{field: 'zhiwei', title:'审核状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
      //,{field: 'time', title: '入职时间', width: 200}
       ,{fixed: 'right', width: 250, align:'center', title: '操作',toolbar: '#barDemo'}
    ]]
    ,id: 'testReload'
  });
  //监听工具条，实现查看详细信息、编辑与删除功能
  table.on('tool(demo)', function(obj) {
				var data = obj.data;
				var layEvent = obj.event;
				var layer=layui.layer;
				if (obj.event === 'qiandao') {
					layer.msg('name：' + data.id + ' 的查看操作');
					layer.open({
						type : 2,
						title : '人脸签到系统',
						content : './face.jsp?meetid='+data.id+'&meetname='+data.meetname+'&meetstarttime='+data.meetstarttime+'&meetendtime='+data.meetendtime+'&meetsqr='+data.meetsqr,
						shade : 0.5,
						area : [ '600px', '600px' ],
						maxmin : true
					});
					
				}
			});
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  decodeURI(r[2]); return null;
}

  
});

</script>


</body>
</html>