package hjnu.wl.SchoolServerTools.service;

import hjnu.wl.SchoolServerTools.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wule
 */
@Service
public class RegisterService
{
    @Autowired
    private UserDao UserDao;

    public boolean userRegister(String userId, String userName, String userSex, String userPassword)
    {
        return UserDao.userRegister(userId,userName,userSex,userPassword,"1");
    }
}