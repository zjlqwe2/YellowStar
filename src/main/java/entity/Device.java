package entity;

/**
 * @description: 设备实体
 */
public class Device {
    private int did;
    private String device_name;
    private String device_type;
    private int is_service;
    private String processing_opinion;
    private String user;
    private String gmt_create;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public int getIs_service() {
        return is_service;
    }

    public void setIs_service(int is_service) {
        this.is_service = is_service;
    }

    public String getProcessing_opinion() {
        return processing_opinion;
    }

    public void setProcessing_opinion(String processing_opinion) {
        this.processing_opinion = processing_opinion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    @Override
    public String toString() {
        return "设备实体{" +
                "编号=" + did +
                ", 设备名称='" + device_name + '\'' +
                ", 设备类型='" + device_type + '\'' +
                ", 是否维修=" + is_service +
                ", 处理意见='" + processing_opinion + '\'' +
                ", 处理人=" + user +
                ", 创建时间='" + gmt_create + '\'' +
                '}';
    }
}