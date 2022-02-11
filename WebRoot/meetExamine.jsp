<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会议审核界面</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<script type="text/javascript" src="jquery-3.3.1/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="layui/layui.js" ></script>
<form  action="./UpdateMeetExamineServlet" method="post" class="layui-form layui-form-pane"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  <div class="layui-input-inline" style="display: none;>
    <label class="layui-form-label">id</label>
    <div class="layui-input-inline">
      <input type="text" name="id" id="id"  value="${m.id}" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-input-inline">
    <label class="layui-form-label">会议主题</label>
    <div class="layui-input-inline">
      <input type="text" name="meetname" id="meetname"  value="${m.meetname }" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-input-inline" style="float:left;">
    <label class="layui-form-label">会议地点</label>
    <div class="layui-input-inline">
      <input type="text" name="meetlocation" value="${m.meetlocation }"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-input-inline">
    <label class="layui-form-label">会议申请人</label>
    <div class="layui-input-inline">
      <input type="text" name="meetsqr" value="${m.meetsqr }"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  
  <div class="layui-input-inline">
    <label class="layui-form-label">会议参与人</label>
    <div class="layui-input-inline">
      <input type="text" name="meetjoin" value="${m.meetjoin }"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">会议预定内容简介</label>
    <div class="layui-input-block">
      <textarea  value="${m.meetcontext}" class="layui-input"name="meetcontext" id="meetcontext">${m.meetcontext}</textarea>
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">会议开始时间</label>
    <div class="layui-input-inline">
      <input type="text" name="meetstarttime" value="${m.meetstarttime }"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-form-item pane">
    <label class="layui-form-label">会议结束时间</label>
    <div class="layui-input-inline">
      <input type="text" name="meetendtime" value="${m.meetendtime}"  autocomplete="off" class="layui-input ">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">审核</label>
    <div class="layui-input-block">
      <input type="radio" name="shstatus" value="11" title="通过" checked="">
      <input type="radio" name="shstatus" value="10" title="拒绝">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">审核意见</label>
    <div class="layui-input-block">
      <textarea  value="" class="layui-input"name="yuanyin" id="yuanyin">${m.yuanyin}</textarea>
    </div>
  </div>
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-filter="tijiao" id="btn1">完成</button>
    </div>
  </div> 
</form>
<script type="text/javascript">

layui.use('form', function () {
      var form = layui.form; 
      form.render();
    
});
</script>
<script>

</script>
</body>
</html>