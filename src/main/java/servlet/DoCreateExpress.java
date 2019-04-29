package servlet;

import entity.Express;
import exception.ExpressException;
import manage.ExpressManage;
import manage.impl.ExpressManageTestImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 添加快递处理
 */
@WebServlet("/docreateexpress")
public class DoCreateExpress extends HttpServlet {
    private ExpressManage expressManage = new ExpressManageTestImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }

        String express_name = req.getParameter("express_name");
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String express_id = req.getParameter("express_id");

        if ("".equals(express_name) || "".equals(username) || "".equals(phone) || "".equals(express_id)) {
            req.setAttribute("title", "信息不全");
            req.setAttribute("detail", "信息不全");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }

        Express express = new Express();
        express.setExpress_name(express_name);
        express.setUsername(username);
        express.setPhone(phone);
        express.setExpress_id(express_id);

        try {
            boolean flag = expressManage.saveExpress(express);
            if (flag) {
                req.getRequestDispatcher("express_list.jsp").forward(req, resp);
            } else {
                req.setAttribute("title", "添加快递失败");
                req.setAttribute("detail", "暂无");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        } catch (ExpressException e) {
            req.setAttribute("title", "快递功能异常");
            req.setAttribute("detail", e.getMessage());
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }
    }
}
