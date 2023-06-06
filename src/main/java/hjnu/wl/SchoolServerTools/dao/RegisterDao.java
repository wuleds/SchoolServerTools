package hjnu.wl.SchoolServerTools.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wule
 * 注册
 */
@Mapper
public interface RegisterDao
{
    /***
     * 普通用户注册
     * param userId 账户
     * param userName 用户名
     * param userSex 性别
     * param userPassword 密码
     * return boolean 是否注册成功
     * ***/
    @Insert("insert into user (userId,userName,userSex,userPassword) value(#{userId},#{userName},#{userSex},#{userPassword})")
    boolean userRegister(String userId,String userName,String userSex,String userPassword);

    /***
     * 管理员注册
     * param controllerId 账户
     * param controllerName 用户名
     * param controllerSex 性别
     * param controllerPassword 密码
     * param phoneNumber 电话号码
     * param appointment 职位
     * return boolean 是否注册成功
     * ***/
    @Insert("insert into controller (controllerId,controllerName,controllerPassword,controllerSex,phoneNumber,appointment) value(#{controllerId},#{controllerName},#{controllerPassword},#{controllerSex},#{phoneNumber},#{appointment})")
    boolean controllerRegister(String controllerId,String controllerName,String controllerPassword,String controllerSex,String phoneNumber,String appointment);
}