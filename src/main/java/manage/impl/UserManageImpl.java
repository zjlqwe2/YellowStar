package manage.impl;

import dao.UserDao;
import entity.User;
import exception.UserException;
import manage.UserManage;
import util.ObjectFactory;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 账户相关处理
 */
public class UserManageImpl implements UserManage {
    private UserDao userdao = (UserDao) ObjectFactory.getObject("UserDao");
    private static final Logger logger = LoggerFactory.getLogger(UserManageImpl.class);

    /**
     * 用户登录验证
     *
     * @param username
     * @param password
     * @return 返回用户
     * @throws UserException
     */
    @Override
    public User login(String username, String password) throws UserException {
        try {
            User user = userdao.getUser(username);
            if (user == null) {
                throw new UserException("用户不存在");
            }
            if (!(user.getPassWord().equals(password))) {
                throw new UserException("密码错误");
            }
            return user;
        } catch (SQLException e) {
            logger.debug(e.getMessage());
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
            List<User> list = userdao.listAll();
            if (list == null || list.size() == 0) {
                throw new UserException("用户为空");
            }
            return list;
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new UserException(e.getMessage());
        }
    }


    /**
     * 保存新建的用户
     *
     * @param user
     * @return
     * @throws UserException
     */
    @Override
    public boolean saveUser(User user) throws UserException {
        try {
            boolean flag = userdao.saveUser(user);
            return flag;
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new UserException(e.getMessage());
        }
    }
}
