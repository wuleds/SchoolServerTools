package hjnu.wl.SchoolServerTools.model;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 22:58

/**
 * 信息分享
 */
public class DataShare
{
    private String dataShareId;
    private String sharerId;
    private String title;
    private String content;
    private String image;
    private String shareTime;
    private String state;

    public DataShare() {}

    public String getDataShareId() {
        return dataShareId;
    }

    public void setDataShareId(String dataShareId) {
        this.dataShareId = dataShareId;
    }

    public String getSharerId() {
        return sharerId;
    }

    public void setSharerId(String sharerId) {
        this.sharerId = sharerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShareTime() {
        return shareTime;
    }

    public void setShareTime(String shareTime) {
        this.shareTime = shareTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "dataShare{" +
                "dataShareId='" + dataShareId + '\'' +
                ", sharerId='" + sharerId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", shareTime='" + shareTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
