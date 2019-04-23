package manage.impl;

import dao.UserDao;
import entity.User;
import exception.UserException;
import manage.UserManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ObjectFactory;
import java.sql.SQLException;
import java.util.List;

public class UserManageImpl implements UserManage {
    private UserDao userDao = (UserDao)ObjectFactory.getObject("UserDao");
    private static final Logger logger = LoggerFactory.getLogger(UserManageImpl.class);

    /**
     * 用户登录验证
     * @param loginname
     * @param password
     */
    @Override
    public User login(String loginname, String password) throws UserException {
        if (loginname==null || password==null) {
            return null;
        }
        try {
           User user = userDao.getUser(loginname);
           if (user == null) {
               throw new UserException("用户不存在");
           }
           if (user.getPassWord().equals(password)) {
               return user;
           } else {
               throw new UserException("密码错误");
           }
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new UserException(e.getMessage());
        }
    }

    /**
     * 列出所有用户
     */
    @Override
    public List<User> listAllUser() throws UserException {
        try {
            List<User> list = userDao.listAll();
            if (list == null) {
                throw new UserException("用户为空");
            } else {
                return list;
            }
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new UserException(e.getMessage());
        }
    }

    /**
     * 保存新建的用户
     */
    @Override
    public boolean saveUser(User user) throws UserException {
        String username = user.getUserName();
        String loginname = user.getLoginName();
        String password = user.getPassWord();
        int userType = user.getUserType();
        if (username==null || loginname==null || password==null || userType==0) {
            return false;
        }
        try {
            return userDao.saveUser(user);
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new UserException(e.getMessage());
        }
    }

    /**
     * 删除某用户
     */
    @Override
    public boolean deleteUser(int uid) throws UserException {
        if (uid <= 0) {
            return false;
        }
        try {
            return userDao.deleteUser(uid);
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new UserException(e.getMessage());
        }
    }
}
