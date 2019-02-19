package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/1
 * @description: 添加快递处理servlet
 */
@WebServlet("/doaddexpress")
public class DoAddExpress  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userType = (int)(req.getSession().getAttribute("user_type"));
        if (userType != 1 || userType != 2) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("info", "管理员、物业可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        } else {
            String phone;
            phone = (String)req.getSession().getAttribute("username");
            // 匹配手机号码的正则表达式
            String pattern = "/^1(?:3\\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\\d|9\\d)\\d{8}$/";
            boolean isMatch = Pattern.matches(pattern, phone);
            if (!isMatch) {
                req.setAttribute("title", "信息错误");
                req.setAttribute("info", "手机号码格式错误");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            /**
             * 此处放添加手机号码处理的manage
             * 获得到一个正确的手机号码
             */
        }
    }
}
