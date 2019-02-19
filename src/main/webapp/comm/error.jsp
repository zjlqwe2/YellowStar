<%--
  Created by IntelliJ IDEA.
  User: ruanfumin
  Date: 2019-02-19
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp" />
<jsp:include page="nav.jsp" />

<div class="alert alert-danger text-center" role="alert">
    <h3>${title}</h3>
    <p>${info}</p>
</div>

<jsp:include page="footer.jsp" />