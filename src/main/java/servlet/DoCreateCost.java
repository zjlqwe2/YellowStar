package servlet;

import entity.Cost;
import exception.CostException;
import manage.CostManage;
import manage.impl.CostManageTestImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 处理添加费用
 */
@WebServlet("/docreatecost")
public class DoCreateCost extends HttpServlet {
    private CostManage costManage = new CostManageTestImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }
        int cost_type = Integer.parseInt(req.getParameter("cost_type"));
        int operation_hid = Integer.parseInt(req.getParameter("operation_hid"));
        int price = Integer.parseInt(req.getParameter("price"));
        if (cost_type<1 || operation_hid <1 || price<0) {
            req.setAttribute("title", "参数不完整");
            req.setAttribute("detail", "cost_type、operation_hid、price都有才行喔");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }
        Cost cost = new Cost();
        cost.setHid(operation_hid);
        cost.setCostType(cost_type);
        cost.setPrice(price);
        try {
            boolean flag = costManage.saveCost(cost);
            if (flag) {
                req.getRequestDispatcher("cost_list.jsp").forward(req, resp);
            } else {
                req.setAttribute("title", "添加费用失败");
                req.setAttribute("detail", "暂无");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        } catch (CostException e) {
            req.setAttribute("title", "费用异常");
            req.setAttribute("detail", e.getMessage());
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        }
    }
}
