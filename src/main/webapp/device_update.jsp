<%@ page import="manage.DeviceManage" %>
<%@ page import="manage.impl.DeviceManageTestImpl" %>
<%@ page import="entity.Device" %>
<%@ page import="exception.DeviceException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int usertype = (int)session.getAttribute("usertype");
    if(usertype != 2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","仅物业管理员可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    int did =  Integer.parseInt(request.getParameter("did"));
    if (did < 1) {
        request.setAttribute("title", "设备信息异常");
        request.setAttribute("detail", "did编号不能小于1");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
    DeviceManage deviceManage = new DeviceManageTestImpl();
    Device device = null;
    try {
        device = deviceManage.getDevice(did);
    } catch (DeviceException e) {
        request.setAttribute("title", "设备信息异常");
        request.setAttribute("detail", e.getMessage());
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
                <input type="text" class="form-control" name="device_name" value="<%=device.getDevice_name()%>">
            </div>
            <br>

            <div class="form-group">
                <label >设备类型</label>
                <input type="text" class="form-control" name="device_type" value="<%=device.getDevice_type()%>" >
            </div>
            <br>

            <div class="form-group">
                <label >是否维修</label>
                <input type="radio" name="is_service" value="1">是
                <br>
                <input type="radio" name="is_service" value="0">否
            </div>
            <br>

            <div class="form-group">
                <label >处理意见</label>
                <input type="text" class="form-control" name="processing_opinion" value="<%=device.getProcessing_opinion()%>">
            </div>
            <br>

            <div class="form-group">
                <label >处理人</label>
                <input type="text" class="form-control" name="uid" value="<%=device.getUid()%>">
            </div>
            <br>

            <div class="text-center">
                <button type="submit" class="btn btn-info">立即添加</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />