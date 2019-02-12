package manage;

import entity.House;
import exception.HouseException;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/27
 * @description: 房产信息管理层
 */
public interface HouseManage {
    /**
     * 通过hid获得业主
     * @param hid
     * @return
     * @throws HouseException
     */
    House getHouse (int hid) throws HouseException;
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
