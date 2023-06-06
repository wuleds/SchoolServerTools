package hjnu.wl.SchoolServerTools.controller;

import hjnu.wl.SchoolServerTools.model.User;
import hjnu.wl.SchoolServerTools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wule
 */
@Controller
@RequestMapping("/register")
public class RegisterCon
{
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String register(User user)
    {
        String userId = user.getUserId();
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        String userSex = user.getUserSex();

        if(userService.userRegister(userId,userName,userSex,userPassword))
            return "ok";
        return "no";
    }
}
