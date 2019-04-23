<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String userName = "";
    int userType = 0;
    if (session.getAttribute("userName") != null) {
        userName = (String)session.getAttribute("userName");
        userType = (int)session.getAttribute("userType");
    }

    switch (userType) {
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
                    <li><a href="<%=basePath%>createuser.jsp">创建用户</a></li>
                    <li><a href="<%=basePath%>usermanage.jsp">用户管理</a></li>
                    <li class="dropdown-header">房产信息管理</li>
                    <li><a href="<%=basePath%>addhouse.jsp">添加房产信息</a></li>
                    <li><a href="<%=basePath%>housemanage.jsp?hid=0">查看房产信息</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">费用录入<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>addcost.jsp?cost_type=2">电费录入</a></li>
                    <li><a href="<%=basePath%>addcost.jsp?cost_type=1">水费录入</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">费用查询<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-header">电费</li>
                    <li><a href="<%=basePath%>costmanage.jsp?cost_type=2">电费查询</a></li>
                    <li><a href="<%=basePath%>allcostmanage.jsp?cost_type=2">总电费查询</a></li>
                    <li role="separator" class="divider"></li>
                    <li class="dropdown-header">水费</li>
                    <li><a href="<%=basePath%>costmanage.jsp?cost_type=1">水费查询</a></li>
                    <li><a href="<%=basePath%>allcostmanage.jsp?cost_type=1">总水费查询</a></li>
                    <li role="separator" class="divider"></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">快递管理<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>addexpress.jsp">添加快递</a></li>
                    <li><a href="<%=basePath%>expressmanage.jsp">快递查询</a></li>
                </ul>
            </li>
        </ul>
        <%--导航右侧部分--%>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="<%=basePath%>profile.jsp" >管理员：<%=userName%></a>
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
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">费用录入<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>housemanage.jsp?hid=0">查看房产信息</a></li>
                    <li><a href="<%=basePath%>addcost.jsp?cost_type=2">电费录入</a></li>
                    <li><a href="<%=basePath%>addcost.jsp?cost_type=1">水费录入</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">费用查询<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-header">电费</li>
                    <li><a href="<%=basePath%>costmanage.jsp?cost_type=2">电费查询</a></li>
                    <li><a href="<%=basePath%>allcostmanage.jsp?cost_type=2">总电费查询</a></li>
                    <li role="separator" class="divider"></li>
                    <li class="dropdown-header">水费</li>
                    <li><a href="<%=basePath%>costmanage.jsp?cost_type=1">水费查询</a></li>
                    <li><a href="<%=basePath%>allcostmanage.jsp?cost_type=1">总水费查询</a></li>
                    <li role="separator" class="divider"></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">快递管理<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>addexpress.jsp">添加快递</a></li>
                    <li><a href="<%=basePath%>expressmanage.jsp">快递查询</a></li>
                </ul>
            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="<%=basePath%>profile.jsp">物业：<%=userName%></a>
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
    case 3:
%>
<!-- 导航部分 -->
<%--业主导航--%>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="<%=basePath%>index.jsp">Yellow Star</a>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li>
                <a href="<%=basePath%>index.jsp">主页</a>
            </li>
            <li>
                <a href="<%=basePath%>aboutme.jsp">关于我们</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="<%=basePath%>profile.jsp">业主：<%=userName%></a>
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