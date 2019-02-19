package manage;

import exception.CostException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/1
 * @description:
 */
public interface UnitPriceManage {
    /**
     *
     * @param costType
     * @return
     * @throws CostException
     */
    double getUnitPrice(int costType) throws CostException;

    /**
     *
     * @param costType
     * @param unitPrice
     * @return
     * @throws CostException
     */
    boolean saveUnitPrice(int costType, double unitPrice) throws CostException;
}
