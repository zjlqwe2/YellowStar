package entity;

/**
 * @description: 费用的实体
 */
public class Cost {
    private int id;
    private int hid;
    private int costType;
    private double price;
    private String gmtCreate;

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

    public int getCostType() {
        return costType;
    }

    public void setCostType(int costType) {
        this.costType = costType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "费用{" +
                "费用id=" + id +
                ", 房产id=" + hid +
                ", 费用类型=" + costType +
                ", 费用=" + price +
                ", 时间='" + gmtCreate + '\'' +
                '}';
    }
}
