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
 * @description: 处理删除用户请求
 */
@WebServlet("/dodeleteuser")
public class DoDeleteUser extends HttpServlet {
    private UserManage userManage = new UserManageImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        int uid = 0;
        String operator = (String) req.getSession().getAttribute("loginname");
        uid = Integer.parseInt(req.getParameter("uid")) ;
        if (uid < 1){
            req.setAttribute("title", "参数异常");
            req.setAttribute("detail", "uid参数不能小于1");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        }
        if (usertype != 1) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅超级管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                boolean flag = userManage.deleteUser(uid, operator);
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
