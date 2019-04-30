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
    private String unit;
    private String houseNum;
    private String location;
    private String brand;
    private String licenseplatenumber;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
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
                ", unit='" + unit + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", location='" + location + '\'' +
                ", brand='" + brand + '\'' +
                ", licenseplatenumber='" + licenseplatenumber + '\'' +
                '}';
    }
}
