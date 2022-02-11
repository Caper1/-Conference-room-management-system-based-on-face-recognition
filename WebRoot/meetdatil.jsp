<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考勤信息界面</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
  <table id="test" lay-filter="demo"></table>
<script type="text/html" id="buttonTpl">
{{#if(d.qdstatus==0){}}
<button class="layui-btn layui-btn-xs">未签到</button>
{{#}else if(d.qdstatus==1){}}
<button class="layui-btn layui-btn-xs">已签到</button>
{{#}else if(d.qdstatus==20){}}
<button class="layui-btn layui-btn-xs">已请假未批准</button>
{{#}else if(d.qdstatus==21){}}
<button class="layui-btn layui-btn-xs">已请假批准</button>
{{#}else if(d.qdstatus==3){}}
<button class="layui-btn layui-btn-xs">迟到</button>
{{#}else if(d.qdstatus==4){}}
<button class="layui-btn layui-btn-xs">缺勤</button>
{{#}}}
</script>
<script src="./layui/layui.js"></script>
<script>
layui.use(['table','laypage'], function(){
  var table = layui.table;
  var laypage=layui.laypage;
  var meetid = GetQueryString("meetid");
	//alert("syagyfgesbfuygruyhgr5tbh");
  //方法级渲染
  table.render({
  
    elem: '#test'
    ,height: 560
     ,toolbar: '#toolbarDemo'
    ,url: './facefindServlet?meetid='+meetid //数据接口
    ,page: false //开启分页
    ,cols: [[ //表头
    	{type: 'checkbox', fixed: 'left'}
    	,{field: 'meet_id', title: '会议ID', width:100, sort: true, fixed: 'left'}
      ,{field: 'user_id', title: '员工ID', width:100, sort: true, fixed: 'left'}
      ,{field: 'qdname', title: '姓名', width:80}
      ,{field: 'qdstatus', title: '状态', width:100,hide:true}
      ,{field: 'qdstatus', title:'考勤状态', templet: '#buttonTpl', width: 80, align: 'center'}
      //,{fixed: 'right', width: 80, align:'center', title: '操作',toolbar: '#barDemo'}
    ]]
    ,id: 'testReload'
  });
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  decodeURI(r[2]); return null;
} 
});

</script>
<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>
</body>
</html>