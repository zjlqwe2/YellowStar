package manage.impl;

import dao.HouseDao;
import dao.impl.HouseDaoImpl;
import entity.House;
import entity.Log;
import exception.HouseException;
import exception.LogException;
import manage.HouseManage;
import manage.LogManage;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 */
public class HouseManageImpl implements HouseManage {

    private HouseDao houseDao = new HouseDaoImpl();
    private LogManage logManage = new LogManageImpl();

    /**
     * 添加房产信息
     *
     * @param house
     * @return
     * @throws HouseException
     */
    @Override
    public boolean saveHouse(House house, String operator) throws HouseException {
        String user_name = house.getUserName();
        String identity = house.getIdentity();
        String phone = house.getPhone();
        String house_type = house.getHouseType();
        int area = house.getArea();
        String gmt_buy = house.getGmtBuy();
        String building = house.getBuilding();
        String unit = house.getUnit();
        String brand = house.getBrand();
        String house_num = house.getHouseNum();

        Log log = new Log();
        log.setOperation("添加业主["+user_name+"]信息");
        log.setOperator(operator);

        if ("".equals(user_name) ||
                "".equals(identity) ||
                "".equals(phone) ||
                "".equals(house_type) ||
                area<0 ||
                "".equals(gmt_buy) ||
                "".equals(building) ||
                "".equals(unit) ||
                "".equals(house_num) ||
                "".equals(brand)
        ) {
            return false;
        }
        try {
            boolean flag = houseDao.saveHouse(house);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new HouseException(e.getMessage());
        } catch (LogException e) {
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
    public boolean delHouse(int hid, String operator) throws HouseException {
        if (hid < 1) {
            return false;
        }
        House house = getHouse(hid);

        Log log = new Log();
        log.setOperation("删除业主["+house.getUserName()+"]信息");
        log.setOperator(operator);

        try {
            boolean flag = houseDao.delHouse(hid);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            throw new HouseException(e.getMessage());
        } catch (LogException e) {
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
    public boolean updateHouse(House house, String operator) throws HouseException {
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

        Log log = new Log();
        log.setOperation("修改业主["+user_name+"]信息");
        log.setOperator(operator);

        try {
            boolean flag = houseDao.updateHouse(house);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new HouseException(e.getMessage());
        } catch (LogException e) {
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
