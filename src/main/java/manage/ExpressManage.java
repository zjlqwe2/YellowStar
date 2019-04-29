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
     * 领取快递
     * @param id
     * @return
     * @throws ExpressException
     */
    public boolean takeExpress(int id) throws ExpressException;

    /**
     * 列出快递信息
     * @return
     * @throws ExpressException
     */
    public List<Express> listExpress() throws ExpressException;
}
