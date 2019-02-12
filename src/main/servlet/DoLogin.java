package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import entity.User;
import exception.UserException;
import manage.UserManage;
import util.ObjectFactory;

/**
 * @author: 我的袜子都是洞
 * @description: 处理登陆请求
 * @path: web-servlet-DoLogin
 * @date: 2019-01-26 17:22
 */
@WebServlet("/dologin")
public class DoLogin extends HttpServlet
{
    private UserManage userManage = (UserManage) ObjectFactory.getObject("UserManage");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "";
        String password = "";
        username = req.getParameter("username");
        password = req.getParameter("password");
        if("".equals(username) || "".equals(password)) {
            req.setAttribute("title", "登陆失败");
            req.setAttribute("info", "用户名和密码信息输入不完整");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                User user = userManage.login(username, password);
                req.getSession().setAttribute("uid", user.getUid());
                req.getSession().setAttribute("username", user.getUserName());
                req.getSession().setAttribute("user_type", user.getUserType());
                req.getRequestDispatcher("profile.jsp").forward(req,resp);
            } catch (UserException e) {
                req.setAttribute("title", "登陆失败");
                req.setAttribute("info", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }

}