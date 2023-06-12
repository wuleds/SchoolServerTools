package hjnu.wl.SchoolServerTools.controller;

import hjnu.wl.SchoolServerTools.domain.User;
import hjnu.wl.SchoolServerTools.service.UserService;
import hjnu.wl.SchoolServerTools.util.Md5Util;
import hjnu.wl.SchoolServerTools.util.RequestAndResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wule
 */
/**用户登录**/
@CrossOrigin
@Controller
@RequestMapping("/signin")
public class SigninController
{
    private static UserService userService;
    @Autowired
    private UserService setUserService(UserService userService)
    {
        SigninController.userService = userService;
        return userService;
    }

    /**用户登录
     * 测试通过**/
    @RequestMapping("/user")
    @ResponseBody
    public String userSignin(User user)
    {
        String userId = user.getUserId();
        String userPassword = user.getUserPassword();
        String result = userService.userSignin(userId,userPassword);

        System.out.println(userId + " ," + userPassword);

        if("SigninSuccess".equals(result))
        {
            Cookie cookie = new Cookie("edu.hjnu.wl-userId",userId);
            cookie.setValue(Md5Util.getMd5(userPassword));
            cookie.setMaxAge(60*60*24*7);
            RequestAndResponse.getResponse().addCookie(cookie);
            System.out.println("用户登录成功:"+userId+",pwd:"+userPassword);
        }
        return result;
    }

    /**管理员登录
     * 测试通过**/
    @PostMapping("/controller")
    @ResponseBody
    public String controllerSignin(hjnu.wl.SchoolServerTools.domain.Controller controller)
    {
        String controllerId = controller.getControllerId();
        String controllerPassword = controller.getControllerPassword();
        String result = userService.controllerSignin(controllerId,controllerPassword);
        if("RegisterSuccess".equals(result))
        {
            Cookie cookie = new Cookie("edu.hjnu.wl-controllerId",controllerId);
            cookie.setValue(Md5Util.getMd5(controllerPassword));
            cookie.setMaxAge(60*60*24*7);
            RequestAndResponse.getResponse().addCookie(cookie);
            System.out.println("管理员登录成功:"+controllerId);
        }
        return result;
    }
}