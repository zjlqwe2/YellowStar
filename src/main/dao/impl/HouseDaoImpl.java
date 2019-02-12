package dao.impl;

import dao.HouseDao;
import entity.House;
import util.DBHelp;
import util.impl.HouseMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/27
 * @description: 房产信息Dao层
 */
public class HouseDaoImpl implements HouseDao {
    /**
     * 添加房产信息
     *
     * @param house 房产实体
     * @return 创建结果
     */
    @Override
    public boolean saveHouse(House house) throws SQLException {
        String sql = "INSERT INTO yw_house (username, house_type, area, gmy_buy, building, unit, house_num) VALUES (?,?,?,?,?,?,?) ";
        int flag = DBHelp.executeUpdate(sql,
                house.getUsername(),
                house.getHouse_type(),
                house.getArea(),
                house.getGmt_buy(),
                house.getBuilding(),
                house.getUnit(),
                house.getHouse_num());
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 获得指定房产号的房产信息
     *
     * @param hid
     * @return 房产实体
     */
    @Override
    public House getHouse(int hid) throws SQLException {
        String sql = "SELECT * FROM yw_house WHERE hid=?";
        List<Object> list = DBHelp.executeQuery(sql, new HouseMapperImpl(), hid);
        if (list == null || list.size() == 0) {
            return null;
        }
        return (House)(list.get(0));
    }

    /**
     * 删除指定房产信息
     *
     * @param hid
     * @return
     * @throws SQLException
     */
    @Override
    public boolean delHouse(int hid) throws SQLException {
        String sql = "DELETE FROM yw_house WHERE hid=?";
        int flag = DBHelp.executeUpdate(sql, hid);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 更新房产信息
     *
     * @param house
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateHouse(House house) throws SQLException {
        String sql = "UPDATE yw_house SET username=?, house_type=?, area=?, gmy_buy=?, building=?, unit=?, house_num=?,gmt_modified=? WHERE hid=?";
        int flag = DBHelp.executeUpdate(sql,
                house.getUsername(),
                house.getHouse_type(),
                house.getArea(),
                house.getGmt_buy(),
                house.getBuilding(),
                house.getUnit(),
                house.getHouse_num(),
                house.getGmt_modified(),
                house.getHid());
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取所有房屋信息
     *
     * @return 房屋对象集合
     */
    @Override
    public List<House> listAll() throws SQLException {
        String sql = "SELECT * FROM yw_house";
        List<Object> list = DBHelp.executeQuery(sql, new HouseMapperImpl());
        if (list == null || list.size() == 0) {
            return null;
        }
        List<House> houses = new ArrayList<House>();
        for (Object item:list) {
            houses.add((House)item);
        }
        return houses;
    }

}
