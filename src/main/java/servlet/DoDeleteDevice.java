package servlet;

import exception.DeviceException;
import manage.DeviceManage;
import manage.impl.DeviceManageImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 处理删除设备信息
 */
@WebServlet("/dodeletedevice")
public class DoDeleteDevice extends HttpServlet {
    private DeviceManage deviceManage = new DeviceManageImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        String operator = (String) (req.getSession().getAttribute("loginname"));
        int did = 0;
        did = Integer.parseInt(req.getParameter("did")) ;
        if (did < 1){
            req.setAttribute("title", "参数异常");
            req.setAttribute("detail", "did参数不能小于1");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        }

        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                boolean flag = deviceManage.deleteDevice(did, operator);
                if (flag) {
                    req.getRequestDispatcher("device_list.jsp").forward(req, resp);
                } else {
                    req.setAttribute("title", "删除设备信息失败");
                    req.setAttribute("detail", "暂无");
                    req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                }
            } catch (DeviceException e) {
                req.setAttribute("title", "删除设备信息失败");
                req.setAttribute("detail", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }
}
