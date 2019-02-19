package dao;

import entity.House;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description: 房产处理类
 * @path: web-entity-HouseDao
 * @date: 2019-01-07 21:55
 */
public interface HouseDao
{
    /**
     * 添加房产信息
     * @param house 房产实体
     * @return 创建结果
     */
    boolean saveHouse(House house) throws SQLException;

    /**
     * 获得指定房产号的房产信息
     * @param hid
     * @return 房产实体
     */
    House getHouse(int hid) throws SQLException;

    /**
     * 删除指定房产信息
     * @param hid
     * @return
     * @throws SQLException
     */
    boolean delHouse (int hid) throws SQLException;

    /**
     * 更新房产信息
     * @param house
     * @return
     * @throws SQLException
     */
    boolean updateHouse (House house) throws SQLException;

    /**
     * 获取所有房屋信息
     * @return 房屋对象集合
     */
    List<House> listAll() throws SQLException;
}
