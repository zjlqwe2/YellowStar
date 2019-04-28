package manage;

import exception.CostException;
import entity.Cost;
import java.util.List;

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
    boolean saveCost(Cost cost) throws CostException;

    /**
     * 列出某类型费用
     * @param costType
     * @return
     * @throws CostException
     */
    List<Cost> listAllCost(int costType) throws CostException;

    /**
     * 修改费用
     * @param cost
     * @return
     * @throws CostException
     */
    boolean updateCost(Cost cost) throws CostException;

    /**
     * 删除某条费用记录
     * @param id
     * @return
     * @throws CostException
     */
    boolean deleteCost(int id) throws CostException;
}
