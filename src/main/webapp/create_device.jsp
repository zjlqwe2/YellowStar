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
    <div class="panel-heading text-center">添加小区设备信息</div>
    <div class="panel-body">
        <form action="docreatedevice" method="POST">
            <div class="form-group">
                <label >设备名称</label>
                <input type="text" class="form-control" name="device_name">
            </div>
            <br>

            <div class="form-group">
                <label >设备类型</label>
                <input type="text" class="form-control" name="device_type" >
            </div>
            <br>

            <div class="form-group">
                <label >是否维修</label>
                <input type="radio" name="is_service" checked value="1">是
                <br>
                <input type="radio" name="is_service" value="0">否
            </div>
            <br>

            <div class="form-group">
                <label >处理意见</label>
                <input type="text" class="form-control" name="processing_opinion">
            </div>
            <br>

            <div class="form-group">
                <label >处理人</label>
                <input type="text" class="form-control" name="handlers">
            </div>
            <br>

            <div class="text-center">
                <button type="submit" class="btn btn-info">立即添加</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />