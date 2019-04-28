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
     * @param loginname
     * @param password
     * @return
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
     * 创建新用户
     * @param loginname
     * @param password
     * @return
     * @throws UserException
     */
    boolean saveUser(String loginname, String password) throws UserException;

    /**
     * 删除某用户
     * @param uid
     * @return
     * @throws UserException
     */
    boolean deleteUser(int uid) throws UserException;
}
