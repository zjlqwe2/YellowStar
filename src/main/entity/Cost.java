package entity;

/**
 * @author: 我的袜子都是洞
 * @description: 费用的实体类，对应数据库中的表(某一户)
 * @path: web-entity.cost-Cost
 * @date: 2019-01-26 14:40
 */
public class Cost {
    private int id;
    private int hid;
    private String userName;
    private int costType;
    private double unitPrice;
    private double amount;
    private String gmtCreate;
    private String gmtModified;

    public Cost() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "id=" + id +
                ", hid=" + hid +
                ", userName='" + userName + '\'' +
                ", costType=" + costType +
                ", unitPrice=" + unitPrice +
                ", amount=" + amount +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                '}';
    }
}
