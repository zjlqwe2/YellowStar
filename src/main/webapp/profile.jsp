<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String loginname = (String)session.getAttribute("loginname");
    int usertype = 0;
    usertype = (int)session.getAttribute("usertype");
    if(usertype==0 || usertype>2) {
        request.setAttribute("title","权限不足");
        request.setAttribute("detail","请检查操作是否正确");
        request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
    }
%>
<jsp:include page="comm/header.jsp" />
<jsp:include page="comm/nav.jsp" />

<h1>欢迎用户：<%=loginname%></h1>
<p>这是账户登陆后的个人主页，不同用户对应不同的信息</p>

<jsp:include page="comm/footer.jsp" />