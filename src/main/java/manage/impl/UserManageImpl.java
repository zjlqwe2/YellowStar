package manage.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import exception.UserException;
import manage.UserManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;
import java.util.List;

public class UserManageImpl implements UserManage {
    private UserDao userDao = new UserDaoImpl();
    private static final Logger logger = LoggerFactory.getLogger(UserManageImpl.class);

    /**
     * 验证登录用户
     * @param loginname 账号
     * @param password 密码
     * @return 验证结果
     * @throws UserException
     */
    @Override
    public User login(String loginname, String password) throws UserException {
        if (loginname==null || password==null) {
            return null;
        }
        try {
           User user = userDao.getUser(loginname);
           if (user == null) {
               // // 情况：用户不存在
               return null;
           }
           if (user.getPassWord().equals(password)) {
               // 情况：密码正确
               return user;
           } else {
               // 情况：密码错误
               return null;
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
