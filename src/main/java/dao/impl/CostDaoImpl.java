package dao.impl;

import dao.CostDao;
import entity.Cost;
import util.DBHelp;
import util.impl.CostMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-dao.impl-CostDaoImpl
 * @date: 2019-04-29 23:18
 */
public class CostDaoImpl implements CostDao {
    /**
     * 费用录入
     */
    @Override
    public boolean saveCost(Cost cost) throws SQLException {
        String sql = "INSERT INTO cost (hid, cost_type, price) VALUES (?,?,?)";
        int i = DBHelp.executeUpdate(sql, cost.getHid(),cost.getCostType(), cost.getPrice());
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 费用修改
     *
     * @param cost
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateCost(Cost cost) throws SQLException {
        String sql = "UPDATE cost SET price=? WHERE id=?";
        int i = DBHelp.executeUpdate(sql, cost.getPrice(), cost.getId());
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 删除某费用
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public boolean deleteCost(int id) throws SQLException {
        if(id < 1) {
            return false;
        }
        String sql = "DELETE FROM cost WHERE id=?";
        int i = DBHelp.executeUpdate(sql, id);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 费用查询
     *
     * @param hid      业主ID
     * @param costType 费用类型
     * @return 费用对象
     */
    @Override
    public List listTypeCost(int hid, int costType) throws SQLException {
        if (hid<1 || costType <1) {
            return null;
        }
        String sql = "SELECT * FROM cost WHERE hid=? and cost_type=?";
        List<Object> list = DBHelp.executeQuery(sql, new CostMapperImpl(),hid,costType);
        if (list==null || list.size()==0) {
            return null;
        }
        List<Cost> costs = new ArrayList<Cost>();
        for (Object o:list) {
            costs.add((Cost)o);
        }
        return costs;
    }

    /**
     * 获取某类费用的所有数据
     *
     * @param costType 费用类型
     * @return 费用集合
     */
    @Override
    public List listAllCost(int costType) throws SQLException {
        if (costType < 1) {
            return null;
        }
        String sql = "SELECT * FROM cost WHERE cost_type=?";
        List<Object> list = DBHelp.executeQuery(sql, new CostMapperImpl(), costType);
        if (list==null || list.size()==0) {
            return null;
        }
        List<Cost> costs = new ArrayList<Cost>();
        for (Object o:list) {
            costs.add((Cost)o);
        }
        return costs;
    }
}
