package hjnu.wl.SchoolServerTools.service;

import hjnu.wl.SchoolServerTools.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wule
 */
@Service
public class RegisterService
{
    @Autowired
    private RegisterDao registerDao;

    public boolean register(String userId,String userName,String userSex,String userPassword)
    {
        return registerDao.register(userId,userName,userSex,userPassword);
    }
}
