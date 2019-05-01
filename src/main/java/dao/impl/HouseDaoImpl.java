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
     *
     * @param house
     */
    @Override
    public boolean saveHouse(House house) throws SQLException {
        String sql = "INSERT INTO house (user_name, identity, phone, house_type, area, gmt_buy, building, unit, house_num, location,brand, licenseplatenumber) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        int i = DBHelp.executeUpdate(sql,
                house.getUserName(),
                house.getIdentity(),
                house.getPhone(),
                house.getHouseType(),
                house.getArea(),
                house.getGmtBuy(),
                house.getBuilding(),
                house.getUnit(),
                house.getHouseNum(),
                house.getLocation(),
                house.getBrand(),
                house.getLicenseplatenumber()
                );
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获得指定房产号的房产信息
     *
     * @param hid
     */
    @Override
    public House getHouse(int hid) throws SQLException {
        if (hid < 1) {
            return null;
        }
        String sql = "SELECT * FROM house WHERE hid = ?";
        List<Object> list = DBHelp.executeQuery(sql, new HouseMapperImpl(), hid);
        if (list==null || list.size()==0) {
            return null;
        }
        return (House) list.get(0);
    }

    /**
     * 删除指定房产信息
     *
     * @param hid
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
     */
    @Override
    public boolean updateHouse(House house) throws SQLException {
        int hid = house.getHid();
        String user_name = house.getUserName();
        String identity = house.getIdentity();
        String phone = house.getPhone();
        String house_type = house.getHouseType();
        int area = house.getArea();
        String gmt_buy = house.getGmtBuy();
        String building = house.getBuilding();
        String unit = house.getUnit();
        String house_num = house.getHouseNum();
        String location = house.getLocation();
        String brand = house.getBrand();
        String licenseplatenumber = house.getLicenseplatenumber();
        if (hid<1 ||
                "".equals(user_name) ||
                "".equals(identity) ||
                "".equals(phone) ||
                "".equals(house_type) ||
                area<0 ||
                "".equals(gmt_buy) ||
                "".equals(building) ||
                "".equals(unit) ||
                "".equals(house_num)
        ) {
            return false;
        }
        String sql = "UPDATE house SET user_name=?,identity=?,phone=?,house_type=?,area=?,gmt_buy=?,building=?,unit=?,house_num=?,location=?,brand=?,licenseplatenumber=?  WHERE hid=?";
        int flag = DBHelp.executeUpdate(sql,user_name,identity,phone,house_type,area,gmt_buy,building,unit,house_num,location,brand,licenseplatenumber,hid);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取所有房屋信息
     */
    @Override
    public List<House> listAll() throws SQLException {
        String sql = "SELECT * FROM house";
        List<Object> list = DBHelp.executeQuery(sql, new HouseMapperImpl());
        if (list==null || list.size()==0) {
            return null;
        }
        List<House> houses = new ArrayList<House>();
        for (Object item:list) {
            houses.add((House) item);
        }
        return houses;
    }
}
