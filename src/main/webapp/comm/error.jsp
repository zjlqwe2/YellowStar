<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String title = (String)request.getAttribute("title");
    String detail = (String)request.getAttribute("detail");
%>
<jsp:include page="header.jsp" />
<jsp:include page="nav.jsp" />

<div class="alert alert-danger text-center" role="alert">
    <h3><%=title%></h3>
    <p><%=detail%></p>
</div>

<jsp:include page="footer.jsp" />