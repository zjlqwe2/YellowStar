package dao;

import entity.House;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.MybatisUtil;
import java.util.List;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: YellowStar-dao-TestHouse
 * @date: 2019-05-20 19:51
 */
public class TestHouse {
    private SqlSession session;
    private HouseMapper mapper;

    @Before
    public void before () throws Exception{
        session = MybatisUtil.getSession();
        mapper = session.getMapper(HouseMapper.class);
    }

    @After
    public void after() {
        session.close();
    }

    @Test
    public void testAddHouse() {
        House house = new House();
        house.setUserName("黄鑫a ");
        house.setIdentity("22312312");
        house.setPhone("134****2123");
        house.setHouseType("三室一厅");
        house.setArea(100);
        house.setGmtBuy("2019-01-01 09:00:00");
        house.setBuilding("27栋");
        house.setHouseNum("101");
        mapper.addHouse(house);
        session.commit();
    }

    @Test
    public void testGetHouseById() {
        House h = mapper.getHouseById(2);
        System.out.println(h);
    }

    @Test
    public void testQueryHouseCnt() {
        Integer cnt = mapper.queryHouseCnt();
        System.out.println(cnt);
    }

    @Test
    public void testQueryHouseByPage() {
        List<House> houses = mapper.queryHouseByPage(0,2);
        for (House h:houses) {
            System.out.println(h);
        }
    }

    @Test
    public void testUpdateHouse() {
        House h = mapper.getHouseById(2);
        h.setUserName("张三");
        mapper.updateHouse(h);
        session.commit();
    }

    @Test
    public void testDeleteHouseById() {
        Boolean flag = mapper.deleteHouseById(4);
        System.out.println(flag);
        session.commit();
    }

}
