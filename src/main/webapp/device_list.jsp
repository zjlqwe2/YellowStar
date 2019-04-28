<%@ page import="java.util.List" %>
<%@ page import="manage.DeviceManage" %>
<%@ page import="manage.impl.DeviceManageTestImpl" %>
<%@ page import="entity.Device" %>
<%@ page import="exception.DeviceException" %>
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
        DeviceManage deviceManage = new DeviceManageTestImpl();
        List<Device> devices = null;
        try {
            devices = deviceManage.listDevice();
        } catch (DeviceException e) {
            request.setAttribute("title","错误：");
            request.setAttribute("detail",e.getMessage());
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
        String[] typeName = new String[]{"","管理员","物业"};
        if (devices.size() == 0) {
            request.setAttribute("title","数据为空");
            request.setAttribute("detail","设备数据为空");
            request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
        }
%>

<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >小区房产信息管理</h1>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>编号</th>
            <th>设备名称</th>
            <th>设备类型</th>
            <th>是否维修</th>
            <th>处理意见</th>
            <th>处理人</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        <%
            for(int i=0;i<devices.size();i++) {
                Device device = devices.get(i);
        %>
        <tr>
            <td><%=device.getDid()%></td>
            <td><%=device.getDevice_name()%></td>
            <td><%=device.getDevice_type()%></td>
            <td><%=device.getIs_service()%></td>
            <td><%=device.getProcessing_opinion()%></td>
            <td><%=device.getProcessing_opinion()%></td>
            <td><%=device.getGmt_create()%></td>
            <td><a href="<%=basePath%>device_update.jsp?did=<%=device.getDid()%>">修改</a>&nbsp;&nbsp;<a href="<%=basePath%>dodeletedevice?did=<%=device.getDid()%>">删除</a></td>
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