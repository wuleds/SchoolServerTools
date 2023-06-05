package hjnu.wl.SchoolServerTools.model;

/**
 * @author wule
 */
public class Controller
{
    private String controllerId;
    private String controllerName;
    private String controllerSex;
    private String controllerPassword;
    private String controllerPhoneNumber;
    private String appointment;

    public Controller() {}

    public Controller(String controllerId, String controllerName, String controllerSex, String controllerPassword, String controllerPhoneNumber, String appointment) {
        this.controllerId = controllerId;
        this.controllerName = controllerName;
        this.controllerSex = controllerSex;
        this.controllerPassword = controllerPassword;
        this.controllerPhoneNumber = controllerPhoneNumber;
        this.appointment = appointment;
    }

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

    public String getControllerPhoneNumber() {
        return controllerPhoneNumber;
    }

    public void setControllerPhoneNumber(String controllerPhoneNumber) {
        this.controllerPhoneNumber = controllerPhoneNumber;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
}