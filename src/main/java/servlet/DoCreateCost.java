package servlet;

import entity.Cost;
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
 * @description: 处理添加费用
 */
@WebServlet("/docreatecost")
public class DoCreateCost extends HttpServlet {
    private CostManage costManage = new CostManageImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        String operator = (String) (req.getSession().getAttribute("loginname"));
        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }
        String cost_type_Str,hid_Str,price_Str;
        cost_type_Str = req.getParameter("cost_type");
        hid_Str = req.getParameter("hid");
        price_Str = req.getParameter("price");
        if ("".equals(cost_type_Str) || "".equals(hid_Str) || "".equals(price_Str)) {
            req.setAttribute("title", "参数不完整");
            req.setAttribute("detail", "cost_type、operation_hid、price都有才行喔");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }

        int cost_type = Integer.parseInt(cost_type_Str);
        int hid = Integer.parseInt(hid_Str);
        int price = Integer.parseInt(price_Str);
        if (cost_type<1 || hid <1 || price<0) {
            req.setAttribute("title", "参数不完整");
            req.setAttribute("detail", "price不能为空");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        }
        Cost cost = new Cost();
        cost.setHid(hid);
        cost.setCostType(cost_type);
        cost.setPrice(price);
        try {
            boolean flag = costManage.saveCost(cost,operator);
            if (flag) {
                req.getRequestDispatcher("cost_list.jsp?cost_type="+cost_type).forward(req, resp);
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
