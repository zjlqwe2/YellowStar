package dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description: 费用处理Dao接口
 */
public interface CostDao {
    /**
     * 费用录入
     * @param hid 业主ID
     * @param costType 费用类型
     * @param amount 用量
     */
    boolean saveCost(int hid,int costType,double amount) throws SQLException;

    /**
     * 费用查询
     * @param hid 业主ID
     * @param costType 费用类型
     * @return 费用对象
     */
    List listTypeCost(int hid, int costType) throws SQLException;

    /**
     * 获取某类费用的所有数据
     * @param costType 费用类型
     * @return 费用集合
     */
    List listAllCost(int costType) throws SQLException;
}