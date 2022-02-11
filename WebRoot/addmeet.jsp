<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
 //从 RoomSelectAll中获取roomlocation字段的值 
 String roomlocation=new String(request.getParameter("roomlocation").getBytes("iso-8859-1"),"utf-8");

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<script type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
<script src="./xm-select-v1.2.2/dist/xm-select.js"></script>
<script src="./jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script src="layui/layui.js"></script>
 <form  action="" method="post" class="layui-form layui-form-pane">
  <div class="layui-form-item pane">
    <label class="layui-form-label">会议主题</label>
    <div class="layui-input-inline">
      <input type="text" name="meetname" id="meetname" value="" placeholder="输入会议主题" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">会议地点</label>
    <div class="layui-input-inline">
      <input type="text" name="meetlocation" id="meetlocation" value="<%=roomlocation%>"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">会议申请人</label>
    <div class="layui-input-inline">
      <input type="text" name="meetsqr" id="meetsqr" value="${user.name}" readonly="readonly"   autocomplete="off" class="layui-input ">
    </div>
   </div>
  
  <div class="layui-form-item">
  	<div class="layui-inline" style="display: none;>
      <label class="layui-form-label">按部门搜索</label>
      <div class="layui-input-inline">
        <select name="depart" id="depart" lay-verify="required" lay-filter="depart" lay-search="">
          <option value="">请选择部门</option>
        </select>
      </div>
    </div>
    <div class="layui-inline">
    <label class="layui-form-label">选择参会人</label>
    <div class="layui-input-inline">
      <div id="demo2" name="meetjoin" class="xm-select-demo"></div>
    </div>
    </div>
  </div>
  
  <div class="layui-form-item pane">
    <label class="layui-form-label">开始时间</label>
    <div class="layui-input-inline">
      <input type="text" name="meetstarttime" id="meetstarttime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">结束时间</label>
    <div class="layui-input-inline">
      <input type="" name="meetendtime" id="meetendtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">会议预定内容简介</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea" name="meetcontext" id="meetcontext"></textarea>
    </div>
  </div>
  <div class="layui-form-item pane" style="display: none;>
    <label class="layui-form-label">审核状态</label>
    <div class="layui-input-inline">
      <input type="text" name="shstatus" id="shstatus" value="0"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane" style="display: none;">
    <label class="layui-form-label">会议室状态</label>
    <div class="layui-input-inline">
      <input type="text" name="meetstatus" id="meetstatus"   value="0" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item layui-form-text" style="display: none;">
    <label class="layui-form-label">审核原因</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea" name="yuanyin" id="yuanyin">111</textarea>
    </div>
  </div> 		
 <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" id="btn">预定</button>
    </div>
  </div>
 
</form>

<script>
var demo2 = xmSelect.render({
	el: '#demo2', 
	filterable: true,
	toolbar: {show: true},
	data: []
})
	$.ajax({
	type:"post",
	url:"./UsernameServlet",
	dataType:"json",
	success:function(data)
	{	
		var res= data;
		
		
	demo2.update({
	
		data: res.data,
		autoRow: true,
	})
	}	
});
</script>
<script>
 var btn = document.getElementById("btn");
  btn.onclick = function(){
  		
      alert("预约成功");
      layer.close(layer.index);
	  window.parent.location.reload();
  }
</script>
<script type="text/javascript" src="js/Addmeet.js" ></script>
</body>
</html>