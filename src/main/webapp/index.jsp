<%@ page import="manage.UserManage" %>
<%@ page import="util.ObjectFactory" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    UserManage userManage = (UserManage) ObjectFactory.getObject("UserManage");
    List<User> list = new ArrayList<>();
    list = userManage.listAllUser();
    for (User u:list) {
        System.out.println(u);
    }
%>
</body>
</html>
