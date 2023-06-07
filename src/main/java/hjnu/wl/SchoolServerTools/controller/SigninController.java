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
@RequestMapping("/signin")
public class SigninController
{
    @Autowired
    private UserService userService;

    /**用户登录
     * 测试通过**/
    @PostMapping("/user")
    @ResponseBody
    public String userSignin(User user)
    {
        String userId = user.getUserId();
        String userPassword = user.getUserPassword();
        return userService.userSignin(userId,userPassword);
    }

    /**管理员登录
     * 测试通过**/
    @PostMapping("/controller")
    @ResponseBody
    public String controllerSignin(hjnu.wl.SchoolServerTools.model.Controller controller)
    {
        String controllerId = controller.getControllerId();
        String controllerPassword = controller.getControllerPassword();
        return userService.controllerSignin(controllerId,controllerPassword);
    }
}