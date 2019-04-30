package servlet;

import exception.CostException;
import manage.CostManage;
import manage.impl.CostManageImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-servlet-DoDeleteCost
 * @date: 2019-04-30 15:09
 */
@WebServlet("/dodeletecost")
public class DoDeleteCost extends HttpServlet {
    private CostManage costManage = new CostManageImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        int id = 0;
        id = Integer.parseInt(req.getParameter("id")) ;
        int costtype = Integer.parseInt(req.getParameter("cost_type")) ;
        if (id < 1){
            req.setAttribute("title", "参数异常");
            req.setAttribute("detail", "id参数不能小于1");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        }

        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                boolean flag = costManage.deleteCost(id);
                if (flag) {
                    req.getRequestDispatcher("cost_list.jsp?cost_type="+costtype).forward(req, resp);
                } else {
                    req.setAttribute("title", "删除费用信息失败");
                    req.setAttribute("detail", "暂无");
                    req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                }
            } catch (CostException e) {
                req.setAttribute("title", "删除费用信息失败");
                req.setAttribute("detail", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }
}
