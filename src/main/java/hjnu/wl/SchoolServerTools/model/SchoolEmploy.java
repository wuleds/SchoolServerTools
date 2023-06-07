package hjnu.wl.SchoolServerTools.model;
//汉江师范学院 数计学院 吴乐创建于2023/6/6 23:30

/**
 * @author wule
 * 校园招聘信息
 */
public class SchoolEmploy
{
    private String schoolEmployId;  //校招信息id
    private String hrName;          //hr的id
    private String hrPhoneNumber;   //联系电话
    private String image;           //图片
    private String companyName;     //公司名称
    private String jobName;         //工作岗位
    private String salary;          //工资
    private String jobPower;        //工作能力要求
    private String jobContent;      //工作内容
    private String jobNotices;      //备注
    private String releaseTime;     //发布时间
    private String state;           //状态

    public SchoolEmploy() {}

    public String getSchoolEmployId() {
        return schoolEmployId;
    }

    public void setSchoolEmployId(String schoolEmployId) {
        this.schoolEmployId = schoolEmployId;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getHrPhoneNumber() {
        return hrPhoneNumber;
    }

    public void setHrPhoneNumber(String hrPhoneNumber) {
        this.hrPhoneNumber = hrPhoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobPower() {
        return jobPower;
    }

    public void setJobPower(String jobPower) {
        this.jobPower = jobPower;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getJobNotices() {
        return jobNotices;
    }

    public void setJobNotices(String jobNotices) {
        this.jobNotices = jobNotices;
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
        return "SchoolEmploy{" +
                "schoolEmployId='" + schoolEmployId + '\'' +
                ", hrName='" + hrName + '\'' +
                ", hrPhoneNumber='" + hrPhoneNumber + '\'' +
                ", image='" + image + '\'' +
                ", companyName='" + companyName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", salary='" + salary + '\'' +
                ", jobPower='" + jobPower + '\'' +
                ", jobContent='" + jobContent + '\'' +
                ", jobNotices='" + jobNotices + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
