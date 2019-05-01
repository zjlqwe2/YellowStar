package manage.impl;

import dao.CostDao;
import dao.HouseDao;
import dao.impl.CostDaoImpl;
import dao.impl.HouseDaoImpl;
import entity.Cost;
import entity.House;
import entity.Log;
import exception.CostException;
import exception.LogException;
import manage.CostManage;
import manage.LogManage;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-CostManageImpl
 * @date: 2019-04-30 01:18
 */
public class CostManageImpl implements CostManage {

    private CostDao costDao = new CostDaoImpl();
    private HouseDao houseDao = new HouseDaoImpl();
    private LogManage logManage = new LogManageImpl();

    /**
     * 添加费用
     *
     * @param cost
     * @return
     * @throws CostException
     */
    @Override
    public boolean saveCost(Cost cost, String operator) throws CostException {
        int hid = cost.getHid();
        int cost_type = cost.getCostType();
        double price = cost.getPrice();
        if (hid<1 || cost_type<1 || price<0) {
            return false;
        }
        Log log = new Log();
        log.setOperator(operator);
        try {
            House house = houseDao.getHouse(cost.getHid());
            log.setOperation("添加业主["+house.getUserName()+"]费用信息");
            boolean flag = costDao.saveCost(cost);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        } catch (LogException e) {
            throw new CostException(e.getMessage());
        }
    }

    /**
     * 列出某类型费用
     *
     * @param costType
     * @return
     * @throws CostException
     */
    @Override
    public Map<Cost, House> listAllCost(int costType) throws CostException {
        if (costType < 1) {
            return null;
        }
        Map<Cost, House> map = new HashMap<Cost, House>();
        List<Cost> list;
        try {
            list = costDao.listAllCost(costType);
            if (list == null) {
                return null;
            }
            for (Cost c:list) {
                int hid = c.getHid();
                House house = houseDao.getHouse(hid);
                map.put(c,house);
            }
            return map;
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        }
    }

    /**
     * 修改费用
     *
     * @param cost
     * @return
     * @throws CostException
     */
    @Override
    public boolean updateCost(Cost cost, String operator) throws CostException {
        int id = cost.getId();
        double price = cost.getPrice();
        if (id<1 || price<0) {
            return false;
        }
        Log log = new Log();
        log.setOperator(operator);
        try {
            House house = houseDao.getHouse(cost.getHid());
            log.setOperation("修改业主["+house.getUserName()+"]费用信息");
            boolean flag = costDao.updateCost(cost);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        } catch (LogException e) {
            throw new CostException(e.getMessage());
        }
    }

    /**
     * 删除某条费用记录
     *
     * @param id
     * @return
     * @throws CostException
     */
    @Override
    public boolean deleteCost(int id, String operator) throws CostException {
        if (id < 1) {
            return false;
        }
        Log log = new Log();
        log.setOperator(operator);
        try {
            log.setOperation("删除业主费用");
            boolean flag = costDao.deleteCost(id);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        } catch (LogException e) {
            throw new CostException(e.getMessage());
        }
    }
}
