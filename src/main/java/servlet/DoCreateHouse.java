package servlet;

import entity.House;
import exception.HouseException;
import manage.HouseManage;
import manage.impl.HouseManageImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 处理添加房产信息
 */
@WebServlet("/docreatehouse")
public class DoCreateHouse extends HttpServlet {
    private HouseManage houseManage = new HouseManageImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        String user_name = req.getParameter("user_name");
        String identity = req.getParameter("identity");
        String phone = req.getParameter("phone");
        String house_type = req.getParameter("house_type");
        int area = Integer.parseInt(req.getParameter("area"));
        String gmt_buy = req.getParameter("gmt_buy");
        String building = req.getParameter("building");
        String unit = req.getParameter("unit");
        String house_num = req.getParameter("house_num");

        if ("".equals(identity) || "".equals(phone) || "".equals(house_type) || "".equals(gmt_buy) || "".equals(building) || "".equals(unit) || "".equals(house_num)) {
            req.setAttribute("title", "信息不全");
            req.setAttribute("detail", "部分信息未填写");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        }

        String location = req.getParameter("location");
        String licenseplatenumber = req.getParameter("licenseplatenumber");

        House house = new House();
        house.setIdentity(identity);
        house.setUserName(user_name);
        house.setPhone(phone);
        house.setArea(area);
        house.setHouseType(house_type);
        house.setGmtBuy(gmt_buy);
        house.setBuilding(building);
        house.setUnit(unit);
        house.setHouseNum(house_num);
        house.setLocation(location);
        house.setLicenseplatenumber(licenseplatenumber);

        // 测试代码，没有问题删
        System.out.println(house);
        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                boolean flag = houseManage.saveHouse(house);
                if (flag) {
                    req.getRequestDispatcher("house_list.jsp").forward(req, resp);
                } else {
                    req.setAttribute("title", "添加房产信息失败");
                    req.setAttribute("detail", "暂无");
                    req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                }
            } catch (HouseException e) {
                req.setAttribute("title", "添加房产信息失败");
                req.setAttribute("detail", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }
}
