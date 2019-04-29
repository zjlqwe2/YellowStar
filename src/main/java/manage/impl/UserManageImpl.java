package manage.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import exception.UserException;
import manage.UserManage;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-UserManageImpl
 * @date: 2019-04-29 19:36
 */
public class UserManageImpl implements UserManage {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 用户登录验证
     *
     * @param loginname
     * @param password
     * @return
     * @throws UserException
     */
    @Override
    public User login(String loginname, String password) throws UserException {
        if ("".equals(loginname) || "".equals(password)) {
            return null;
        }
        try {
            User user = userDao.getUser(loginname);
            if (user == null) {
                return null;
            }
            String correct_password = user.getPassWord();
            if (correct_password.equals(password)) {
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }
    }

    /**
     * 获取某用户
     *
     * @param uid
     * @return
     * @throws UserException
     */
    @Override
    public User getUser(int uid) throws UserException {
        if (uid < 1) {
            return null;
        }
        try {
            User user = userDao.getUser(uid);
            if (user == null) {
                return null;
            }
            return user;
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }
    }

    /**
     * 列出所有用户
     *
     * @return
     * @throws UserException
     */
    @Override
    public List<User> listAllUser() throws UserException {
        try {
            List<User> users = userDao.listAll();
            return users;
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }
    }

    /**
     * 创建新用户
     *
     * @param loginname
     * @param password
     * @param usertype
     * @return
     * @throws UserException
     */
    @Override
    public boolean saveUser(String loginname, String password, int usertype) throws UserException {
        if ("".equals(loginname) || "".equals(password) || usertype<1) {
            return false;
        }
        User user = new User();
        user.setLoginName(loginname);
        user.setPassWord(password);
        user.setUserType(usertype);
        try {
            boolean flag = userDao.saveUser(user);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }
    }

    /**
     * 删除某用户
     *
     * @param uid
     * @return
     * @throws UserException
     */
    @Override
    public boolean deleteUser(int uid) throws UserException {
        if (uid < 1) {
            return false;
        }
        try {
            boolean flag = userDao.deleteUser(uid);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }
    }
}
