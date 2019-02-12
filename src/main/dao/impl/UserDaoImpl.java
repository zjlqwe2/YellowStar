package dao.impl;

import dao.UserDao;
import entity.User;
import util.DBHelp;
import util.impl.UserMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 用户表Dao层
 */
public class UserDaoImpl implements UserDao {
    /**
     * 通过用户名获取用户
     * @param loginname
     * @return 用户
     */
    @Override
    public User getUser(String loginname) throws SQLException {
        String sql = "SELECT * FROM yw_user WHERE loginname=?";
        return getUser(sql, loginname);
    }

    /**
     * 通过id获取用户
     * @param id
     * @return 用户
     */
    @Override
    public User getUser(int id) throws SQLException {
        String sql = "SELECT * FROM yw_user WHERE id=?";
        return getUser(sql, id);
    }

    /**
     * 获取用户的具体处理
     * @param sql
     * @param object
     * @return
     * @throws SQLException
     */
    private User getUser(String sql,Object object) throws SQLException  {
        List<Object> list = DBHelp.executeQuery(sql, new UserMapperImpl(), object);
        if (list==null || list.size()==0) {
            return null;
        }
        return (User)list.get(0);
    }

    /**
     * 创建用户
     * @param user
     * @return 创建结果
     */
    @Override
    public boolean saveUser(User user)  throws SQLException{
        String sql = "INSERT INTO yw_user (loginname, password, username, user_type, phone) VALUES (?,?,?,?,?)";
        int i = DBHelp.executeUpdate(sql, user.getLoginName(), user.getPassWord(),user.getUserName(),  user.getUserType(), user.getPhone());
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取所有用户
     * @return 用户集
     */
    @Override
    public List<User> listAll() throws SQLException {
        String sql = "SELECT * FROM yw_user";
        List<Object> list = DBHelp.executeQuery(sql, new UserMapperImpl());
        if (list==null || list.size()==0) {
            return null;
        }
        List<User> users = new ArrayList<User>();
        for (Object item:list) {
            users.add((User)item);
        }
        return users;
    }

}
