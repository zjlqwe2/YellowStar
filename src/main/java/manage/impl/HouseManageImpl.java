package manage.impl;

import dao.HouseDao;
import dao.impl.HouseDaoImpl;
import entity.House;
import exception.HouseException;
import manage.HouseManage;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-HouseManageImpl
 * @date: 2019-04-29 23:09
 */
public class HouseManageImpl implements HouseManage {

    private HouseDao houseDao = new HouseDaoImpl();

    /**
     * 添加房产信息
     *
     * @param house
     * @return
     * @throws HouseException
     */
    @Override
    public boolean saveHouse(House house) throws HouseException {
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
        try {
            boolean flag = houseDao.saveHouse(house);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new HouseException(e.getMessage());
        }
    }

    /**
     * 删除房产信息
     *
     * @param hid
     * @return
     * @throws HouseException
     */
    @Override
    public boolean delHouse(int hid) throws HouseException {
        if (hid < 1) {
            return false;
        }
        try {
            boolean flag = houseDao.delHouse(hid);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new HouseException(e.getMessage());
        }
    }

    /**
     * 修改房产信息
     *
     * @param house
     * @return
     * @throws HouseException
     */
    @Override
    public boolean updateHouse(House house) throws HouseException {
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
        try {
            boolean flag = houseDao.updateHouse(house);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new HouseException(e.getMessage());
        }
    }

    /**
     * 列出房产信息
     *
     * @return
     * @throws HouseException
     */
    @Override
    public List<House> listHouse() throws HouseException {
        try {
            List<House> lists = houseDao.listAll();
            return lists;
        } catch (SQLException e) {
            throw new HouseException(e.getMessage());
        }
    }

    /**
     * 根据hid获取房产信息
     *
     * @param hid
     * @return
     * @throws HouseException
     */
    @Override
    public House getHouse(int hid) throws HouseException {
        if (hid < 1) {
            return null;
        }
        try {
            House house = houseDao.getHouse(hid);
            return house;
        } catch (SQLException e) {
            throw new HouseException(e.getMessage());
        }
    }
}
