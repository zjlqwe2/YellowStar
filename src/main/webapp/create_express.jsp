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
    <div class="panel-heading text-center">添加快递</div>
    <div class="panel-body">
        <form action="docreateexpress" method="POST">
            <div class="form-group">
                <label >快递名称</label>
                <input type="text" class="form-control" name="express_name" placeholder="快递名称">
            </div>
            <br>

            <div class="form-group">
                <label >姓名</label>
                <input type="text" class="form-control" name="username" placeholder="姓名">
            </div>
            <br>

            <div class="form-group">
                <label >手机号码</label>
                <input type="text" class="form-control" name="phone" placeholder="手机号码">
            </div>
            <br>

            <div class="form-group">
                <label >快递单号</label>
                <input type="text" class="form-control" name="express_id" placeholder="快递单号">
            </div>
            <br>

            <div class="text-center">
                <button type="submit" class="btn btn-info">立即添加</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />