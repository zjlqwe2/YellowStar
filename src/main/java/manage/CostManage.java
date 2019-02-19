package manage;

import exception.CostException;
import entity.Cost;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/1
 * @description: 价格管理层接口
 */
public interface CostManage {
    /**
     * 添加价格
     * @param cost
     * @return
     * @throws CostException
     */
    boolean saveCost(Cost cost) throws CostException;

    /**
     * 列出某户某型价格
     * @param hid
     * @param costType
     * @return
     * @throws CostException
     */
    List listTypeCost(int hid, int costType) throws CostException;

    /**
     * 列出某型所有户
     * @param costType
     * @return
     * @throws CostException
     */
    List listAllCost(int costType) throws CostException;
}
