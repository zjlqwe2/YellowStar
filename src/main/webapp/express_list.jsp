<%@ page import="java.util.List" %>
<%@ page import="manage.ExpressManage" %>
<%@ page import="entity.Express" %>
<%@ page import="exception.ExpressException" %>
<%@ page import="manage.impl.ExpressManageTestImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    int userType = (int)session.getAttribute("usertype");
    if(userType != 2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","仅物业管理员可查看");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    } else {
        ExpressManage expressManage = new ExpressManageTestImpl();
        List<Express> lists = null;
        try {
            lists = expressManage.listNotTakeExpress();
        } catch (ExpressException e) {
            request.setAttribute("title","错误：");
            request.setAttribute("detail",e.getMessage());
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
        if (lists.size() == 0) {
            request.setAttribute("title","数据为空");
            request.setAttribute("detail","快递数据为空");
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
%>

<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >小区快递信息管理</h1>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>编号</th>
            <th>快递名称</th>
            <th>姓名</th>
            <th>手机号码</th>
            <th>快递单号</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        <%
            for(int i=0;i<lists.size();i++) {
                Express e = lists.get(i);
        %>
        <tr>
            <td><%=e.getEid()%></td>
            <td><%=e.getExpress_name()%></td>
            <td><%=e.getUsername()%></td>
            <td><%=e.getPhone()%></td>
            <td><%=e.getExpress_id()%></td>
            <td><%=e.getGmt_create()%></td>
            <td><a href="<%=basePath%>express_take?did=<%=e.getEid()%>">点击领取</a></td>
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