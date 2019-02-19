<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userType = (int)session.getAttribute("user_type");
    if(userType!=1 && userType!=2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("info","管理员、物业可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />
<div class="panel panel-info">
    <div class="panel-heading text-center">快递信息录入</div>
    <div class="panel-body">
        <form action="doaddexpress" class="form-horizontal" method="POST">
            <div class="form-group col-sm-12">
                <div class="form-group col-sm-12">
                    <label class="col-sm-2 control-label">手机号码</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="phone" placeholder="手机号码">
                    </div>
                </div>
                <br>
                <br>
                <div class="text-center">
                    <button type="submit" class="btn btn-info">立即添加</button>
                </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />