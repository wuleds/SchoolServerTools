package hjnu.wl.SchoolServerTools.controller;

import hjnu.wl.SchoolServerTools.model.User;
import hjnu.wl.SchoolServerTools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wule
 */
@Controller
@RequestMapping("/register")
public class RegisterController
{
    @Autowired
    private UserService userService;

    /**用户注册
     * 测试通过**/
    @PostMapping("/user")
    @ResponseBody
    public String userRegister(User user)
    {
        String userId = user.getUserId();
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        String userSex = user.getUserSex();

        return userService.userRegister(userId,userName,userSex,userPassword);
    }

    /**管理员注册
     * 测试成功**/
    @PostMapping("/controller")
    @ResponseBody
    public String controllerRegister(hjnu.wl.SchoolServerTools.model.Controller controller)
    {
        String controllerId = controller.getControllerId();
        String controllerName = controller.getControllerName();
        String controllerPassword = controller.getControllerPassword();
        String controllerSex = controller.getControllerSex();
        String phoneNumber = controller.getPhoneNumber();
        String appointment = controller.getAppointment();

        System.out.println(controller);
        return userService.controllerRegister(controllerId,controllerName,controllerSex,controllerPassword,phoneNumber,appointment);
    }
}
