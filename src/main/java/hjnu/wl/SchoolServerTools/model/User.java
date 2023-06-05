package hjnu.wl.SchoolServerTools.model;

/**
 * @author wule
 */
public class User
{
    private String userId;
    private String userName;
    private String userSex;
    private String userPassword;

    public User() {
    }

    public User(String userId, String userName, String userSex, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
