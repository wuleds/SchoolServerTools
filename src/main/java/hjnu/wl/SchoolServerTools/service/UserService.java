package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 0:56

import hjnu.wl.SchoolServerTools.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserDao userDao;

    public boolean userRegister(String userId,String userName,String userSex,String userPassword)
    {
        boolean a = false;
        //判断用户是否存在
        if(userDao.isUserExist(userId) != null)
        {
            //如果用户存在，继续判断该用户是否允许登录
            if(userDao.userSignin(userId,userPassword) != null)
            {
                a = true;
            }
        }

        return a;
    }
}
