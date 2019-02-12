package servlet;

import entity.User;
import exception.UserException;
import manage.UserManage;
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
 * @description: 处理创建用户请求
 */
@WebServlet("/docreateuser")
public class DoCreateUser extends HttpServlet {
    private UserManage userManage = (UserManage) ObjectFactory.getObject("UserManage");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userType = 0;
        userType = (int)(req.getSession().getAttribute("user_type"));
        if (userType == 0) {
            req.setAttribute("title", "权限不足");
            req.setAttribute("info", "仅管理员可操作");
            req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
            return;
        } else {
            String formLoginname, formUsername, formPassword, formPhone;
            int formUserType;
            formLoginname = (String)req.getSession().getAttribute("loginname");
            if (formLoginname == null || "".equals(formLoginname)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "账号为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 匹配账号的正则表达式
            String pattern = "^[a-zA-Z]\\w{4,17}$";
            boolean isMatch = Pattern.matches(pattern, formLoginname);
            if (!isMatch) {
                req.setAttribute("title", "信息错误");
                req.setAttribute("info", "账号格式错误，检查是否为大小字母加下划钱，并且以字母开头，长度：4-17");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            formUsername = (String)req.getSession().getAttribute("username");
            if (formUsername == null || "".equals(formUsername)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "用户姓名为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 匹配用户姓名的正则表达式
            pattern = " /^[\\u4E00-\\u9FA5A-Za-z]+$/";
            isMatch = Pattern.matches(pattern, formUsername);
            if (!isMatch) {
                req.setAttribute("title", "信息错误");
                req.setAttribute("info", "用户姓名格式错误，只能输入中文和英文");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            formPassword = (String)req.getSession().getAttribute("password");
            if (formPassword == null || "".equals(formPassword)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "密码为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            formPhone = (String)req.getSession().getAttribute("phone");
            if (formPhone == null || "".equals(formPhone)) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "手机号码为空");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            // 匹配手机号码的正则表达式
            pattern = "/^1(?:3\\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\\d|9\\d)\\d{8}$/";
            isMatch = Pattern.matches(pattern, formPhone);
            if (!isMatch) {
                req.setAttribute("title", "信息错误");
                req.setAttribute("info", "手机号码格式错误");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
            formUserType = (int)req.getSession().getAttribute("user_type");
            if (formUserType <= 0 || formUserType > 5) {
                req.setAttribute("title", "信息不全");
                req.setAttribute("info", "用户类别错误");
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }

            User newUser = new User();
            newUser.setLoginName(formLoginname);
            newUser.setPassWord(formPassword);
            newUser.setUserName(formUsername);
            newUser.setPhone(formPhone);
            newUser.setUserType(formUserType);
            try {
                boolean flag = userManage.saveUser(newUser);
                if (flag) {
                    req.getRequestDispatcher("/usermanage.jsp").forward(req, resp);
                    return;
                }
            } catch (UserException e) {
                req.setAttribute("title", "异常");
                req.setAttribute("info", e.getMessage());
                req.getRequestDispatcher("/comm/error.jsp").forward(req, resp);
                return;
            }
        }
    }
}
