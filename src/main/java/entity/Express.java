package entity;

/**
 * @description: 快递实体类
 */
public class Express
{
    private int eid;
    private int hid;
    private int isTake;
    private String gmt_create;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getIsTake() {
        return isTake;
    }

    public void setIsTake(int isTake) {
        this.isTake = isTake;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    @Override
    public String toString() {
        return "快递{" +
                "eid=" + eid +
                ", 房产id=" + hid +
                ", 是否领取=" + isTake +
                ", 时间='" + gmt_create + '\'' +
                '}';
    }
}
