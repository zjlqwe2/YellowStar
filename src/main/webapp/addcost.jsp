<%@ page import="java.net.URLDecoder" %>
<%@ page import="entity.House" %>
<%@ page import="manage.UnitPriceManage" %>
<%@ page import="util.ObjectFactory" %>
<%@ page import="manage.HouseManage" %>
<%@ page import="exception.HouseException" %>
<%@ page import="exception.CostException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] typeName = new String[]{"","水费","电费","燃气费","物业费","停车费"};

    int userType = (int)session.getAttribute("user_type");
    if(userType!=1 && userType!=2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("info","管理员、物业可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

    int costType = 0;
    costType = Integer.valueOf(request.getParameter("cost_type"));
    if(costType <= 0 || costType >= 5) {
        request.setAttribute("title","参数错误");
        request.setAttribute("info","costType数值错误");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

    Cookie[] cookies = request.getCookies();
    String strHid = "";
    int hid = 0;
    for (Cookie key : cookies) {
        if ("operationHid".equals(key)) {
            strHid = URLDecoder.decode(key.getValue(), "utf-8");
        }
    }

    if ("".equals(strHid)) {
        response.sendRedirect("housemanage.jsp");
    } else {
        // 获取到操作对象hid
        hid = Integer.parseInt(strHid);
    }

    UnitPriceManage unitPriceManage = (UnitPriceManage) ObjectFactory.getObject("UnitPriceManage");
    HouseManage houseManage = (HouseManage)ObjectFactory.getObject("HouseManage");

    House house = null;
    try {
         house = houseManage.getHouse(hid);
    } catch (HouseException e) {
        request.setAttribute("title","房产信息异常");
        request.setAttribute("info",e.getMessage());
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

    double unitPrice = 0;
    try {
        unitPrice = unitPriceManage.getUnitPrice(costType);
    } catch (CostException e) {
        request.setAttribute("title","单价信息异常");
        request.setAttribute("info",e.getMessage());
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />
<div class="panel panel-info">
    <div class="panel-heading text-center"><%=typeName[costType]%>费用信息录入</div>
    <div class="panel-body">
        <form action="doaddcost" class="form-horizontal" method="POST">
            <input type="text" hidden value="<%=costType%>" name="cost_type">
            <div class="form-group col-sm-12">
                <label class="col-sm-2 control-label">业主:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="housename" placeholder="单价" value="<%=house.getUsername()%>" disabled>
                </div>
                <br>
                <br>
                <br>
                <div class="col-sm-12">
                    <label class="col-sm-2 control-label">费用单价:</label>
                    <div class="input-group col-sm-9">
                        <input type="text" class="form-control" name="price" placeholder="单价" value="<%=unitPrice%>" disabled>
                        <span class="input-group-addon" id="basic-addon2">元</span>
                    </div>
                </div>
                <br><br><br>


                <div class="form-group col-sm-12">
                    <label class="col-sm-2 control-label">用量:</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="amount" placeholder="用量">
                    </div>
                </div>
                <br>

            <br>
            <div class="text-center">
                <button type="submit" class="btn btn-info">立即添加</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />