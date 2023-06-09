package hjnu.wl.SchoolServerTools.controller;

import hjnu.wl.SchoolServerTools.model.User;
import hjnu.wl.SchoolServerTools.service.UserService;
import hjnu.wl.SchoolServerTools.util.RequestAndResponse;
import jakarta.servlet.http.Cookie;
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
    @RequestMapping("/user")
    @ResponseBody
    public String userSignin(User user)
    {
        String userId = user.getUserId();
        String userPassword = user.getUserPassword();
        String result = userService.userSignin(userId,userPassword);

        if(result.equals("SigninSuccess"))
        {
            System.out.println("00000");
            Cookie cookie = new Cookie("userId",userId);
            cookie.setMaxAge(60*60*24*7);
            RequestAndResponse.getResponse().addCookie(cookie);
            System.out.println("用户登录成功:"+userId);
        }
        return result;
    }

    /**管理员登录
     * 测试通过**/
    @PostMapping("/controller")
    @ResponseBody
    public String controllerSignin(hjnu.wl.SchoolServerTools.model.Controller controller)
    {
        String controllerId = controller.getControllerId();
        String controllerPassword = controller.getControllerPassword();
        String result = userService.controllerSignin(controllerId,controllerPassword);
        if(result.equals("RegisterSuccess"))
        {
            Cookie cookie = new Cookie("controller",controllerId);
            cookie.setMaxAge(60*60*24*7);
            RequestAndResponse.getResponse().addCookie(cookie);
            System.out.println("管理员登录成功:"+controllerId);
        }
        return result;
    }
}