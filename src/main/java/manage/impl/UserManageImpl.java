package manage.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.Log;
import entity.User;
import exception.LogException;
import exception.UserException;
import manage.LogManage;
import manage.UserManage;
import java.sql.SQLException;
import java.util.List;

/**
 * @description: UserMange层
 */
public class UserManageImpl implements UserManage {

    private UserDao userDao = new UserDaoImpl();
    private LogManage logManage = new LogManageImpl();

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
    public boolean saveUser(String loginname, String password, int usertype, String operator) throws UserException {
        if ("".equals(loginname) || "".equals(password) || usertype<1) {
            return false;
        }
        User user = new User();
        user.setLoginName(loginname);
        user.setPassWord(password);
        user.setUserType(usertype);

        Log log = new Log();
        log.setOperation("创建用户["+loginname+"]");
        log.setOperator(operator);
        try {
            boolean flag = userDao.saveUser(user);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        } catch (LogException e) {
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
    public boolean deleteUser(int uid, String operator) throws UserException {
        if (uid < 1) {
            return false;
        }
        User user = getUser(uid);
        String loginname = user.getLoginName();
        Log log = new Log();
        log.setOperation("删除用户["+loginname+"]");
        log.setOperator(operator);
        try {
            boolean flag = userDao.deleteUser(uid);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }catch (LogException e) {
            throw new UserException(e.getMessage());
        }
    }

    /**
     * 修改用户密码
     *
     * @param uid
     * @param password
     * @param operator
     * @return
     * @throws UserException
     */
    @Override
    public boolean changePassword(int uid, String password, String operator) throws UserException {
        if (uid<1 || "".equals(password)) {
            return false;
        }
        User user = getUser(uid);
        String loginname = user.getLoginName();
        Log log = new Log();
        log.setOperation("用户["+loginname+"]修改了密码");
        log.setOperator(operator);
        try {
            boolean flag = userDao.changePassword(uid, password);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }catch (LogException e) {
            throw new UserException(e.getMessage());
        }
    }
}
