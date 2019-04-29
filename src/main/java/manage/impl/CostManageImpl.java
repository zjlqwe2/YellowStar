package manage.impl;

import entity.Cost;
import entity.House;
import exception.CostException;
import manage.CostManage;
import java.util.Map;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-CostManageImpl
 * @date: 2019-04-30 01:18
 */
public class CostManageImpl implements CostManage {
    /**
     * 添加费用
     *
     * @param cost
     * @return
     * @throws CostException
     */
    @Override
    public boolean saveCost(Cost cost) throws CostException {
        return false;
    }

    /**
     * 列出某类型费用
     *
     * @param costType
     * @return
     * @throws CostException
     */
    @Override
    public Map<Cost, House> listAllCost(int costType) throws CostException {
        return null;
    }

    /**
     * 修改费用
     *
     * @param cost
     * @return
     * @throws CostException
     */
    @Override
    public boolean updateCost(Cost cost) throws CostException {
        return false;
    }

    /**
     * 删除某条费用记录
     *
     * @param id
     * @return
     * @throws CostException
     */
    @Override
    public boolean deleteCost(int id) throws CostException {
        return false;
    }
}
