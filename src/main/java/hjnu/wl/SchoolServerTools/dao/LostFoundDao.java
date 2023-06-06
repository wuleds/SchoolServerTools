package hjnu.wl.SchoolServerTools.dao;
//汉江师范学院 数计学院 吴乐创建于2023/6/6 22:40

import hjnu.wl.SchoolServerTools.model.LostFound;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.ArrayList;

/***失物招领
 * @author wule***/
@Mapper
public interface LostFoundDao
{
    /***
     * 发布失物招领
     */
    @Insert("insert into lostFound(userId,phoneNumber,thingName,thingImage,thingDescribe,releaseTime,state) values(#{userId},#{phoneNumber},#{thingName},#{thingImage},#{thingDescribe},#{releaseTime},#{state})")
    boolean releaseLostFound(String userId,String phoneNumber,String thingName,String thingImage,String thingDescribe,String releaseTime,String state);

    /***
     * 查询所有失物招领信息
     */
    @Select("select * from lostFound where state='1' order by releaseTime")
    ArrayList<LostFound> getAllLostFound();

    /***
     * 根据id查询失物招领信息
     */
    @Select("select * from lostFound where lostFoundId=#{lostFoundId} and state='1'")
    LostFound getLostFoundById(int lostFoundId);
}
