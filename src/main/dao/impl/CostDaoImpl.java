package dao.impl;

import dao.CostDao;
import util.DBHelp;
import util.impl.CostMapperImpl;
import util.impl.StallCostMapperImpl;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/31
 * @description: 费用Dao层实现
 */
public class CostDaoImpl implements CostDao {
    /**
     * 费用录入
     * @param hid      业主ID
     * @param costType 费用类型
     * @param amount   用量
     */
    @Override
    public boolean saveCost(int hid, int costType, double amount) throws SQLException {
        String sql = "INSERT INTO yw_cost (hid, cost_type, unit_price, amount) VALUES (?,?,(SELECT unit_price FROM yw_unitprice WHERE cost_type=? ORDER BY pid DESC LIMIT 1),?)";
        int flag = DBHelp.executeUpdate(sql, hid, costType, costType, amount);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 费用查询
     * @param hid 业主ID
     * @param costType 费用类型
     * @return 费用对象
     */
    @Override
    public List listTypeCost(int hid, int costType) throws SQLException {
        if (costType != 5) {
            String sql = "SELECT yw_cost.*,yw_house.username FROM yw_cost JOIN yw_house ON yw_cost.hid = yw_house.hid WHERE yw_cost.cost_type=? AND yw_cost.hid=?";
            List<Object> objects = DBHelp.executeQuery(sql,new CostMapperImpl(), costType,hid);
            return objectToCost (objects);
        } else {
            String sql = "SELECT yw_cost.*, yw_house.username, yw_stall.location, yw_stall.licenseplatenumber FROM (yw_cost JOIN yw_house ON yw_cost.hid = yw_house.hid) JOIN yw_stall ON yw_house.hid = yw_stall.hid WHERE yw_cost.cost_type=? AND yw_cost.hid=?";
            List<Object> objects = DBHelp.executeQuery(sql,new StallCostMapperImpl(), costType,hid);
            return objectToCost (objects);
        }
    }

    /**
     * 获取某类费用的所有数据
     * @param costType 费用类型
     * @return 费用集合
     */
    @Override
    public List listAllCost(int costType) throws SQLException {
        if (costType != 5) {
            String sql = "SELECT yw_cost.*,yw_house.username FROM yw_cost JOIN yw_house ON yw_cost.hid = yw_house.hid WHERE yw_cost.cost_type=?";
            List<Object> objects = DBHelp.executeQuery(sql,new CostMapperImpl(), costType);
            return objectToCost (objects);
        } else {
            /**
             * 停车费用还需要显示车位相关信息
             * 故采用了三表连接语句
             */
            String sql = "SELECT yw_cost.*, yw_house.username, yw_stall.location, yw_stall.licenseplatenumber FROM (yw_cost JOIN yw_house ON yw_cost.hid = yw_house.hid) JOIN yw_stall ON yw_house.hid = yw_stall.hid WHERE yw_cost.cost_type=?";
            List<Object> objects = DBHelp.executeQuery(sql,new StallCostMapperImpl(), costType);
            return objectToCost (objects);
        }
    }


    /**
     *   Object 转 Cost
     * @param objects
     * @return
     */
    private List objectToCost(List<Object> objects) {
        if (objects == null || objects.size() == 0) {
            return null;
        }
        return objects;
    }
}
