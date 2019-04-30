<%@ page import="manage.CostManage" %>
<%@ page import="entity.Cost" %>
<%@ page import="exception.CostException" %>
<%@ page import="java.util.Map" %>
<%@ page import="entity.House" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="manage.impl.CostManageImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String[] costname = {"","水费","电费","物业"};
    int cost_type = Integer.parseInt(request.getParameter("cost_type"));
    CostManage costManage = new CostManageImpl();
    Map<Cost, House> maps = null;
    try {
        maps = costManage.listAllCost(cost_type);
    } catch (CostException e) {
        request.setAttribute("title","错误：");
        request.setAttribute("detail",e.getMessage());
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    if (maps == null) {
        request.setAttribute("title","数据为空");
        request.setAttribute("detail","费用数据为空");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>

<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >小区<%=costname[cost_type]%>信息查询</h1>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>费用类型</th>
            <th>业主姓名</th>
            <th>价格</th>
            <th>创建时间</th>

        </tr>
        <%
            Integer integ = null;
            Iterator iter = maps.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry)iter.next();
                Cost c = (Cost) entry.getKey();
                House h = (House) entry.getValue();
        %>
        <tr>
            <td><%=costname[cost_type]%></td>
            <td><%=h.getUserName()%></td>
            <td><%=c.getPrice()%></td>
            <td><%=c.getGmtCreate()%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<jsp:include page="comm/footer.jsp" flush="true" />