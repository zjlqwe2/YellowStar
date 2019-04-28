package entity;

/**
 * @description: 快递实体类
 */
public class Express
{
    private int eid;
    private int hid;
    private String express_id;
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

    public String getExpress_id() {
        return express_id;
    }

    public void setExpress_id(String express_id) {
        this.express_id = express_id;
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
                ", hid=" + hid +
                ", 单号='" + express_id + '\'' +
                ", 是否领取=" + isTake +
                ", 创建时间='" + gmt_create + '\'' +
                '}';
    }
}
