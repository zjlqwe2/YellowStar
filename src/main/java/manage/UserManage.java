package manage;

import entity.User;
import exception.UserException;

import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 用户管理层
 */
public interface UserManage {
    /**
     * 用户登录验证
     * @param loginname
     * @return 返回用户类别
     * @throws UserException
     */
    User login(String loginname, String password) throws UserException;

    /**
     * 列出所有用户
     * @return
     * @throws UserException
     */
    List<User> listAllUser () throws UserException;

    /**
     * 保存新建的用户
     * @param user
     * @return
     * @throws UserException
     */
    boolean saveUser(User user) throws UserException;
}
