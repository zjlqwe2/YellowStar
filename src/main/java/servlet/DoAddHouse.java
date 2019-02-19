package servlet;

import entity.House;
import exception.HouseException;
import manage.HouseManage;
import util.ObjectFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/27
 * @description: 处理添加房产信息
 */
@WebServlet("/doaddhouser")
public class DoAddHouse extends HttpServlet {
    private HouseManage houseManage = (HouseManage) ObjectFactory.getObject("HouseManage");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userType = 0;
        userType = (int)(req.getSession().getAttribute("user_type"));
        if (userType == 0 || userType != 1) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("info", "仅管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        } else {
            String formUsername,formHuose_type,formGmt_buy,formBuilding,formUnit,formHouse_num;
            int formArea;
            // 业主姓名
            formUsername = (String)req.getSession().getAttribute("username");
            // 匹配用户姓名的正则表达式
            String pattern = " /^[\\u4E00-\\u9FA5A-Za-z]+$/";
            boolean isMatch = Pattern.matches(pattern, formUsername);
            if (!isMatch) {
                req.setAttribute("title", "信息错误");
                req.setAttribute("info", "业主姓名格式错误，只能输入中文和英文");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 房产类型
            formHuose_type = (String)req.getSession().getAttribute("house_type");
            if ("".equals(formHuose_type)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "房产类型为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 住房面积
            formArea = (int)req.getSession().getAttribute("area");
            if (formArea <= 0) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "住房面积填写错误");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 购房时间
            formGmt_buy = (String)req.getSession().getAttribute("gmt_buy");
            if ("".equals(formGmt_buy)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "购房时间为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 楼号
            formBuilding = (String)req.getSession().getAttribute("building");
            if ("".equals(formBuilding)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "楼号为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 小区单元
            formUnit = (String)req.getSession().getAttribute("unit");
            if ("".equals(formUnit)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "小区单元为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 门牌号
            formHouse_num = (String)req.getSession().getAttribute("house_num");
            if ("".equals(formHouse_num)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "门牌号为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            House newHouse = new House();
            newHouse.setUsername(formUsername);
            newHouse.setHouse_type(formHuose_type);
            newHouse.setArea(formArea);
            newHouse.setGmt_buy(formGmt_buy);
            newHouse.setBuilding(formBuilding);
            newHouse.setUnit(formUnit);
            newHouse.setHouse_num(formHouse_num);
            try {
                boolean flag = houseManage.saveHouse(newHouse);
                if (flag) {
                    req.getRequestDispatcher("/housemanage.jsp").forward(req, resp);
                    return;
                }
            } catch (HouseException e) {
                req.setAttribute("title", "房产信息异常");
                req.setAttribute("info", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
        }
    }
}
