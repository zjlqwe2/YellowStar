package dao;

import java.sql.SQLException;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/1
 * @description:
 */
public interface UnitPriceDao {
    /**
     * 获取单价
     * @param costType
     * @return
     */
    Double getUnitPrice(int costType) throws SQLException;

    /**
     * 保存单价
     * @param costType
     * @param unitPrice
     * @return
     */
    boolean saveUnitPrice(int costType, double unitPrice) throws SQLException;
}
