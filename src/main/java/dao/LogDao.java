package dao;


import entity.Log;
import java.sql.SQLException;
import java.util.List;

public interface LogDao {

    boolean saveLog(Log log) throws SQLException;

    List<Log> listLog() throws SQLException;
}
