<%--
  Created by IntelliJ IDEA.
  User: ruanfumin
  Date: 2019-02-19
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="comm/header.jsp" flush="true"/>
<jsp:include page="comm/nav.jsp"  />

<!-- 中间标题 -->
<div class="page-header">
    <h1 class="text-center">
        欢迎登陆 <small>Yellow Star 物业管理系统</small>
    </h1>
</div>
<!-- 登陆表单 -->
<form class="form-horizontal" action="dologin" method="POST" >
    <div class="form-group">
        <label for="loginname" class="col-sm-3 control-label">用户名</label>
        <div class="col-sm-8">
            <input type="text" name="loginname" class="form-control" id="loginname" placeholder="用户名">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-3 control-label">密码</label>
        <div class="col-sm-8">
            <input type="password" name="password" class="form-control" id="password" placeholder="密码">
        </div>
    </div>
    <div class="text text-center">
        <button type="submit" class="btn btn-primary">登陆</button>
        <button type="reset" class="btn btn-default">重置</button>
    </div>
    </div>
</form>
<!-- 登陆表单结束 -->

<jsp:include page="comm/footer.jsp" flush="true"/>