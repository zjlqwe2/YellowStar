package manage.impl;

import dao.ExpressDao;
import dao.impl.ExpressDaoImpl;
import entity.Express;
import entity.Log;
import exception.ExpressException;
import exception.LogException;
import manage.ExpressManage;
import manage.LogManage;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 */
public class ExpressManageImpl implements ExpressManage {

    private ExpressDao expressDao = new ExpressDaoImpl();
    private LogManage logManage = new LogManageImpl();

    /**
     * 添加快递
     *
     * @param express
     * @return
     * @throws ExpressException
     */
    @Override
    public boolean saveExpress(Express express, String operator) throws ExpressException {
        String express_name = express.getExpress_name();
        String username = express.getUsername();
        String phone = express.getPhone();
        String express_id = express.getExpress_id();
        if ("".equals(express_name) || "".equals(username) || "".equals(phone) || "".equals(express_id)){
            return false;
        }
        Log log = new Log();
        log.setOperation("添加["+username+"]快递信息");
        log.setOperator(operator);

        try {
            boolean flag = expressDao.saveExpress(express);
            boolean flag2 = logManage.saveLog(log);
            if (flag && flag2) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new ExpressException(e.getMessage());
        } catch (LogException e) {
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

    /**
     * 列出已经领取的快递
     *
     * @return
     * @throws ExpressException
     */
    @Override
    public List<Express> listTakedExpress() throws ExpressException {
        try {
            List<Express> list = expressDao.listTakedExpress();
            return list;
        } catch (SQLException e) {
            throw new ExpressException(e.getMessage());
        }
    }
}
