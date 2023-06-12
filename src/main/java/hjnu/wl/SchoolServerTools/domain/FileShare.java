package hjnu.wl.SchoolServerTools.domain;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 23:55

public class FileShare
{
    private int fileShareId;
    private String sharerId;
    private String fileId;
    private String notices;
    private String shareTime;
    private String state;

    public FileShare() {}

    public int getFileShareId() {
        return fileShareId;
    }

    public void setFileShareId(int fileShareId) {
        this.fileShareId = fileShareId;
    }

    public String getSharerId() {
        return sharerId;
    }

    public void setSharerId(String sharerId) {
        this.sharerId = sharerId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getNotices() {
        return notices;
    }

    public void setNotices(String notices) {
        this.notices = notices;
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
        return "FIleShare{" +
                "fileShareId='" + fileShareId + '\'' +
                ", sharerId='" + sharerId + '\'' +
                ", fileId='" + fileId + '\'' +
                ", notices='" + notices + '\'' +
                ", shareTime='" + shareTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
