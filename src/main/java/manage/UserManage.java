package manage;

import entity.User;
import exception.UserException;
import java.util.List;

/**
 * @description: 用户管理层
 */
public interface UserManage {
    /**
     * 用户登录验证
     */
    User login(String loginname, String password) throws UserException;

    /**
     * 列出所有用户
     */
    List<User> listAllUser () throws UserException;

    /**
     * 保存新建的用户
     */
    boolean saveUser(User user) throws UserException;

    /**
     * 删除某用户
     */
    boolean deleteUser(int uid) throws UserException;
}
