<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int usertype = (int)session.getAttribute("usertype");
    if(usertype != 2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","仅物业管理员可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />
<div class="panel panel-primary">
    <div class="panel-heading text-center">添加小区房产信息</div>
    <div class="panel-body">
        <form action="docreatehouse" method="POST">
            <div class="form-group">
                <label >房产持有人</label>
                <input type="text" class="form-control" name="user_name">
            </div>
            <br>

            <div class="form-group">
                <label >身份证号</label>
                <input type="text" class="form-control" name="identity" >
            </div>
            <br>

            <div class="form-group">
                <label >手机号码</label>
                <input type="text" class="form-control" name="phone" >
            </div>
            <br>

            <div class="form-group">
                <label >房产类型</label>
                <input type="text" class="form-control" name="house_type">
            </div>
            <br>

            <div class="form-group">
                <label >住房面积</label>
                <input type="text" class="form-control" name="area">
            </div>
            <br>

            <div class="form-group">
                <label >购房时间</label>
                <input type="text" class="form-control" name="gmt_buy">
            </div>
            <br>

            <div class="form-group">
                <label >楼号</label>
                <input type="text" class="form-control" name="building">
            </div>
            <br>

            <div class="form-group">
                <label >小区单元</label>
                <input type="text" class="form-control" name="unit">
            </div>
            <br>

            <div class="form-group">
                <label >门牌号</label>
                <input type="text" class="form-control" name="house_num" >
            </div>
            <br>

            <div class="form-group">
                <label >位置</label>
                <input type="text" class="form-control" name="location" >
            </div>
            <br>

            <div class="form-group">
                <label >车牌号</label>
                <input type="text" class="form-control" name="licenseplatenumber">
            </div>
            <br>



            <div class="text-center">
                <button type="submit" class="btn btn-info">添加房产信息</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />