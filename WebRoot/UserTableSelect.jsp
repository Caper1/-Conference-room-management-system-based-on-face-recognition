<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看详情界面</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<form  action="" method="post" class="layui-form layui-form-pane"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  <div class="layui-input-inline">
    <label class="layui-form-label">员工ID</label>
    <div class="layui-input-inline">
      <input type="text" name="id" id="id"  value="${c.id}" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-input-inline">
    <label class="layui-form-label">员工名字</label>
    <div class="layui-input-inline">
      <input type="text" name="meetname" id="meetname"  value="${c.name }" autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-input-inline">
    <label class="layui-form-label">员工手机</label>
    <div class="layui-input-inline">
      <input type="text" name="meetlocation" value="${c.tel }"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  <div class="layui-input-inline">
    <label class="layui-form-label">部门</label>
    <div class="layui-input-inline">
      <input type="text" name="meetsqr" value="${c.bumen }"  autocomplete="off" class="layui-input ">
    </div>
  </div>
  
  <div class="layui-input-inline">
    <label class="layui-form-label">职位</label>
    <div class="layui-input-inline">
      <input type="text" name="meetjoin" value="${c.zhiwei }"  autocomplete="off" class="layui-input ">
    </div>
  </div>
</form>
<script src="./layui/layui.js"></script>

<script>


</script>
</body>
</html>