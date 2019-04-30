<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int usertype = (int)session.getAttribute("usertype");
    if(usertype != 2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","仅物业管理员可操作");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }

    int cost_type = Integer.parseInt(request.getParameter("cost_type"));
    int hid = Integer.parseInt(request.getParameter("hid"));
%>
<jsp:include page="comm/header.jsp" flush="true"  />
<jsp:include page="comm/nav.jsp" flush="true" />
<div class="panel panel-primary">
    <div class="panel-heading text-center">添加费用</div>
    <div class="panel-body">
        <form action="docreatecost" method="POST">
            <input type="hidden" name="cost_type" value="<%=cost_type%>">
            <input type="hidden" name="hid" value="<%=hid%>">

            <div class="form-group">
                <label >价格</label>
                <input type="text" class="form-control" name="price">
            </div>
            <br>

            <div class="text-center">
                <button type="submit" class="btn btn-info">立即添加</button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="comm/footer.jsp" flush="true" />