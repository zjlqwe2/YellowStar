<%@ page import="entity.Cost" %>
<%@ page import="manage.CostManage" %>
<%@ page import="util.ObjectFactory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userType;
    userType = (int)session.getAttribute("user_type");
    if(userType!=1 && userType!=2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("info","管理员、物业可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    String[] typeName = new String[]{"","水费","电费","燃气费","物业费","停车费"};
    int costType = 0;
    costType = Integer.valueOf(request.getParameter("cost_type"));
    if(costType == 0 || costType>5) {
        request.setAttribute("title","参数错误");
        request.setAttribute("info","costType值不正确");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    CostManage costManage = (CostManage) ObjectFactory.getObject("CostManage");
    List<Cost> costs = costManage.listAllCost(costType);
    if (costs.size() == 0) {
        request.setAttribute("title","没有数据");
        request.setAttribute("info","没有费用信息");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >所有业主<%=typeName[costType]%>费信息查询</h1>

<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>业主</th>
            <th>单价</th>
            <th>用量</th>
            <th>金额</th>
            <th>产生时间</th>
        </tr>
        <%
            for(int i=0;i<costs.size();i++)
            {
                Cost cost = costs.get(i);
                double money = cost.getAmount()*cost.getUnitPrice();
        %>
        <tr>
            <td><%=cost.getUserName()%></td>
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