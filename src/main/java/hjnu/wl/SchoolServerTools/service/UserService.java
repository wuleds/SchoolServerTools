package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 0:56

import hjnu.wl.SchoolServerTools.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**用户管理员业务逻辑层*/
@Service
public class UserService
{
    private static UserDao userDao;
    @Autowired
    private void setUserDao(UserDao userDao)
    {
        UserService.userDao = userDao;
    }

    /**用户注册**/
    public String userRegister(String userId,String userName,String userSex,String userPassword)
    {
        try {

            if (userId.length() < 6 || userId.length() > 10)
                return "IdLengthError";
            if (userPassword.length() < 6 || userPassword.length() > 10)
                return "PasswordLengthError";
            if (userName.length() < 2 || userName.length() > 10)
                return "NameLengthError";
        }catch (NullPointerException e) {
            e.printStackTrace();
            return "NullPointerException";
        }
        //防止出现管理员与普通用户出现账户一样的情况。
        if(userDao.isUserExist(userId) != null || userDao.isControllerExist(userId) != null)
            return "IdExistError";

        if(userDao.userRegister(userId,userName,userSex,userPassword,"1"))
            return "RegisterSuccess";

        return "RegisterFail";
    }

    /**管理员注册**/
    public String controllerRegister(String controllerId,String controllerName,String controllerSex,String controllerPassword,String phoneNumber,String appointment)
    {
        try {

            if (controllerId.length() < 6 || controllerId.length() > 10)
                return "IdLengthError";
            if (controllerPassword.length() < 6 || controllerPassword.length() > 10)
                return "PasswordLengthError";
            if (controllerName.length() < 2 || controllerName.length() > 10)
                return "NameLengthError";
            if (phoneNumber.length() != 11)
                return "PhoneNumberLengthError";
            if (appointment.length() < 2 || appointment.length() > 10)
                return "AppointmentLengthError";
        }catch (NullPointerException e) {
            e.printStackTrace();
            return "NullPointerException";
        }
        //防止出现管理员与普通用户出现账户一样的情况。
        if(userDao.isUserExist(controllerId) != null || userDao.isControllerExist(controllerId) != null)
            return "IdExistError";

        if(userDao.controllerRegister(controllerId,controllerName,controllerPassword,controllerSex,phoneNumber,appointment,"1"))
            return "RegisterSuccess";

        return "RegisterFail";
    }

    /**用户登录**/
    public String userSignin(String userId,String userPassword)
    {
        //判断用户id是否已经存在,如果存在，则进行下一步
        if(userDao.isUserExist(userId) != null)
        {
            //登录
            if(userDao.userSignin(userId,userPassword) != null)
            {
                return "SigninSuccess";
            }
        }
        return "SigninFail";
    }

    /**管理员登录**/
    public String controllerSignin(String controllerId,String controllerPassword)
    {
        //判断管理员id是否已经存在,如果存在，则进行下一步
        if(userDao.isControllerExist(controllerId) != null)
        {
            //登录
            if(userDao.controllerSignin(controllerId,controllerPassword) != null)
            {
                return "SigninSuccess";
            }
        }
        return "SigninFail";
    }

    /**修改用户信息**/
    public String  updateUserData(String userId,String userName,String userSex,String userPassword)
    {
        //判断用户id是否已经存在,如果存在，则进行下一步
        if(userDao.isUserExist(userId) != null)
        {
            if(userName.length() < 2 || userName.length() > 10)
                return "NameLengthError";
            if(userPassword.length() < 6 || userPassword.length() > 10)
                return "PasswordLengthError";
            //修改
            if(userDao.updateUserData(userId,userName,userSex,userPassword) != null)
            {
                return "UpdateSuccess";
            }
        }
        return "UpdateFail";
    }

    /**修改管理员信息**/
    public String updateControllerData(String controllerId,String controllerName,String controllerSex,String controllerPassword,String phoneNumber,String appointment)
    {
        //判断管理员id是否已经存在,如果存在，则进行下一步
        if(userDao.isControllerExist(controllerId) != null)
        {
            if(controllerName.length() < 2 || controllerName.length() > 10)
                return "NameLengthError";
            if(controllerPassword.length() < 6 || controllerPassword.length() > 10)
                return "PasswordLengthError";
            if(phoneNumber.length() != 11)
                return "PhoneNumberLengthError";
            if(appointment.length() < 6 || appointment.length() > 10)
                return "AppointmentLengthError";
            //修改
            if(userDao.updateControllerData(controllerId,controllerName,controllerSex,controllerPassword,phoneNumber,appointment) != null)
            {
                return "UpdateSuccess";
            }
        }
        return "UpdateFail";
    }

    /**禁止该用户登录**/
    public String banUser(String userId)
    {
        //判断用户id是否已经存在,如果存在，则进行下一步
        if(userDao.isUserExist(userId) != null)
        {
            //禁止
            if(userDao.banUser(userId))
            {
                return "BanUserSuccess";
            }
        }
        return "BanUserFail";
    }

    /**禁止该管理员登录**/
    public String banController(String controllerId)
    {
        //判断管理员id是否已经存在,如果存在，则进行下一步
        if(userDao.isControllerExist(controllerId) != null)
        {
            //禁止
            if(userDao.banController(controllerId))
            {
                return "BanControllerSuccess";
            }
        }
        return "BanControllerFail";
    }

    /**设置头像**/
    public String setProfilePhoto(String id,String photoMd5)
    {
        if(userDao.setProfilePhoto(id,photoMd5))
        {
            return "setProfilePhotoSuccess";
        }
        return "setProfilePhotoFail";
    }

}