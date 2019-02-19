<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userType = (int)session.getAttribute("user_type");
    if(userType != 1) {
        request.setAttribute("title","权限不足");
        request.setAttribute("info","仅管理员可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />
<div class="panel panel-primary">
    <div class="panel-heading text-center">创建用户</div>
    <div class="panel-body">
        <form action="docreateuser" method="POST">
            <div class="form-group">
                <label >账号</label>
                <p class="help-block">支持中文、字母、数字</p>
                <input type="text" class="form-control" name="loginname" placeholder="账号">
            </div>
            <div class="form-group">
                <label >初始密码</label>
                <input type="password" class="form-control" name="password" placeholder="初始密码">
            </div>
            <br>
            <div class="form-group">
                <label >用户姓名</label>
                <p class="help-block">支持中文、字母、数字</p>
                <input type="text" class="form-control" name="username" placeholder="用户名">
            </div>
            <br>
            <div class="form-group">
                <label >手机</label>
                <input type="text" class="form-control" name="phone" placeholder="用户名">
            </div>
            <br>
            <div class="form-group">
                <label  name="user_type">用户类别</label>
                <select name="user_type" class="form-control" >
                    <option value="3">业主</option>
                    <option value="2">物业</option>
                    <option value="1">管理员</option>
                </select>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-info">立即创建</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />