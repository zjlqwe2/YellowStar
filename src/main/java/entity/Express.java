package entity;

/**
 * @description: 快递实体类
 */
public class Express
{
    private int eid;
    private String username;
    private String phone;
    private String express_name;
    private String express_id;
    private int isTake;
    private String gmt_create;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExpress_name() {
        return express_name;
    }

    public void setExpress_name(String express_name) {
        this.express_name = express_name;
    }

    public String getExpress_id() {
        return express_id;
    }

    public void setExpress_id(String express_id) {
        this.express_id = express_id;
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
        return "Express{" +
                "eid=" + eid +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", express_name='" + express_name + '\'' +
                ", express_id='" + express_id + '\'' +
                ", isTake=" + isTake +
                ", gmt_create='" + gmt_create + '\'' +
                '}';
    }
}
