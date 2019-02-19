package entity;

/**
 * @author: 我的袜子都是洞
 * @description: 房产实体
 * @path: web-entity-House
 * @date: 2019-01-11 21:25
 */
public class House
{
    // 房产id
    private int hid;
    // 房产持有人
    private String username;
    // 房产类型
    private String house_type;
    // 住房面积
    private int area;
    // 购房时间
    private String gmt_buy;
    // 楼号
    private String building;
    // 小区单元
    private String unit;
    // 门牌号
    private String house_num;
    // 创建时间
    private String gmt_create;
    // 修改时间
    private String gmt_modified;
    public House() {
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(String gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getGmt_buy() {
        return gmt_buy;
    }

    public void setGmt_buy(String gmt_buy) {
        this.gmt_buy = gmt_buy;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHouse_num() {
        return house_num;
    }

    public void setHouse_num(String house_num) {
        this.house_num = house_num;
    }

    @Override
    public String toString() {
        return "房产信息{" +
                "房产编号=" + hid +
                ", 持有人='" + username + '\'' +
                ", 房产类型='" + house_type + '\'' +
                ", 房子面积=" + area +
                ", 购房时间='" + gmt_buy + '\'' +
                ", 楼号='" + building + '\'' +
                ", 单元号='" + unit + '\'' +
                ", 门牌号=" + house_num +
                '}';
    }
}
