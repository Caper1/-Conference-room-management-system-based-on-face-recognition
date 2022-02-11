<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/main.css" />
<meta charset="UTF-8">
<title>增加用户界面</title>
<style>
<!--
.layui-form{
 margin: 5% 0 0 40%;
}
-->
</style>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<div style="width:50%;height:10px;float:left;">
<form  action="./UserTableInertSevlet" method="post" class="layui-form layui-form-pane"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  <div class="layui-form-item pane">
    <label class="layui-form-label">员工ID</label>
    <div class="layui-input-inline">
      <input type="text" name="imgId" id="imgId" value="" placeholder="输入用户id" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">员工名字</label>
    <div class="layui-input-inline">
      <input type="text" name="name"   autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-inline">
      <input type="text" name="sex"   autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">电话</label>
    <div class="layui-input-inline">
      <input type="text" name="tel" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-inline">
      <input type="text" name="email" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">所属部门</label>
    <div class="layui-input-inline">
        <select name="bumen" id="bumen" lay-verify="required" lay-filter="bumen" lay-search="">
          <option value="">请选择部门</option>
        </select>
      </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">员工职位</label>
    <div class="layui-input-inline">
      <input type="text" name="zhiwei" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">入职时间</label>
    <div class="layui-input-inline">
      <input id="d11" type="text" name="time"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane" style="display:none;">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-inline">
      <input id="password" type="passowrd" name="password" value="123456789"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  
		
 <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" id="btn">完成</button>
    </div>
  </div> 
</form>
</div>



<!-- 调用摄像头 -->
 <div class="container" style="width:50%;float:right;">
 
 
			<div class="container-fluid centerdiv">
				<div class="login-div cen">
					<div id="face-box">
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
			<button id="register" type="button" class="btn btn-primary"/>添加人脸</button>			
</div>
<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>
<script src="./layui/layui.js"></script>
<script type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/GetFace.js" ></script>
<script type="text/javascript" src="js/Register.js" ></script>
<script type="text/javascript" src="js/RegisterAjax.js" ></script>
<script>

 var btn = document.getElementById("btn");
  btn.onclick = function(){
  		
      alert("添加成功");
      layer.close(layer.index);
	  window.parent.location.reload();
  }

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
                       $("#bumen").append(new Option(item.departname));
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