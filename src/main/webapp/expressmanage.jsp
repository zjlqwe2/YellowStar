<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String get_str = "未领取";
    int userType = (int)session.getAttribute("user_type");
    if(userType!=1 && userType!=2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("info","管理员、物业可操作");
    }

%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />
<h2 class="text-center" >小区快递管理</h2>
<div class="table-responsive">

    <table class="table table-hover table-striped">
        <tr>
            <th>手机号码</th>
            <th>姓名</th>
            <th>地址</th>
            <th>状态</th>
            <th>快递添加时间</th>
        </tr>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>

    </table>

</div>
<jsp:include page="comm/footer.jsp" flush="true" />