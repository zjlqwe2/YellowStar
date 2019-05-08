<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String loginname = "";
    int usertype = 0;

    if (session.getAttribute("loginname") != null) {
        loginname = (String)session.getAttribute("loginname");
        usertype = (int)session.getAttribute("usertype");
        System.out.println(usertype);
    }

    switch (usertype) {
        case 1:
%>
<!-- 导航部分 -->
<%--管理员导航--%>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="<%=basePath%>index.jsp">Yellow Star</a>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li>
                <a href="<%=basePath%>index.jsp">主页</a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">基础管理<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-header">用户管理</li>
                    <li><a href="<%=basePath%>create_user.jsp">创建用户</a></li>
                    <li><a href="<%=basePath%>user_list.jsp">用户管理</a></li>
                </ul>
            </li>

            <li>
                <a href="<%=basePath%>log_list.jsp">查看日志</a>
            </li>

            <li>
                <a href="<%=basePath%>about.jsp">关于我们</a>
            </li>

        </ul>
        <%--导航右侧部分--%>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="<%=basePath%>profile.jsp" >超级管理员：<%=loginname%></a>
            </li>
            <li class="dropdown">
                <a href="<%=basePath%>changepassword.jsp" >修改密码</a>
            </li>
            <li>
                <a href="<%=basePath%>logout">注销登陆</a>
            </li>
        </ul>
    </div>
</nav>
<!-- 导航部分结束 -->
<%
        break;
    case 2:
%>
<!-- 导航部分 -->
<%--物业导航--%>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="<%=basePath%>index.jsp">Yellow Star</a>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li>
                <a href="<%=basePath%>index.jsp">主页</a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">房产管理<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>house_list.jsp">查看房产信息</a></li>
                    <li><a href="<%=basePath%>create_house.jsp">添加房产信息</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">费用查询<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-header">水费</li>
                    <li><a href="<%=basePath%>cost_list.jsp?cost_type=1">水费查询</a></li>
                    <li><a href="<%=basePath%>create_cost.jsp?cost_type=1">添加水费</a></li>
                    <li role="separator" class="divider"></li>
                    <li class="dropdown-header">水费</li>
                    <li><a href="<%=basePath%>cost_list.jsp?cost_type=2">电费查询</a></li>
                    <li><a href="<%=basePath%>create_cost.jsp?cost_type=2">添加电费</a></li>
                    <li role="separator" class="divider"></li>
                    <li class="dropdown-header">物业费</li>
                    <li><a href="<%=basePath%>cost_list.jsp?cost_type=3">物业费查询</a></li>
                    <li><a href="<%=basePath%>create_cost.jsp?cost_type=3">添加物业费</a></li>
                    <li role="separator" class="divider"></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">设备管理<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>device_list.jsp">设备查询</a></li>
                    <li><a href="<%=basePath%>create_device.jsp">添加设备</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">快递管理<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>express_list.jsp">快递查询</a></li>
                    <li><a href="<%=basePath%>taked_express_list.jsp">已领快递</a></li>
                    <li><a href="<%=basePath%>create_express.jsp">添加快递</a></li>
                </ul>
            </li>

            <li>
                <a href="<%=basePath%>about.jsp">关于我们</a>
            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="<%=basePath%>profile.jsp">物业管理员：<%=loginname%></a>
            </li>
            <li class="dropdown">
                <a href="<%=basePath%>changepassword.jsp" >修改密码</a>
            </li>
            <li>
                <a href="<%=basePath%>logout">注销登陆</a>
            </li>
        </ul>
    </div>
</nav>
<!-- 导航部分结束 -->

<%
        break;
    default:
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
                <a href="<%=basePath%>open_house_list.jsp">房产信息查询</a>
            </li>


            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">费用查询<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>open_cost_list.jsp?cost_type=1">水费查询</a></li>
                    <li><a href="<%=basePath%>open_cost_list.jsp?cost_type=2">电费查询</a></li>
                    <li><a href="<%=basePath%>open_cost_list.jsp?cost_type=3">物业费查询</a></li>
                </ul>
            </li>

            <li>
                <a href="<%=basePath%>open_express_list.jsp">快递查询</a>
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
<%
            break;
    }
%>