package hjnu.wl.SchoolServerTools.domain;
//汉江师范学院 数计学院 吴乐创建于2023/6/6 22:52

/**
 * @author wule
 * 失物招领
 */
public class LostFound
{
    private String lostFoundId;      //失物招领id
    private String userId;           //用户id
    private String phoneNumber;      //联系电话
    private String thingName;        //物品名称
    private String thingImage;       //物品图片
    private String thingDescribe;    //物品描述
    private String releaseTime;      //发布时间
    private String state;            //状态

    public LostFound() {}

    public String getLostFoundId() {
        return lostFoundId;
    }

    public void setLostFoundId(String lostFoundId) {
        this.lostFoundId = lostFoundId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    public String getThingImage() {
        return thingImage;
    }

    public void setThingImage(String thingImage) {
        this.thingImage = thingImage;
    }

    public String getThingDescribe() {
        return thingDescribe;
    }

    public void setThingDescribe(String thingDescribe) {
        this.thingDescribe = thingDescribe;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LostFound{" +
                "lostFoundId='" + lostFoundId + '\'' +
                ", userId='" + userId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", thingName='" + thingName + '\'' +
                ", thingImage='" + thingImage + '\'' +
                ", thingDescribe='" + thingDescribe + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
