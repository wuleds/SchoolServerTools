package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/9 17:54

import hjnu.wl.SchoolServerTools.util.RequestAndResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**注销**/
@Controller
public class LogoutController
{
    @RequestMapping("/logout")
    @ResponseBody
    public String userLogout()
    {
        String result = "LogoutFail";
        Cookie[] cookies = RequestAndResponse.getRequest().getCookies();
        for(Cookie cookie:cookies)
        {
            if("edu.hjnu.wl-userId".equals(cookie.getName()) || "edu.hjnu.wl-controllerId".equals(cookie.getName()))
            {
                cookie.setMaxAge(0);
                RequestAndResponse.getResponse().addCookie(cookie);
                System.out.println("用户注销");
                result = "LogoutSuccess";
            }
        }
        return result;
    }
}