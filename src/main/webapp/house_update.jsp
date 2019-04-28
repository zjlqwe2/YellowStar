<%@ page import="manage.HouseManage" %>
<%@ page import="manage.impl.HouseManageTestImpl" %>
<%@ page import="entity.House" %>
<%@ page import="exception.HouseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int usertype = (int)session.getAttribute("usertype");
    if(usertype != 2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","仅物业管理员可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    int hid =  Integer.parseInt(request.getParameter("hid"));
    if (hid < 1) {
        request.setAttribute("title", "房产信息异常");
        request.setAttribute("detail", "hid编号不能小于1");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    HouseManage houseManage = new HouseManageTestImpl();
    House house = null;
    try {
        house = houseManage.getHouse(hid);
    } catch (HouseException e) {
        request.setAttribute("title", "房产信息异常");
        request.setAttribute("detail", e.getMessage());
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />
<div class="panel panel-primary">
    <div class="panel-heading text-center">修改小区房产信息</div>
    <div class="panel-body">
        <form action="doupdatehouse" method="POST">
            <input type="hidden" name="hid" value="<%=house.getHid()%>">
            <div class="form-group">
                <label >房产持有人</label>
                <input type="text" class="form-control" name="user_name" value="<%=house.getUserName()%>">
            </div>
            <br>

            <div class="form-group">
                <label >身份证号</label>
                <input type="text" class="form-control" name="identity" value="<%=house.getIdentity()%>">
            </div>
            <br>

            <div class="form-group">
                <label >手机号码</label>
                <input type="text" class="form-control" name="phone" value="<%=house.getPhone()%>">
            </div>
            <br>

            <div class="form-group">
                <label >房产类型</label>
                <input type="text" class="form-control" name="house_type" value="<%=house.getHouseType()%>">
            </div>
            <br>

            <div class="form-group">
                <label >住房面积</label>
                <input type="text" class="form-control" name="area" value="<%=house.getArea()%>">
            </div>
            <br>

            <div class="form-group">
                <label >购房时间</label>
                <input type="text" class="form-control" name="gmt_buy" value="<%=house.getGmtBuy()%>">
            </div>
            <br>

            <div class="form-group">
                <label >楼号</label>
                <input type="text" class="form-control" name="building" value="<%=house.getBuilding()%>">
            </div>
            <br>

            <div class="form-group">
                <label >小区单元</label>
                <input type="text" class="form-control" name="unit" value="<%=house.getUnit()%>">
            </div>
            <br>

            <div class="form-group">
                <label >门牌号</label>
                <input type="text" class="form-control" name="house_num" value="<%=house.getHouseNum()%>">
            </div>
            <br>

            <div class="form-group">
                <label >位置</label>
                <input type="text" class="form-control" name="location" value="<%=house.getLocation()%>">
            </div>
            <br>

            <div class="form-group">
                <label >车牌号</label>
                <input type="text" class="form-control" name="licenseplatenumber" value="<%=house.getLicenseplatenumber()%>">
            </div>
            <br>



            <div class="text-center">
                <button type="submit" class="btn btn-info">立即修改</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />