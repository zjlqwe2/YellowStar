package entity;

/**
 * @author: 我的袜子都是洞
 * @date: 2019/1/31
 * @description: 费用单价实体
 */
public class UnitPrice {
    private int pid;
    private int costType;
    private double unitPrice;
    private String gmt_create;
    private String gmt_modified;

    public UnitPrice() {
    }

    @Override
    public String toString() {
        return "UnitPrice{" +
                "pid=" + pid +
                ", costType=" + costType +
                ", unitPrice=" + unitPrice +
                ", gmt_create='" + gmt_create + '\'' +
                ", gmt_modified='" + gmt_modified + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCostType() {
        return costType;
    }

    public void setCostType(int costType) {
        this.costType = costType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
}
