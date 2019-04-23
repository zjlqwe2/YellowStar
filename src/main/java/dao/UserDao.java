package dao;

import entity.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao
{
    /**
     * 通过用户名获取用户
     */
    User getUser(String username) throws SQLException;


    /**
     * 通过id获取用户
     */
    User getUser(int id) throws SQLException;

    /**
     * 获取所有用户
     */
    List<User> listAll() throws SQLException;


    /**
     * 创建用户
     */
    boolean saveUser(User user) throws SQLException;

    /**
     * 删除用户
     */
    boolean deleteUser(int id) throws SQLException;
}
