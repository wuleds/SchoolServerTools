package hjnu.wl.SchoolServerTools.dao;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 0:24

import hjnu.wl.SchoolServerTools.model.Controller;
import hjnu.wl.SchoolServerTools.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao
{
    @Insert("insert into user (userId,userName,userSex,userPassword,state) value(#{userId},#{userName},#{userSex},#{userPassword},#{state})")
    boolean userRegister(String userId,String userName,String userSex,String userPassword,String state);

    @Insert("insert into controller (controllerId,controllerName,controllerPassword,controllerSex,phoneNumber,appointment,state) value(#{controllerId},#{controllerName},#{controllerPassword},#{controllerSex},#{phoneNumber},#{appointment},#{state})")
    boolean controllerRegister(String controllerId,String controllerName,String controllerPassword,String controllerSex,String phoneNumber,String appointment,String state);

    /***普通用户登录***/
    @Select("select * from user where userId = #{userId} and userPassword = #{userPassword} and state='1'")
    User userSignin(String userId, String userPassword);

    /***管理员登录***/
    @Select("select * from controller where controllerId = #{controllerId} and controllerPassword = #{controllerPassword} and state='1'")
    Controller controllerSignin(String controllerId, String controllerPassword);

    /****查询用户是否存在***/
    @Select("select * from user where userId = #{userId}")
    User isUserExist(String userId);

    /***查询管理员是否存在***/
    @Select("select * from controller where controllerId = #{controllerId}")
    Controller isControllerExist(String controllerId);

    /***禁止该用户登录***/
    @Update("update user set state='0' where userId=#{userId}")
    boolean deleteUser(String userId);

    /***禁止该管理员登录***/
    @Update("update controller set state='0' where controllerId=#{controllerId}")
    boolean deleteController(String controllerId);

    /***修改用户信息***/
    @Update("update user set userName=#{userName},userSex=#{userSex},userPassword=#{userPassword} where userId=#{userId} and state='1'")
    User updateUserData(String userId,String userName,String userSex,String userPassword);
}