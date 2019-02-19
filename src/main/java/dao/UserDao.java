package dao;

import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description: 根据用户名获取用户对象
 * @path: web-entity.userDao-UserDao
 * @date: 2019-01-11 21:21
 */
public interface UserDao
{
    /**
     * 通过用户名获取用户
     * @param username
     * @return 用户
     */
    User getUser(String username) throws SQLException;

    /**
     * 通过id获取用户
     * @param id
     * @return 用户
     */
    User getUser(int id) throws SQLException;

    /**
     * 创建用户
     * @param user
     * @return 创建结果
     */
    boolean saveUser(User user) throws SQLException;

    /**
     * 获取所有用户
     * @return 用户集
     */
    List<User> listAll() throws SQLException;
}
