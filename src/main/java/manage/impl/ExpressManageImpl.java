package manage.impl;

import dao.ExpressDao;
import dao.impl.ExpressDaoImpl;
import entity.Express;
import exception.ExpressException;
import manage.ExpressManage;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-manage.impl-ExpressManageImpl
 * @date: 2019-04-30 01:17
 */
public class ExpressManageImpl implements ExpressManage {

    private ExpressDao expressDao = new ExpressDaoImpl();

    /**
     * 添加快递
     *
     * @param express
     * @return
     * @throws ExpressException
     */
    @Override
    public boolean saveExpress(Express express) throws ExpressException {
        String express_name = express.getExpress_name();
        String username = express.getUsername();
        String phone = express.getPhone();
        String express_id = express.getExpress_id();
        if ("".equals(express_name) || "".equals(username) || "".equals(phone) || "".equals(express_id)){
            return false;
        }
        try {
            boolean flag = expressDao.saveExpress(express);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new ExpressException(e.getMessage());
        }
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
        if (id < 1) {
            return false;
        }
        try {
            Express express = new Express();
            express.setEid(id);
            boolean flag = expressDao.updateExpress(express);
            if (flag) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new ExpressException(e.getMessage());
        }
    }

    /**
     * 列出快递信息
     *
     * @return
     * @throws ExpressException
     */
    @Override
    public List<Express> listAllExpress() throws ExpressException {
        try {
            List<Express> list = expressDao.listAllExpress();
            return list;
        } catch (SQLException e) {
            throw new ExpressException(e.getMessage());
        }
    }

    /**
     * 列出为领取快递信息
     *
     * @return
     * @throws ExpressException
     */
    @Override
    public List<Express> listNotTakeExpress() throws ExpressException {
        try {
            List<Express> list = expressDao.listNotTakeExpress();
            return list;
        } catch (SQLException e) {
            throw new ExpressException(e.getMessage());
        }
    }
}
