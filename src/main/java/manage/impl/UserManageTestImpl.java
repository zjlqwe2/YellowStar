package manage.impl;

import entity.User;
import exception.UserException;
import manage.UserManage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description: 测试代码
 * @path: PropertyManagement-manage.impl-UserManageTestImpl
 * @date: 2019-04-28 15:27
 */
public class UserManageTestImpl implements UserManage {
    @Override
    public User login(String loginname, String password) throws UserException {
        User user = new User();
        user.setUid(1);
        user.setLoginName(loginname);
        user.setPassWord(password);
        user.setUserType(1);
        System.out.println("登陆一个用户");
        return user;
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
        User user = new User();
        user.setUid(1);
        user.setLoginName("admin");
        user.setPassWord("123");
        user.setUserType(1);
        return user;
    }

    @Override
    public List<User> listAllUser() throws UserException {
        List<User> list = new ArrayList<>();
        for (int i=1; i<=10; i++) {
            User user = new User();
            user.setUid(i);
            user.setLoginName("User"+i);
            user.setPassWord("****");
            user.setUserType(1);
            list.add(user);
        }
        return list;
    }

    @Override
    public boolean saveUser(String loginname, String password, int usertype) throws UserException {
        System.out.println("创建了某个用户");
        return true;
    }

    @Override
    public boolean deleteUser(int uid) throws UserException {
        System.out.println("删除某个用户");
        return true;
    }
}
