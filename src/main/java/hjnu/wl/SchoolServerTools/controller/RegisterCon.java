package hjnu.wl.SchoolServerTools.controller;

import hjnu.wl.SchoolServerTools.model.User;
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
    private RegisterService registerService;

    @PostMapping("/user")
    public String register(User user)
    {
        String userId = user.getUserId();
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        String userSex = user.getUserSex();

        registerService.userRegister(userId,userName,userSex,userPassword);

        return "";
    }
}
