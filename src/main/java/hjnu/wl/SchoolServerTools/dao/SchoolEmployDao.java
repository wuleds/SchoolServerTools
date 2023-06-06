package hjnu.wl.SchoolServerTools.dao;
//汉江师范学院 数计学院 吴乐创建于2023/6/6 23:35

import hjnu.wl.SchoolServerTools.model.SchoolEmploy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

/***
 * 校园招聘信息
 */
@Mapper
public interface SchoolEmployDao
{
    /***
     * 发布校园招聘信息
     */
    @Insert("insert into schoolEmploy(hrName,hrPhoneNumber,image,companyName,jobName,salary,jobPower,jobContent,jobNotices,releaseTime,state) values(#{hrName},#{hrPhoneNumber},#{image},#{companyName},#{jobName},#{salary},#{jobPower},#{jobContent},#{jobNotices},#{releaseTime},#{state})")
    boolean releaseSchoolEmploy(String hrName,String hrPhoneNumber,String image,String companyName,String jobName,String salary,String jobPower,String jobContent,String jobNotices,String releaseTime,String state);

    /***
     * 查询所有校园招聘信息
     */
    @Select("select * from schoolEmploy where state='1' order by releaseTime")
    ArrayList<SchoolEmploy> getAllSchoolEmploy();

    /***
     * 根据id查询校园招聘信息
     */
    @Select("select * from schoolEmploy where schoolEmployId=#{schoolEmployId} and state='1'")
    SchoolEmploy getSchoolEmployById(int schoolEmployId);

    /***
     * 删除招聘信息
     */
    @Update("update schoolEmploy set state='0' where schoolEmployId=#{schoolEmployId}")
    boolean deleteSchoolEmploy(int schoolEmployId);
}
