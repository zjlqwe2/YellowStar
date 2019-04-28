package manage.impl;

import entity.House;
import exception.HouseException;
import manage.HouseManage;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 房产信息Manage层
 */
public class HouseManageTestImpl implements HouseManage {

    /**
     * 添加房产信息
     *
     * @param house
     * @return
     * @throws HouseException
     */
    @Override
    public boolean saveHouse(House house) throws HouseException {
        System.out.println("添加了一个房产信息");
        return true;
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
        System.out.println("删除一个房产信息");
        return false;
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
        System.out.println("更新一个房产信息");
        return false;
    }

    /**
     * 列出房产信息
     *
     * @return
     * @throws HouseException
     */
    @Override
    public List<House> listHouse() throws HouseException {
        List<House> list = new ArrayList<House>();
        for (int i=1; i<20; i++) {
            House house = new House();
            house.setHid(i);
            house.setUserName("张三");
            house.setPhone("1213123138"+i);
            house.setUnit("一单元");
            house.setArea(12);
            house.setIdentity("qwqwe");
            house.setBuilding(i+"栋");
            house.setLocation(i+"车位");
            house.setHouseType("一室一厅");
            list.add(house);
        }
        return list;
    }

}
