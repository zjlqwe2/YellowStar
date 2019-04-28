package servlet;


import exception.HouseException;
import manage.HouseManage;
import manage.impl.HouseManageTestImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 处理删除房产信息
 */
@WebServlet("/dodeletehouse")
public class DoDeleteHouse extends HttpServlet {
    private HouseManage houseManage = new HouseManageTestImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        int hid = 0;
        hid = Integer.parseInt(req.getParameter("hid")) ;
        if (hid < 1){
            req.setAttribute("title", "参数异常");
            req.setAttribute("detail", "hid参数不能小于1");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        }

        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                boolean flag = houseManage.delHouse(hid);
                if (flag) {
                    req.getRequestDispatcher("house_list.jsp").forward(req, resp);
                } else {
                    req.setAttribute("title", "删除房产信息失败");
                    req.setAttribute("detail", "暂无");
                    req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                }
            } catch (HouseException e) {
                req.setAttribute("title", "删除房产信息失败");
                req.setAttribute("detail", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }
}
