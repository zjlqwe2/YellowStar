package entity;

/**
 * @description: 用户实体
 */
public class User
{
    private int uid;
    private String loginName;
    private String passWord;
    private int userType;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "用户对象 {" +
                "用户id=" + uid +
                ", 登录名='" + loginName + '\'' +
                ", 密码='" + passWord + '\'' +
                ", 用户类型=" + userType +
                '}';
    }
}
