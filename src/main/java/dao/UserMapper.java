package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper
{
    /**
     * 通过id获取用户
     */
    User getUserById(int id);

    /**
     * 创建用户
     */
    Boolean addUser(User user);

    /**
     * 删除用户
     */
    Boolean deleteUserById(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Boolean updateUser (User user);

    /**
     * 分页查询
     * @return
     */
    List<User> queryUserByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize );

    /**
     * 查询用户总数
     * @return
     */
    Integer queryUserCnt();
}
