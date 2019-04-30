package servlet;

import exception.ExpressException;
import manage.ExpressManage;
import manage.impl.ExpressManageImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-servlet-DoTakeExpress
 * @date: 2019-04-30 16:11
 */
@WebServlet("/express_take")
public class DoTakeExpress extends HttpServlet {
    private ExpressManage expressManage = new ExpressManageImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }
        int did = 0;
        did = Integer.parseInt(req.getParameter("did"));
        if (did <= 0) {
            req.setAttribute("title", "参数异常");
            req.setAttribute("detail", "did不能为空");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }
        try {
            boolean flag = expressManage.takeExpress(did);
            if (flag) {
                req.getRequestDispatcher("/express_list.jsp").forward(req, resp);
                return;
            } else {
                req.setAttribute("title", "领取快递异常");
                req.setAttribute("detail", "领取失败");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
        } catch (ExpressException e ) {
            req.setAttribute("title", "领取快递异常");
            req.setAttribute("detail", e.getMessage());
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }
    }
}
