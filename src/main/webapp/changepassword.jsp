<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int usertype = (int)session.getAttribute("usertype");
    if(usertype<1 || usertype>2) {
        request.setAttribute("title","权限错误");
        request.setAttribute("detail","必须登陆");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

%>
<jsp:include page="comm/header.jsp" flush="true" />
<jsp:include page="comm/nav.jsp" flush="true" />
<div class="panel panel-primary">
    <div class="panel-heading text-center">添加费用</div>
    <div class="panel-body">
        <form action="dochangepassword" method="POST">
            <div class="form-group">
                <label >密码</label>
                <input type="password" class="form-control" name="password1">
            </div>
            <br>
            <div class="form-group">
                <label >再次输入密码</label>
                <input type="password" class="form-control" name="password2">
            </div>
            <br>
            <div class="text-center">
                <button type="submit" class="btn btn-info">立即修改</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />