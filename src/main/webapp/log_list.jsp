<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Log" %>
<%@ page import="manage.LogManage" %>
<%@ page import="manage.impl.LogManageImpl" %>
<%@ page import="exception.LogException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    int userType = (int)session.getAttribute("usertype");
    if(userType != 1) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","仅超级管理员可查看");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    } else {
        LogManage  logManage = new LogManageImpl();
        List<Log> logs = null;
        try {
            logs = logManage.listLog();
        } catch (LogException e) {
            request.setAttribute("title","错误：");
            request.setAttribute("detail",e.getMessage());
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
        if (logs == null) {
            request.setAttribute("title","数据为空");
            request.setAttribute("detail","日志数据为空");
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
%>

<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >日志信息</h1>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>编号</th>
            <th>操作记录</th>
            <th>操作人</th>
            <th>时间</th>
        </tr>
        <%
            for(int i=0;i<logs.size();i++) {
                Log log = logs.get(i);
        %>
        <tr>
            <td><%=log.getId()%></td>
            <td><%=log.getOperation()%></td>
            <td><%=log.getOperator()%></td>
            <td><%=log.getGmt_create()%></td>

        </tr>
        <%
            }
        %>
    </table>
</div>

<jsp:include page="comm/footer.jsp" flush="true" />
<%
    }
%>