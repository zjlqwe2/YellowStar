package manage.impl;

import entity.Express;
import exception.ExpressException;
import manage.ExpressManage;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 快递Manage层
 */
public class ExpressManageTestImpl implements ExpressManage {
    /**
     * 添加快递
     *
     * @param express
     * @return
     * @throws ExpressException
     */
    @Override
    public boolean saveExpress(Express express) throws ExpressException {
        return true;
    }

    /**
     * 领取快递
     *
     * @param eid
     * @return
     * @throws ExpressException
     */
    @Override
    public boolean takeExpress(int eid) throws ExpressException {
        return true;
    }

    /**
     * 列出所有快递信息
     *
     * @return
     * @throws ExpressException
     */
    @Override
    public List<Express> listAllExpress() throws ExpressException {
        return null;
    }

    /**
     * 列出为领取快递信息
     *
     * @return
     * @throws ExpressException
     */
    @Override
    public List<Express> listNotTakeExpress() throws ExpressException {
        return null;
    }
}
