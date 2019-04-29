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
     * 列出快递信息
     *
     * @return
     * @throws ExpressException
     */
    @Override
    public List<Express> listExpress() throws ExpressException {
        List<Express> list = new ArrayList<Express>();
        for (int i=1; i<20; i++) {
            Express express = new Express();
            express.setEid(i);
            express.setUsername("张三");
            express.setExpress_name("顺丰");
            express.setPhone("132****2123");
            express.setExpress_id("3123121343");
            express.setIsTake(0);
            express.setGmt_create("2019-10-"+i);
            list.add(express);
        }
        return list;
    }
}
