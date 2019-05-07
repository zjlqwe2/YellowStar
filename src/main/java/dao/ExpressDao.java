package dao;

import entity.Express;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description: 快递数据Dao
 */
public interface ExpressDao
{
    /**
     * 录入快递信息
     * @param express
     */
    boolean saveExpress(Express express) throws SQLException;

    /**
     * 获取所有快递
     * @return
     */
    List<Express> listAllExpress() throws SQLException;

    /**
     * 获取未被领取快递
     * @return
     */
    List<Express> listNotTakeExpress() throws SQLException;

    /**
     * 获取已经领取的快递
     * @return
     * @throws SQLException
     */
    List<Express> listTakedExpress() throws SQLException;

    /**
     * 领取快递（修改快递状态）
     * @param express
     * @return
     */
    boolean updateExpress(Express express) throws SQLException;
}
