package dao.impl;

import dao.UserDao;
import entity.User;
import util.DBHelp;
import util.impl.UserMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 用户Dao层
 */
public class UserDaoImpl implements UserDao {
    /**
     * 通过用户名获取用户
     *
     * @param loginname
     */
    @Override
    public User getUser(String loginname) throws SQLException {
        String sql = "SELECT * FROM user WHERE loginname = ?";
        return getUser(sql, loginname);
    }

    /**
     * 通过id获取用户
     *
     * @param id
     */
    @Override
    public User getUser(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE uid = ?";
        return getUser(sql, id);
    }

    private User getUser(String sql,Object object) throws SQLException  {
        List<Object> list = DBHelp.executeQuery(sql, new UserMapperImpl(), object);
        if (list==null || list.size()==0) {
            return null;
        }
        return (User)list.get(0);
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
     * 创建用户
     *
     * @param user
     */
    @Override
    public boolean saveUser(User user) throws SQLException {
        String sql = "INSERT INTO user (loginname, password, user_type) VALUES (?,?,?)";
        int i = DBHelp.executeUpdate(sql, user.getLoginName(), user.getPassWord(),user.getUserType());
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE uid=?";
        int flag = DBHelp.executeUpdate(sql, id);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 修改密码
     *
     * @param id
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public boolean changePassword(int id, String password) throws SQLException {
        if (id<1 || "".equals(password)) {
            return false;
        }
        String sql = "UPDATE user SET password=? WHERE uid=?";
        int flag = DBHelp.executeUpdate(sql, password, id);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }
}
