package dao;

import entity.House;
import java.sql.SQLException;
import java.util.List;

/**
 * @description: 房产处理类
 */
public interface HouseDao
{
    /**
     * 添加房产信息
     */
    boolean saveHouse(House house) throws SQLException;

    /**
     * 获得指定房产号的房产信息
     */
    House getHouse(int hid) throws SQLException;

    /**
     * 删除指定房产信息
     */
    boolean delHouse (int hid) throws SQLException;

    /**
     * 更新房产信息
     */
    boolean updateHouse (House house) throws SQLException;

    /**
     * 获取所有房屋信息
     */
    List<House> listAll() throws SQLException;
}
