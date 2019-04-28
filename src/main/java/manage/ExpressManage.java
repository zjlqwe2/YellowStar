package manage;

import entity.Express;
import exception.ExpressException;
import java.util.List;

/**
 * 快递管理层
 */
public interface ExpressManage {

    /**
     * 添加快递
     * @param express
     * @return
     * @throws ExpressException
     */
    public boolean saveExpress(Express express) throws ExpressException;

    /**
     * 删除快递
     * @param id
     * @return
     * @throws ExpressException
     */
    public boolean deleteExpress(int id) throws ExpressException;

    /**
     * 修改快递信息
     * @param express
     * @return
     * @throws ExpressException
     */
    public boolean updateExpress(Express express) throws ExpressException;

    /**
     * 列出快递信息
     * @return
     * @throws ExpressException
     */
    public List<Express> listExpress() throws ExpressException;
}
