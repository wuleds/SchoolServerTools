package hjnu.wl.SchoolServerTools.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wule
 */
@Mapper
public interface RegisterDao
{
    /***
     * 注册
     * param userId 账户
     * param userName 用户名
     * param userSex 性别
     * param userPassword 密码
     * return boolean 是否注册成功
     * ***/
    @Insert("insert into user (userId,userName,userSex,userPassword) value(#{userId},#{userName},#{userSex},#{userPassword})")
    public boolean register(String userId,String userName,String userSex,String userPassword);
}
