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
import manage.impl.UserManageImpl;

/**
 * @description: 处理登陆请求
 */
@WebServlet("/dologin")
public class DoLogin extends HttpServlet
{

    private UserManage userManage = new UserManageImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginname = "";
        String password = "";
        loginname = req.getParameter("loginname");
        password = req.getParameter("password");

        if("".equals(loginname) || "".equals(password) || loginname==null || password==null) {
            req.setAttribute("title", "登陆失败");
            req.setAttribute("detail", "用户名和密码信息输入不完整");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                User user = userManage.login(loginname, password);
                if (user == null) {
                    req.setAttribute("title", "登陆失败");
                    req.setAttribute("detail", "请检查你的账号和密码");
                    req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                    return;
                }
                req.getSession().setAttribute("loginname", user.getLoginName());
                req.getSession().setAttribute("usertype", user.getUserType());
                req.getSession().setAttribute("userid", user.getUid());
                req.getRequestDispatcher("profile.jsp").forward(req,resp);
            } catch (UserException e) {
                req.setAttribute("title", "登陆失败");
                req.setAttribute("detail", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }

}