package manage;

import entity.Log;
import exception.LogException;
import java.util.List;

public interface LogManage {

    boolean saveLog(Log log) throws LogException;

    List<Log> listLog() throws LogException;
}
