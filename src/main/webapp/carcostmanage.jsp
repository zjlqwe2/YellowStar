<%@ page import="java.net.URLDecoder" %>
<%@ page import="manage.CostManage" %>
<%@ page import="util.ObjectFactory" %>
<%@ page import="exception.CostException" %>
<%@ page import="entity.StallCost" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userType = (int)session.getAttribute("user_type");
    if(userType!=1 && userType!=2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("info","管理员、物业可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

    int costType = Integer.valueOf(request.getParameter("cost_type"));
    if(costType != 5) {
        request.setAttribute("title","参数错误");
        request.setAttribute("info","cost_type数值异常");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

    String strHid = "";
    int hid = 0;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i=0;i<cookies.length;i++) {
            if ( "operationHid".equals(cookies[i].getName()) ) {
                strHid = URLDecoder.decode(cookies[i].getValue(), "utf-8");
            }
        }
        if ("".equals(strHid)) {
            response.sendRedirect("housemanage.jsp");
        } else {
            hid = Integer.parseInt(strHid);
        }
    }
    CostManage costManage = (CostManage) ObjectFactory.getObject("CostManage");
    List<StallCost> list = new ArrayList<StallCost>();
    try {
        list = costManage.listTypeCost(hid, 5);
    } catch (CostException e) {
        request.setAttribute("title","费用信息异常");
        request.setAttribute("info",e.getMessage());
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    if (list.size() == 0) {
        request.setAttribute("title","没有数据");
        request.setAttribute("info","没有停车费用信息");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >单一业主停车费信息查询</h1>

<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>业主</th>
            <th>车牌号</th>
            <th>单价</th>
            <th>用量</th>
            <th>金额</th>
            <th>产生时间</th>
        </tr>
        <%
            for(StallCost cost:list) {
                double money = (cost.getAmount())*(cost.getUnitPrice());
        %>
        <tr>
            <td><%=cost.getUserName()%></td>
            <td><%=cost.getLicenseplatenumber()%></td>
            <td><%=cost.getUnitPrice()%></td>
            <td><%=cost.getAmount()%></td>
            <td><%=money%></td>
            <td><%=cost.getGmtCreate()%></td>
        </tr>
        <%
            }
        %>
    </table>

<jsp:include page="comm/footer.jsp" flush="true" />