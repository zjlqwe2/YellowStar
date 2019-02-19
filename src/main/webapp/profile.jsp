<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = (String)session.getAttribute("username");
    int userType = 0;
    userType = (int)session.getAttribute("user_type");
    if(userType==0 || userType>3) {
        request.setAttribute("title","权限不足");
        request.setAttribute("info","请检查操作是否正确");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>
<jsp:include page="comm/header.jsp" />
<jsp:include page="comm/nav.jsp" />

    <%
        switch (userType) {
            case 1:
    %>
<div class="container">
    <div class="row clearfix">
        <h1 class="text-center">个人中心<small>管理员页面</small></h1>
        <div class="col-md-3">
            <table class="table table-hover table-condensed">
                <caption  class="text-center">小区基础信息</caption>
                <tr>
                    <th>类别</th>
                    <th>数量</th>
                </tr>
                <tr>
                    <td>系统账户</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>小区房产</td>
                    <td>99</td>
                </tr>
                <tr>
                    <td>设备数量</td>
                    <td>399</td>
                </tr>
            </table>
        </div>
        <div class="col-md-6">

            <table class="table table-hover table-condensed">
                <caption class="text-center">小区收费概览</caption>
                <tr>
                    <th>费用类型</th>
                    <th>当前单价</th>
                    <th>总条目</th>
                    <th>总额</th>
                </tr>
                <tr>
                    <td>水费</td>
                    <td>3元/吨</td>
                    <td>50</td>
                    <td>1070元</td>
                </tr>
                <tr>
                    <td>电费</td>
                    <td>3元/度</td>
                    <td>90</td>
                    <td>789元</td>
                </tr>
                <tr>
                    <td>燃气费</td>
                    <td>2元/立方</td>
                    <td>20</td>
                    <td>390元</td>
                </tr>
                <tr>
                    <td>物业费</td>
                    <td>100元/年</td>
                    <td>10</td>
                    <td>3478元</td>
                </tr>
                <tr>
                    <td>停车费</td>
                    <td>40元/月</td>
                    <td>40</td>
                    <td>387元</td>
                </tr>
            </table>
        </div>
        <div class="col-md-3">
            <table class="table table-hover table-condensed">
                <caption  class="text-center">快递信息</caption>
                <tr>
                    <th>类别</th>
                    <th>数量</th>
                </tr>
                <tr>
                    <td>处理总数</td>
                    <td>300</td>
                </tr>
                <tr>
                    <td>未领快递</td>
                    <td>99</td>
                </tr>
            </table>
        </div>
    </div>
</div>
    <%
        break;
        default:
    %>
    <h1>欢迎用户：${userName}</h1>
    <p>这是账户登陆后的个人主页，不同用户对应不同的信息</p>
<%
    }
%>
<jsp:include page="comm/footer.jsp" />