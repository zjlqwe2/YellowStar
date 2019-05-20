package entity;

/**
 * @description: 房产实体
 */
public class House
{
    private int hid;
    private String userName;
    private String identity;
    private String phone;
    private String houseType;
    private int area;
    private String gmtBuy;
    private String building;
    private String houseNum;

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getGmtBuy() {
        return gmtBuy;
    }

    public void setGmtBuy(String gmtBuy) {
        this.gmtBuy = gmtBuy;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    @Override
    public String toString() {
        return "House{" +
                "hid=" + hid +
                ", userName='" + userName + '\'' +
                ", identity='" + identity + '\'' +
                ", phone='" + phone + '\'' +
                ", houseType='" + houseType + '\'' +
                ", area=" + area +
                ", gmtBuy='" + gmtBuy + '\'' +
                ", building='" + building + '\'' +
                ", houseNum='" + houseNum + '\'' +
                '}';
    }
}
