package entity;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/26
 * @description: 车位
 */
public class Stall {
    private int id;
    // 位置
    private String location;
    // 车牌号
    private String licenseplatenumber;
    // 创建时间
    private String gmt_create;
    // 修改时间
    private String gmt_modified;
    // 房产ID（外键）
    private int hid;

    public Stall() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLicenseplatenumber() {
        return licenseplatenumber;
    }

    public void setLicenseplatenumber(String licenseplatenumber) {
        this.licenseplatenumber = licenseplatenumber;
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
}
