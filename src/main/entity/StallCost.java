package entity;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/2/6
 * @description: 包含停车位信息的费用实体
 */
public class StallCost extends Cost{
    private String location;
    private String licenseplatenumber;
    private int hid;

    public StallCost() {
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

    @Override
    public int getHid() {
        return hid;
    }

    @Override
    public void setHid(int hid) {
        this.hid = hid;
    }

    @Override
    public String toString() {
        return super.toString() + "StallCost{" +
                "location='" + location + '\'' +
                ", licenseplatenumber='" + licenseplatenumber + '\'' +
                ", hid=" + hid +
                '}';
    }
}