package dao.impl;

import dao.HouseDao;
import entity.House;
import util.DBHelp;
import util.impl.HouseMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 房产信息Dao层
 */
public class HouseDaoImpl implements HouseDao {

    /**
     * 添加房产信息
     */
    @Override
    public boolean saveHouse(House house) throws SQLException {
        String sql = "INSERT INTO house (user_name,identity ,phone, house_type, area, gmy_buy, building, unit, house_num, has_car, location, licenseplatenumber) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
        int flag = DBHelp.executeUpdate(sql,
                house.getUserName(),
                house.getIdentity(),
                house.getPhone(),
                house.getHouseType(),
                house.getArea(),
                house.getGmtBuy(),
                house.getBuilding(),
                house.getUnit(),
                house.getHouseNum(),
                house.getHasCar(),
                house.getLocation(),
                house.getLicenseplatenumber()
                );
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 获得指定房产号的房产信息
     * @param hid
     * @return 房产实体
     */
    @Override
    public House getHouse(int hid) throws SQLException {
        String sql = "SELECT * FROM house WHERE hid=?";
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
        String sql = "DELETE FROM house WHERE hid=?";
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
        String sql = "UPDATE house SET username=?, identity=?, phone=?, house_type=?, area=?, gmy_buy=?, building=?, unit=?, house_num=?, has_car=?, location=?, licenseplatenumber=? WHERE hid=?";
        int flag = DBHelp.executeUpdate(sql,
                house.getUserName(),
                house.getIdentity(),
                house.getPhone(),
                house.getHouseType(),
                house.getArea(),
                house.getGmtBuy(),
                house.getBuilding(),
                house.getUnit(),
                house.getHouseNum(),
                house.getHasCar(),
                house.getLocation(),
                house.getLicenseplatenumber(),
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
        String sql = "SELECT * FROM house";
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
