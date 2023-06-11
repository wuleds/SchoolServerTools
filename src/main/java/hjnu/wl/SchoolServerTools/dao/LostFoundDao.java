package hjnu.wl.SchoolServerTools.dao;
//汉江师范学院 数计学院 吴乐创建于2023/6/6 22:40

import hjnu.wl.SchoolServerTools.domain.LostFound;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.ArrayList;

/***
 * 失物招领
 * @author wule
 */
@Mapper
public interface LostFoundDao
{
    /***
     * 发布失物招领
     * 测试通过
     */
    @Insert("insert into lostFound(userId,phoneNumber,thingName,thingImage,thingDescribe,releaseTime,state) values(#{userId},#{phoneNumber},#{thingName},#{thingImage},#{thingDescribe},#{releaseTime},#{state})")
    boolean releaseLostFound(String userId,String phoneNumber,String thingName,String thingImage,String thingDescribe,String releaseTime,String state);

    /***
     * 查询所有失物招领信息
     * 测试通过
     */
    @Select("select * from lostFound where state='1' order by releaseTime")
    ArrayList<LostFound> getAllLostFound();

    /***
     * 根据id查询失物招领信息
     * 测试通过
     */
    @Select("select * from lostFound where lostFoundId=#{lostFoundId} and state='1'")
    LostFound getLostFoundById(int lostFoundId);

    /***
     * 根据id删除失物招领信息
     * 测试通过
     */
    @Update("update lostFound set state='0' where lostFoundId=#{lostFoundId}")
    boolean deleteLostFoundById(int lostFoundId);
}
