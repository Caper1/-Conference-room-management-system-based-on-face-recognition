<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/main.css" />
<style>
div.face-box{
margin-top:2cm;
}
</style>
</head>
<body>
<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./layui/jquery-3.3.1.js"></script>
<div style="width:70%;float:left;">
<div class="layui-input-inline">
    <label class="layui-form-label">会议主题</label>
    <div class="layui-input-inline">
      <input type="text" name="meetname" id="meetname"  value="" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-input-inline" style="float:left;">
    <label class="layui-form-label">会议负责人</label>
    <div class="layui-input-inline">
      <input type="text" id="meetsqr" name="meetsqr" value=""  autocomplete="off" class="layui-input ">
    </div>
  </div>
   <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">会议开始时间</label>
      <div class="layui-input-inline">
        <input type="tel" name="meetstarttime" id="meetstarttime" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">会议结束时间</label>
      <div class="layui-input-inline">
        <input type="text" name="meetendtime" id="meetendtime" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <table id="test" lay-filter="demo"></table>
</div>

<div class="container" style="width:30%;float:right;">
 
 
			<div class="container-fluid centerdiv">
				<div class="login-div cen">
					<div id="face-box" class="face-box">
						<video id="video"></video>
					</div>
					<div id="overflow">
						
					</div>
					<div style="display: none;">
						<canvas id="canvas"></canvas>
					</div>
				</div>
				<!--</form>-->
			</div>
			<br />
			<br />
			<div class="layui-form-item">
			<button id="register" type="button" class="btn btn-primary"/>开始签到</button>	
			</div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="qiandao">开始签到</a>
</script>

<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./layui/jquery-3.3.1.js"></script>
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
<script type="text/html" id="toolbarDemo">
<div class="layui-inline" lay-event="refresh"><i class="layui-icon layui-icon-refresh-3"></i></div>

</script>
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
      ,{field: 'user_id', title: '员工ID', width:100, sort: true, fixed: 'left'}
      ,{field: 'qdname', title: '姓名', width:80}
      ,{field: 'qdbumen', title: '职位', width:80}
      ,{field: 'qdtel', title: '手机号', width:120}
      ,{field: 'qdtime', title: '签到时间', width:200}
      ,{field: 'qdstatus', title: '状态', width:100,hide:true}
      ,{field: 'qdstatus', title:'状态', templet: '#buttonTpl', width: 80, align: 'center'}
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
<script>
//对form表单进行赋值
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  decodeURI(r[2]); return null;
}
var meetsqr = GetQueryString("meetsqr");
var meetname = GetQueryString("meetname");
var meetstarttime = GetQueryString("meetstarttime");
var meetendtime = GetQueryString("meetendtime");

document.getElementById("meetsqr").value=meetsqr;
document.getElementById("meetname").value=meetname;
document.getElementById("meetstarttime").value=meetstarttime;
document.getElementById("meetendtime").value=meetendtime;
</script> 

<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>

<script type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/GetFace.js" ></script>
<script type="text/javascript" src="js/signup.js" ></script>
<script type="text/javascript" src="js/signupAjax.js" ></script>
</body>
</html>