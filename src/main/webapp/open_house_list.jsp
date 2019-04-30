<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="manage.HouseManage" %>
<%@ page import="entity.House" %>
<%@ page import="exception.HouseException" %>
<%@ page import="manage.impl.HouseManageImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    HouseManage houseManage = new HouseManageImpl();
    List<House> houses = null;
    try {
        houses = houseManage.listHouse();
    } catch (HouseException e) {
        request.setAttribute("title","错误：");
        request.setAttribute("detail",e.getMessage());
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    String[] typeName = new String[]{"","管理员","物业"};
    if (houses == null) {
        request.setAttribute("title","数据为空");
        request.setAttribute("detail","房产数据为空");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>

<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >小区房产信息查询</h1>
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
            <th>车辆信息</th>
            <th>车牌号</th>
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
            <c:set value="<%=h.getLocation()%>" var="location" ></c:set>
            <c:set value="<%=h.getBrand()%>" var="brand" ></c:set>
            <c:set value="<%=h.getLicenseplatenumber()%>" var="Licenseplatenumber" ></c:set>
            <td><c:out value="${location}" default="无" escapeXml="false"></c:out></td>
            <td><c:out value="${brand}" default="无" escapeXml="false"></c:out></td>
            <td><c:out value="${Licenseplatenumber}" default="无" escapeXml="false"></c:out></td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<jsp:include page="comm/footer.jsp" flush="true" />