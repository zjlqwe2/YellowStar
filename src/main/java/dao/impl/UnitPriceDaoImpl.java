package dao.impl;

import dao.UnitPriceDao;
import entity.UnitPrice;
import util.DBHelp;
import util.impl.UnitPriceMapperImpl;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/1
 * @description:
 */
public class UnitPriceDaoImpl implements UnitPriceDao {
    /**
     * 获取单价
     *
     * @param costType
     * @return
     */
    @Override
    public Double getUnitPrice(int costType) throws SQLException {
        String sql = "SELECT * FROM yw_unitprice WHERE cost_type=? ORDER BY pid DESC LIMIT 1";
        List<Object> objects = DBHelp.executeQuery(sql, new UnitPriceMapperImpl(), costType);
        if (objects == null || objects.size() == 0) {
            return null;
        }
        UnitPrice unitPrice = (UnitPrice)(objects.get(0));
        return unitPrice.getUnitPrice();
    }

    /**
     * 保存单价
     *
     * @param costType
     * @param unitPrice
     * @return
     */
    @Override
    public boolean saveUnitPrice(int costType, double unitPrice) throws SQLException {
        String sql = "INSERT INTO yw_unitprice (cost_type, unit_price) VALUES (?,?)";
        int flag = DBHelp.executeUpdate(sql, costType, unitPrice);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }
}
