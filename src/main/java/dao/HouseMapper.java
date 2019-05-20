package dao;

import entity.House;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @description: 房产处理类
 */
public interface HouseMapper
{
    /**
     * 添加房产信息
     */
    boolean addHouse(House house);

    /**
     * 获得指定房产号的房产信息
     */
    House getHouseById(int hid);

    /**
     * 删除指定房产信息
     */
    boolean deleteHouseById (int hid);

    /**
     * 更新房产信息
     */
    boolean updateHouse (House house);

    /**
     * 分页查询
     * @return
     */
    List<House> queryHouseByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize );

    /**
     * 查询房产信息总数
     * @return
     */
    Integer queryHouseCnt();
}
