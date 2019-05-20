<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />

<h1 class="text-center" >账户管理</h1>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <tr>
            <th>用户id</th>
            <th>用户名</th>
            <th>用户类别</th>
            <th>操作</th>
        </tr>

    </table>
</div>

<jsp:include page="comm/footer.jsp" flush="true" />
