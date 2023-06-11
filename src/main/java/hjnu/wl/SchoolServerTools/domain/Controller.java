package hjnu.wl.SchoolServerTools.domain;

/**
 * @author wule
 * 管理员信息
 */
public class Controller
{
    private String controllerId;            //管理员id
    private String controllerName;          //管理员姓名
    private String controllerSex;           //管理员性别
    private String controllerPassword;      //管理员密码
    private String phoneNumber;             //管理员电话
    private String appointment;             //管理员职位
    private String state;                   //状态

    public Controller() {}

    public String getControllerId() {
        return controllerId;
    }

    public void setControllerId(String controllerId) {
        this.controllerId = controllerId;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getControllerSex() {
        return controllerSex;
    }

    public void setControllerSex(String controllerSex) {
        this.controllerSex = controllerSex;
    }

    public String getControllerPassword() {
        return controllerPassword;
    }

    public void setControllerPassword(String controllerPassword) {
        this.controllerPassword = controllerPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "controllerId='" + controllerId + '\'' +
                ", controllerName='" + controllerName + '\'' +
                ", controllerSex='" + controllerSex + '\'' +
                ", controllerPassword='" + controllerPassword + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", appointment='" + appointment + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}