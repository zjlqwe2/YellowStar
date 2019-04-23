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
 * @description: 处理登陆请求
 */
@WebServlet("/dologin")
public class DoLogin extends HttpServlet
{
    private UserManage userManage = (UserManage) ObjectFactory.getObject("UserManage");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginname = "";
        String password = "";
        loginname = req.getParameter("loginname");
        password = req.getParameter("password");
        if("".equals(loginname) || "".equals(password) || loginname==null || password==null) {
            req.setAttribute("title", "登陆失败");
            req.setAttribute("info", "用户名和密码信息输入不完整");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                User user = userManage.login(loginname, password);
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