package manage.impl;

import entity.Cost;
import entity.House;
import exception.CostException;
import manage.CostManage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-CostManageTestImpl
 * @date: 2019-04-29 01:29
 */
public class CostManageTestImpl implements CostManage {
    /**
     * 添加费用
     *
     * @param cost
     * @return
     * @throws CostException
     */
    @Override
    public boolean saveCost(Cost cost) throws CostException {
        System.out.println("添加费用");
        return true;
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
        Map<Cost, House> maps = new HashMap<>();
        for (int i=1; i<20; i++) {
            Cost cost = new Cost();
            House house = new House();
            cost.setCostType(1);
            cost.setId(i);
            cost.setHid(i+100);
            cost.setGmtCreate("2019-01-01");
            cost.setPrice(100+i);
            house.setUserName("张三"+i);
            maps.put(cost,house);
        }
        return maps;
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
        System.out.println("更新费用");
        return true;
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
        System.out.println("删除费用");
        return true;
    }
}
