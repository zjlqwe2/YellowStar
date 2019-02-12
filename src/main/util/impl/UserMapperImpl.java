package util.impl;

import entity.User;
import util.RowMapperObject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 用户对象映射
 */
public class UserMapperImpl implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUid(rs.getInt("uid"));
        user.setLoginName(rs.getString("loginname"));
        user.setUserName(rs.getString("username"));
        user.setPassWord(rs.getString("password"));
        user.setUserType(rs.getInt("user_type"));
        user.setPhone(rs.getString("phone"));
        user.setValid(rs.getInt("is_valid"));
        user.setGmtCreate(rs.getString("gmt_create"));
        user.setGmtModified(rs.getString("gmt_modified"));
        return user;
    }
}
