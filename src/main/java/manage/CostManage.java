package manage;

import entity.House;
import exception.CostException;
import entity.Cost;
import java.util.Map;

/**
 * @description: 费用管理层接口
 */
public interface CostManage {
    /**
     * 添加费用
     * @param cost
     * @return
     * @throws CostException
     */
    boolean saveCost(Cost cost, String operator) throws CostException;

    /**
     * 列出某类型费用
     * @param costType
     * @return
     * @throws CostException
     */
    Map<Cost, House> listAllCost(int costType) throws CostException;

    /**
     * 修改费用
     * @param cost
     * @return
     * @throws CostException
     */
    boolean updateCost(Cost cost, String operator) throws CostException;

    /**
     * 删除某条费用记录
     * @param id
     * @return
     * @throws CostException
     */
    boolean deleteCost(int id, String operator) throws CostException;
}
