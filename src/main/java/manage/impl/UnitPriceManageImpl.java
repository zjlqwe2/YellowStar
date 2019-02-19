package manage.impl;

import dao.UnitPriceDao;
import exception.CostException;
import manage.UnitPriceManage;
import util.ObjectFactory;
import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/1
 * @description:
 */
public class UnitPriceManageImpl implements UnitPriceManage {
    private UnitPriceDao unitPriceDao = (UnitPriceDao) ObjectFactory.getObject("UnitPriceDao");
    /**
     * @param costType
     * @return
     * @throws CostException
     */
    @Override
    public Double getUnitPrice(int costType) throws CostException {
        try {
            return unitPriceDao.getUnitPrice(costType);
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        }
    }

    /**
     * @param costType
     * @param unitPrice
     * @return
     * @throws CostException
     */
    @Override
    public boolean saveUnitPrice(int costType, double unitPrice) throws CostException {
        try {
            return unitPriceDao.saveUnitPrice(costType, unitPrice);
        } catch (SQLException e) {
            throw new CostException(e.getMessage());
        }
    }
}
