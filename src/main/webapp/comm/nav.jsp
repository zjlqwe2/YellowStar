<%--
  Created by IntelliJ IDEA.
  User: ruanfumin
  Date: 2019-02-12
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- 导航部分 -->
<%--游客导航--%>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="<%=basePath%>index.jsp">Yellow Star</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li>
                <a href="<%=basePath%>index.jsp">主页</a>
            </li>
            <li>
                <a href="<%=basePath%>about.jsp">关于我们</a>
            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="<%=basePath%>login.jsp">当前身份：游客</a>
            </li>
            <li>
                <a href="<%=basePath%>login.jsp">点击登陆</a>
            </li>
        </ul>
    </div>
</nav>
<!-- 导航部分结束 -->