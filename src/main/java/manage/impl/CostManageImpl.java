package manage.impl;

import dao.CostDao;
import entity.Cost;
import exception.CostException;
import manage.CostManage;
import util.ObjectFactory;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/1
 * @description: 费用管理实现类
 */
public class CostManageImpl implements CostManage {
    private CostDao costDao = (CostDao) ObjectFactory.getObject("CostDao");

    /**
     * 添加价格
     *
     * @param cost
     * @return
     * @throws CostException
     */
    @Override
    public boolean saveCost(Cost cost) throws CostException {
        try {
            return costDao.saveCost(cost.getHid(), cost.getCostType(), cost.getAmount());
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        }
    }

    /**
     * 列出某户某型价格
     *
     * @param hid
     * @param costType
     * @return
     * @throws CostException
     */
    @Override
    public List listTypeCost(int hid, int costType) throws CostException {
        try {
            return costDao.listTypeCost(hid, costType);
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        }
    }

    /**
     * 列出某型所有户
     *
     * @param costType
     * @return
     * @throws CostException
     */
    @Override
    public List listAllCost(int costType) throws CostException {
        try {
            return costDao.listAllCost(costType);
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        }
    }
}
