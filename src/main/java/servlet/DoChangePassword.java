package servlet;

import exception.UserException;
import manage.UserManage;
import manage.impl.UserManageImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-servlet-DoChangePassword
 * @date: 2019-05-07 22:26
 */
@WebServlet("/dochangepassword")
public class DoChangePassword extends HttpServlet {
    private UserManage userManage = new UserManageImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String operator = (String) (req.getSession().getAttribute("loginname"));
        Object uid_Obj = req.getSession().getAttribute("userid");
        int uid = 0;
        uid = (int)uid_Obj;

        if ("".equals(password1) || "".equals(password2)) {
            req.setAttribute("title", "修改失败");
            req.setAttribute("detail", "密码不能为空");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            if (!(password1.equals(password2))) {
                req.setAttribute("title", "修改失败");
                req.setAttribute("detail", "两次密码不一致");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
            try {
                boolean flag = userManage.changePassword(uid,password1,operator);
                if (flag) {
                    req.getRequestDispatcher("profile.jsp").forward(req, resp);
                }
            } catch (UserException e) {
                req.setAttribute("title", "创建失败");
                req.setAttribute("detail", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }
}
