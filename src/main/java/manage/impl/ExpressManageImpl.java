package manage.impl;

import entity.Express;
import exception.ExpressException;
import manage.ExpressManage;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-ExpressManageImpl
 * @date: 2019-04-30 01:17
 */
public class ExpressManageImpl implements ExpressManage {
    /**
     * 添加快递
     *
     * @param express
     * @return
     * @throws ExpressException
     */
    @Override
    public boolean saveExpress(Express express) throws ExpressException {
        return false;
    }

    /**
     * 领取快递
     *
     * @param id
     * @return
     * @throws ExpressException
     */
    @Override
    public boolean takeExpress(int id) throws ExpressException {
        return false;
    }

    /**
     * 列出快递信息
     *
     * @return
     * @throws ExpressException
     */
    @Override
    public List<Express> listExpress() throws ExpressException {
        return null;
    }
}
