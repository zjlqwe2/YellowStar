<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int usertype = (int)session.getAttribute("usertype");
    if(usertype != 1) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","仅管理员可操作");
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
                <input type="password" class="form-control" name="password" placeholder="密码">
            </div>
            <br>
            <div class="form-group">
                <label  name="usertype">用户类别</label>
                <select name="usertype" class="form-control" >
                    <option value="2">物业</option>
                    <option value="1">系统管理员</option>
                </select>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-info">立即创建</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />