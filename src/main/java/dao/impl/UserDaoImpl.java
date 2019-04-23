package dao.impl;

import dao.UserDao;
import entity.User;
import util.DBHelp;
import util.impl.UserMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 用户表Dao层
 */
public class UserDaoImpl implements UserDao {

    /**
     * 通过用户名获取用户
     */
    @Override
    public User getUser(String loginname) throws SQLException {
        String sql = "SELECT * FROM user WHERE loginname=?";
        return getUser(sql, loginname);
    }

    /**
     * 通过id获取用户
     */
    @Override
    public User getUser(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id=?";
        return getUser(sql, id);
    }

    /**
     * 获取用户的具体处理
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
     */
    @Override
    public boolean saveUser(User user)  throws SQLException{
        String sql = "INSERT INTO user (loginname, password, username, user_type) VALUES (?,?,?,?)";
        int i = DBHelp.executeUpdate(sql, user.getLoginName(), user.getPassWord(),user.getUserName(),  user.getUserType());
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取所有用户
     */
    @Override
    public List<User> listAll() throws SQLException {
        String sql = "SELECT * FROM user";
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

    /**
     * 删除用户
     */
    @Override
    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE uid = ?";
        int flag = DBHelp.executeUpdate(sql,id);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }
}
