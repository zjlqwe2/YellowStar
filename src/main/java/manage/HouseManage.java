package manage;

import entity.House;
import exception.HouseException;
import java.util.List;

/**
 * @description: 房产信息管理层
 */
public interface HouseManage {

    /**
     * 添加房产信息
     * @param house
     * @return
     * @throws HouseException
     */
    boolean saveHouse (House house) throws HouseException ;

    /**
     * 删除房产信息
     * @param hid
     * @return
     * @throws HouseException
     */
    boolean delHouse (int hid) throws HouseException ;

    /**
     * 修改房产信息
     * @param house
     * @return
     * @throws HouseException
     */
    boolean updateHouse (House house) throws HouseException ;

    /**
     * 列出房产信息
     * @return
     * @throws HouseException
     */
    List<House> listHouse () throws HouseException ;


}
