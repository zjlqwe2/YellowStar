package manage.impl;

import dao.UnitPriceDao;
import exception.CostException;
import manage.UnitPriceManage;
import util.ObjectFactory;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/1
 * @description:
 */
public class UnitPriceManageImpl implements UnitPriceManage {
    private UnitPriceDao unitPriceDao = (UnitPriceDao) ObjectFactory.getObject("UnitPriceDao");
    private static final Logger logger = LoggerFactory.getLogger(UnitPriceManageImpl.class);

    /**
     * @param costType
     * @return
     * @throws CostException
     */
    @Override
    public double getUnitPrice(int costType) throws CostException {
        try {
            return unitPriceDao.getUnitPrice(costType);
        } catch (SQLException e) {
            logger.debug(e.getMessage());
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
            logger.debug(e.getMessage());
            throw new CostException(e.getMessage());
        }
    }
}
