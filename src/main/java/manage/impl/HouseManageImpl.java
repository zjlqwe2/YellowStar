package manage.impl;

import dao.HouseDao;
import entity.House;
import exception.HouseException;
import manage.HouseManage;
import util.ObjectFactory;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/27
 * @description:
 */
public class HouseManageImpl implements HouseManage {
    HouseDao houseDao = (HouseDao) ObjectFactory.getObject("HouseDao");
    private static final Logger logger = LoggerFactory.getLogger(HouseManageImpl.class);

    /**
     * 通过hid获得业主
     *
     * @param hid
     * @return
     * @throws HouseException
     */
    @Override
    public House getHouse(int hid) throws HouseException {
        try {
            return houseDao.getHouse(hid);
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new HouseException(e.getMessage());
        }
    }

    /**
     * 添加房产信息
     *
     * @param house
     * @return
     * @throws HouseException
     */
    @Override
    public boolean saveHouse(House house) throws HouseException {
        try {
            boolean flag = houseDao.saveHouse(house);
            return flag;
        } catch (SQLException e) {
            logger.debug(e.getMessage());
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
        try {
            boolean flag = houseDao.delHouse(hid);
            return flag;
        } catch (SQLException e) {
            logger.debug(e.getMessage());
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
        try {
            boolean flag = houseDao.updateHouse(house);
            return flag;
        } catch (SQLException e) {
            logger.debug(e.getMessage());
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
            List<House> houses = houseDao.listAll();
            return houses;
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new HouseException(e.getMessage());
        }
    }
}
