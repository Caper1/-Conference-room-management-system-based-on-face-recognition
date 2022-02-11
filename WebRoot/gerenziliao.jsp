<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gerenziliao.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="./layui/css/layui.css">

  </head>
  
  <body>
  <script src="./layui/layui.js"></script>
  <script type="text/javascript" src="./jquery-3.3.1/jquery-3.3.1.js"></script>
  <form class="layui-form" id="form_1" action="./wanshangerenServlet" method="post" style="display: none;">
  完善个人资料：<br />
   <div class="layui-form-item">
      <label class="layui-form-label">手机号码</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input">
      </div>
 </div>
    <div class="layui-form-item">
      <label class="layui-form-label">电子邮箱</label>
      <div class="layui-input-inline">
        <input type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input">
      </div>
    </div>
     <div class="layui-form-item">
    <label class="layui-form-label">身份证号码</label>
    <div class="layui-input-block">
      <input type="text" name="identity" lay-verify="identity" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-inline">
      <input type="password" name="password" id="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">
      <input type="password"  onblur="check(this)" name="querenpassword" id="querenpassword" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <div id="tip" class="layui-form-mid layui-word-aux">请与上方填写一致</div>
  </div>
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>

<form class="layui-form" id="form_2" action="" method="post" style="display: none;">
<div class="layui-form-item">
      <label class="layui-form-label">ID</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone" value="${u.id}"  readonly="readonly"  lay-verify="required|phone" autocomplete="off" class="layui-input">
      </div>
 </div>
	<div class="layui-form-item">
      <label class="layui-form-label">姓名</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone" value="${u.name}"  readonly="readonly" lay-verify="required|phone" autocomplete="off" class="layui-input">
      </div>
 </div>
   <div class="layui-form-item">
      <label class="layui-form-label">手机号码</label>
      <div class="layui-input-inline">
        <input type="tel" name="phone" value="${u.tel}"   readonly="readonly" lay-verify="required|phone" autocomplete="off" class="layui-input">
      </div>
 </div>
    <div class="layui-form-item">
      <label class="layui-form-label">电子邮箱</label>
      <div class="layui-input-inline">
        <input type="text" name="email" value="${u.email}" readonly="readonly" lay-verify="email" autocomplete="off" class="layui-input">
      </div>
    </div>
     <div class="layui-form-item">
    <label class="layui-form-label">身份证号码</label>
    <div class="layui-input-block">
      <input type="text" name="identity" value="${u.identity}"  readonly="readonly" lay-verify="identity" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>
</form>
 
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  form.render();
});
</script>
<script>
 function check(obj){
                var pass1=document.getElementById("password").value;
                var pass2=obj.value;
                if(pass1==pass2){
                    document.getElementById("tip").innerText="两次密码一致";
                }else{
                    document.getElementById("tip").innerText="两次密码不一致";
                }
            }
</script>
<script>
$(function(){
var password='${u.password}';
if(password==null)
{
	alert("您的个人资料未完善！请完善您的个人资料");
	document.getElementById('form_1').style.display = "block";
}
else
{
	document.getElementById('form_2').style.display = "block";
}
})
</script>
</body>
</html>
