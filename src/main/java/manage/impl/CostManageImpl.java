package manage.impl;

import dao.CostDao;
import dao.impl.CostDaoImpl;
import entity.Cost;
import entity.House;
import exception.CostException;
import manage.CostManage;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-CostManageImpl
 * @date: 2019-04-30 01:18
 */
public class CostManageImpl implements CostManage {

    private CostDao costDao = new CostDaoImpl();

    /**
     * 添加费用
     *
     * @param cost
     * @return
     * @throws CostException
     */
    @Override
    public boolean saveCost(Cost cost) throws CostException {
        int hid = cost.getHid();
        int cost_type = cost.getCostType();
        double price = cost.getPrice();
        if (hid<1 || cost_type<1 || price<0) {
            return false;
        }
        try {
            boolean flag = costDao.saveCost(cost);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
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
        return null;
    }

    /**
     * 修改费用
     *
     * @param cost
     * @return
     * @throws CostException
     */
    @Override
    public boolean updateCost(Cost cost) throws CostException {
        int id = cost.getId();
        double price = cost.getPrice();
        if (id<1 || price<0) {
            return false;
        }
        try {
            boolean flag = costDao.updateCost(cost);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
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
    public boolean deleteCost(int id) throws CostException {
        if (id < 1) {
            return false;
        }
        try {
            boolean flag = costDao.deleteCost(id);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        }
    }
}
