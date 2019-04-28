package util.impl;

import entity.User;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: 用户对象映射
 */
public class UserMapperImpl implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUid(rs.getInt("uid"));
        user.setLoginName(rs.getString("loginname"));
        user.setPassWord(rs.getString("password"));
        user.setUserType(rs.getInt("user_type"));
        return user;
    }
}
