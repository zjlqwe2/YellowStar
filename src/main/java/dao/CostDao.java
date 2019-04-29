package dao;

import entity.Cost;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description: 费用处理Dao接口
 * @author: 我的袜子都是洞
 * @date: 2019-01-31 15:46
 */
public interface CostDao {
    /**
     * 费用录入
     */
    boolean saveCost(Cost cost) throws SQLException;

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