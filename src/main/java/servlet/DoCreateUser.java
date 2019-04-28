package servlet;

import exception.UserException;
import manage.UserManage;
import manage.impl.UserManageTestImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 处理创建用户
 */
@WebServlet("/docreateuser")
public class DoCreateUser  extends HttpServlet {
    private UserManage userManage = new UserManageTestImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginname = req.getParameter("loginname");
        String password = req.getParameter("password");
        int usertype = Integer.parseInt(req.getParameter("usertype"));

        if ("".equals(loginname) || "".equals(password) || usertype==0) {
            req.setAttribute("title", "创建失败");
            req.setAttribute("detail", "用户名和密码信息输入不完整");

            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                boolean flag = userManage.saveUser(loginname, password, usertype);
                if (flag) {
                    req.getRequestDispatcher("user_list.jsp").forward(req, resp);
                }
            } catch (UserException e) {
                req.setAttribute("title", "创建失败");
                req.setAttribute("detail", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }
}
