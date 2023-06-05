package hjnu.wl.SchoolServerTools.dao;

import hjnu.wl.SchoolServerTools.model.Controller;
import hjnu.wl.SchoolServerTools.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author wule
 */
@Mapper
public interface SigninDao
{
    @Select("select * from user where userId = #{userId} and userPassword = #{userPassword}")
    User userSignin(String userId, String userPassword);

    @Select("select * from controller where controllerId = #{controllerId} and controllerPassword = #{controllerPassword}")
    Controller controllerSignin(String controllerId, String controllerPassword);
}
