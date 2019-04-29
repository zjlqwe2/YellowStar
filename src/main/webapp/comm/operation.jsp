<%@ page import="entity.House" %>
<%@ page import="manage.HouseManage" %>
<%@ page import="manage.impl.HouseManageTestImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int operation_hid = 0 ;
    operation_hid = Integer.valueOf(request.getParameter("operation_hid"));
    if(operation_hid > 0 ) {
        HouseManage houseManage = new HouseManageTestImpl();
        House house = houseManage.getHouse(operation_hid);
        // 处理没有获取用户的情况，防止用户乱传参
        if(house == null) {
            request.setAttribute("title", "房产信息异常");
            request.setAttribute("detail", "业主不存在");
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
%>
<div class="well">
    <p>当前选中业主：<%=house.getUserName()%></p>
    <p>操作：<a href="create_cost.jsp?cost_type=1&operation_hid=<%=operation_hid%>">添加水费</a>、
        <a href="create_cost.jsp?cost_type=2&operation_hid=<%=operation_hid%>">添加电费</a>、
        <a href="create_cost.jsp?cost_type=3&operation_hid=<%=operation_hid%>">添加物业费</a></p>
</div>
<%
    }
%>