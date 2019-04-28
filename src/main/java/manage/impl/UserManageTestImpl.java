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
        return true;
    }

    @Override
    public boolean deleteUser(int uid) throws UserException {
        return true;
    }
}
