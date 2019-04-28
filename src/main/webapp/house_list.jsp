<%@ page import="java.util.List" %>
<%@ page import="manage.HouseManage" %>
<%@ page import="manage.impl.HouseManageTestImpl" %>
<%@ page import="entity.House" %>
<%@ page import="exception.HouseException" %>
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
        HouseManage houseManage = new HouseManageTestImpl();
        List<House> houses = null;
        try {
            houses = houseManage.listHouse();
        } catch (HouseException e) {
            request.setAttribute("title","错误：");
            request.setAttribute("detail",e.getMessage());
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
        String[] typeName = new String[]{"","管理员","物业"};
        if (houses.size() == 0) {
            request.setAttribute("title","数据为空");
            request.setAttribute("detail","房产数据为空");
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
%>

<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >小区房产信息管理</h1>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>房产编号</th>
            <th>房产持有人</th>
            <th>身份证号</th>
            <th>手机号码</th>
            <th>房产类型</th>
            <th>住房面积</th>
            <th>购房时间</th>
            <th>楼号</th>
            <th>小区单元</th>
            <th>门牌号</th>
            <th>位置</th>
            <th>车牌号</th>
            <th>操作</th>
        </tr>
        <%
            for(int i=0;i<houses.size();i++) {
                House h = houses.get(i);
        %>
        <tr>
            <td><%=h.getHid()%></td>
            <td><%=h.getUserName()%></td>
            <td><%=h.getIdentity()%></td>
            <td><%=h.getPhone()%></td>
            <td><%=h.getHouseType()%></td>
            <td><%=h.getArea()%></td>
            <td><%=h.getGmtBuy()%></td>
            <td><%=h.getBuilding()%></td>
            <td><%=h.getUnit()%></td>
            <td><%=h.getHouseNum()%></td>
            <td><%=h.getLocation()%></td>
            <td><%=h.getLicenseplatenumber()%></td>
            <td><a href="<%=basePath%>house_update.jsp?hid=<%=h.getHid()%>">修改</a>&nbsp;&nbsp;<a href="<%=basePath%>dodeletehouse?hid=<%=h.getHid()%>">删除</a></td>
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