package dao.impl;

import dao.ExpressDao;
import entity.Express;
import util.DBHelp;
import util.impl.ExpressMapperImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 快递Dao层
 */
public class ExpressDaoImpl implements ExpressDao {
    /**
     * 录入快递信息
     *
     * @param express
     */
    @Override
    public boolean saveExpress(Express express) throws SQLException {
        String express_name = express.getExpress_name();
        String username = express.getUsername();
        String phone = express.getPhone();
        String express_id = express.getExpress_id();
        if ("".equals(express_name) || "".equals(username) || "".equals(phone) || "".equals(express_id)){
            return false;
        }
        String sql = "INSERT INTO express (express_name, username, phone, express_id) VALUES (?,?,?,?)";
        int i = DBHelp.executeUpdate(sql, express_name, username, phone ,express_id);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取所有快递
     *
     * @return
     */
    @Override
    public List<Express> listAllExpress() throws SQLException {
        String sql = "SELECT * FROM express";
        List<Object> list = DBHelp.executeQuery(sql, new ExpressMapperImpl());
        if (list==null || list.size()==0) {
            return null;
        }
        List<Express> expresses = new ArrayList<Express>();
        for (Object item:list) {
            expresses.add((Express) item);
        }
        return expresses;
    }

    /**
     * 获取未被领取快递
     *
     * @return
     */
    @Override
    public List<Express> listNotTakeExpress() throws SQLException {
        String sql = "SELECT * FROM express WHERE is_take = 0";
        List<Object> list = DBHelp.executeQuery(sql, new ExpressMapperImpl());
        if (list==null || list.size()==0) {
            return null;
        }
        List<Express> expresses = new ArrayList<Express>();
        for (Object item:list) {
            expresses.add((Express) item);
        }
        return expresses;
    }

    /**
     * 领取快递（修改快递状态）
     *
     * @param express
     * @return
     */
    @Override
    public boolean updateExpress(Express express) throws SQLException {
        int eid = express.getEid();
        String express_id = express.getExpress_id();
        if (eid<1 || "".equals(express_id)) {
            return false;
        }
        String sql = "UPDATE express SET is_take=1 WHERE eid=?";
        int flag = DBHelp.executeUpdate(sql, eid);
        if (flag == 0) {
            return false;
        } else {
            return true;
        }
    }
}
