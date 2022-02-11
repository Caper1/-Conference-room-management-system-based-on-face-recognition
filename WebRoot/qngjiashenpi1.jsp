<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'qngjiashenpi1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="./layui/css/layui.css">
  <script src="./layui/layui.js"></script>
<script type="text/javascript" src="./jquery-3.3.1/jquery-3.3.1.js"></script>
  </head>
  
  <body>

  <form class="layui-form" action="./qingjiaupdateServlet" method="post" >
  <div class="layui-form-item" style="display: none;">
    <label class="layui-form-label">会议ID</label>
    <div class="layui-input-inline">
      <input type="text" name="meetid" value="dddd" id="meetid" lay-verify="meetname" autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请假人</label>
    <div class="layui-input-inline">
      <input type="text" name="qdname" value="dddd" id="qdname" lay-verify="meetname" autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item layui-form-text" id="qingjiadiv">
    <label class="layui-form-label">请假原因</label>
    <div class="layui-input-block">
      <textarea name="qingjiayuanyin" id="qingjiayuanyin"  placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">审核</label>
    <div class="layui-input-block">
      <input type="radio" name="qdstatus" value="21" title="通过" checked="">
      <input type="radio" name="qdstatus" value="20" title="拒绝">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" id="btn1" class="layui-btn layui-btn-primary">审核</button>
    </div>
  </div> 
  </form>
  <script>
layui.use('form',function(){
  var form = layui.form;
  
   //刷新界面 所有元素

   form.render();

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
var meetid = GetQueryString("meetid");
var qdname = GetQueryString("qdname");
var qingjiayuanyin = GetQueryString("qingjiayuanyin");


document.getElementById("meetid").value=meetid;
document.getElementById("qdname").value=qdname;
document.getElementById("qingjiayuanyin").value=qingjiayuanyin;
document.getElementById("meetendtime").value=meetendtime;
</script> 
  </body>
  
  
</html>
