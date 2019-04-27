<%@ page import="entity.User" %>
<%@ page import="manage.UserManage" %>
<%@ page import="java.util.List" %>
<%@ page import="exception.UserException" %>
<%@ page import="manage.impl.UserManageImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int userType = (int)session.getAttribute("user_type");
    if(userType != 1) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","仅管理员可查看");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    } else {
        UserManage userManage = new UserManageImpl();
        List<User> users = null;
        try {
            users = userManage.listAllUser();
        } catch (UserException e) {
            request.setAttribute("title","错误：");
            request.setAttribute("detail",e.getMessage());
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
        String[] typeName = new String[]{"游客","管理员","物业","业主"};
        if (users.size() == 0) {
            request.setAttribute("title","数据为空");
            request.setAttribute("detail","用户数据为空");
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
%>

<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >账户管理</h1>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>用户类别</th>
            <th>操作</th>
        </tr>
        <%
            for(int i=0;i<users.size();i++) {
                User u = users.get(i);
        %>
        <tr>
            <td><%=u.getUid()%></td>
            <td><%=u.getUserName()%></td>
            <td><%=typeName[u.getUserType()]%></td>
            <td><a href="#">管理此账户</a></td>
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