<%@ page import="entity.House" %>
<%@ page import="manage.HouseManage" %>
<%@ page import="util.ObjectFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="exception.HouseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userType = (int)session.getAttribute("user_type");
    if(userType!=1 && userType!=2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("info","管理员、物业可查看房产信息");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    } else {
        int hid = 0;
        if(request.getParameter("hid") != null) {
            hid = Integer.valueOf(request.getParameter("hid"));
        }
        // 业主的hid保存到cookie中,以便在其他费用添加页面使用
        Cookie cookie = new Cookie("operationHid",String.valueOf(hid));
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        HouseManage houseManage = (HouseManage) ObjectFactory.getObject("HouseManage");
        List<House> houses = new ArrayList<House>();
        try {
            houses = houseManage.listHouse();
        } catch (HouseException e) {
            request.setAttribute("title","房产信息异常");
            request.setAttribute("info",e.getMessage());
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />
<h1 class="text-center" >小区房产数据管理</h1>
<jsp:include page="comm/operation.jsp" >
    <jsp:param name="hid" value="<%=hid%>" />
</jsp:include>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>房屋ID</th>
            <th>房产持有人</th>
            <th>房型</th>
            <th>住房面积</th>
            <th>购房时间</th>
            <th>楼号</th>
            <th>小区单元</th>
            <th>门牌号</th>
            <th>操作</th>
        </tr>
        <%
            for(House h:houses) {
        %>
        <tr>
            <td><%=h.getHid()%></td>
            <td><%=h.getUsername()%></td>
            <td><%=h.getHouse_type()%></td>
            <td><%=h.getArea()%>平米</td>
            <td><%=h.getGmt_buy()%></td>
            <td><%=h.getBuilding()%></td>
            <td><%=h.getUnit()%></td>
            <td><%=h.getHouse_num()%></td>
            <td><a href="housemanage.jsp?hid=<%=h.getHid()%>">选中该业主</a></td>
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