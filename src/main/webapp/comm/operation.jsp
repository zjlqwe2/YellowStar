<%@ page import="entity.House" %>
<%@ page import="manage.HouseManage" %>
<%@ page import="util.ObjectFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int hid = 0 ;
    hid = Integer.valueOf(request.getParameter("hid"));
    if(hid <= 0 ) {
%>
<div class="well">
    <p>尚未选择业主，请在下表中选择。</p>
</div>
<%
    } else {
        HouseManage houseManage = (HouseManage) ObjectFactory.getObject("HouseManage");
        House house = houseManage.getHouse(hid);
        // 处理没有获取用户的情况，防止用户乱传参
        if(house == null) {
            request.setAttribute("title", "房产信息异常");
            request.setAttribute("info", "业主不存在");
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
%>
<div class="well">
    <p>当前选中业主：<%=house.getUsername()%></p>
    <p>可以直接管理：<a href="addcost.jsp?cost_type=2">水费</a>、<a href="addcost.jsp?cost_type=1">电费</a>、<a href="addcost.jsp?cost_type=3">燃气费</a>、<a href="addcost.jsp?cost_type=5">停车费</a>、<a href="addcost.jsp?cost_type=4">物业费</a></p>
</div>
<%
    }
%>

