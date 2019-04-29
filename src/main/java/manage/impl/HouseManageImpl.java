package manage.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.House;
import exception.HouseException;
import manage.HouseManage;

import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-HouseManageImpl
 * @date: 2019-04-29 23:09
 */
public class HouseManageImpl implements HouseManage {



    /**
     * 添加房产信息
     *
     * @param house
     * @return
     * @throws HouseException
     */
    @Override
    public boolean saveHouse(House house) throws HouseException {
        return false;
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
        return null;
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
        return null;
    }
}
