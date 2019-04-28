package servlet;

import entity.Device;
import exception.DeviceException;
import manage.DeviceManage;
import manage.impl.DeviceManageTestImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 处理添加设备信息
 */
@WebServlet("/docreatedevice")
public class DoCreateDevice extends HttpServlet {
    private DeviceManage deviceManage = new DeviceManageTestImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usertype = (int)req.getSession().getAttribute("usertype");
        String device_name = req.getParameter("device_name");
        String device_type = req.getParameter("device_type");
        int is_service = Integer.parseInt(req.getParameter("is_service"));
        String processing_opinion = req.getParameter("processing_opinion");
        int uid = (int)req.getSession().getAttribute("userid");

        Device device = new Device();
        device.setDevice_name(device_name);
        device.setDevice_type(device_type);
        device.setIs_service(is_service);
        device.setProcessing_opinion(processing_opinion);
        device.setUid(uid);

        if (usertype != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("detail", "仅物业管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
        } else {
            try {
                boolean flag = deviceManage.saveDevice(device);
                if (flag) {
                    req.getRequestDispatcher("house_list.jsp").forward(req, resp);
                } else {
                    req.setAttribute("title", "添加设备信息失败");
                    req.setAttribute("detail", "暂无");
                    req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                }
            } catch (DeviceException e) {
                req.setAttribute("title", "添加设备信息失败");
                req.setAttribute("detail", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            }
        }
    }
}
