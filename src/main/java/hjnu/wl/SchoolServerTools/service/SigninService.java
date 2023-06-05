package hjnu.wl.SchoolServerTools.service;

import hjnu.wl.SchoolServerTools.dao.SigninDao;
import hjnu.wl.SchoolServerTools.model.Controller;
import hjnu.wl.SchoolServerTools.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wule
 */
@Service
public class SigninService
{
    @Autowired
    SigninDao signinDao;

    public boolean signin(String userId,String userPassword,String pattern)
    {
        boolean a = false;

        if("user".equals(pattern))
        {
            User user = signinDao.userSignin(userId,userPassword);
            if(user != null)
            {
                a = true;
            }
        }
        else if("controller".equals(pattern))
        {
            Controller controller = signinDao.controllerSignin(userId,userPassword);
            if(controller != null)
            {
                a = true;
            }
        }

        return a;
    }
}