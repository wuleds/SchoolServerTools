package hjnu.wl.SchoolServerTools.dao;

import hjnu.wl.SchoolServerTools.model.DataShare;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * 信息分享
 */
@Mapper
public interface DataShareDao
{
    /**发布信息**/
    @Insert("insert into dataShare(sharerId,title,content,image,shareTime,state) values(#{sharerId},#{title},#{content},#{image},#{shareTime},#{state})")
    boolean shareData(String sharerId,String title,String content,String image,String shareTime,String state);

    /**获取所有信息**/
    @Select("select * from dataShare where state = '1'")
    ArrayList<DataShare> getAllDataShare();

    /**根据id获取信息**/
    @Select("select * from dataShare where dataShareId = #{dataShareId} and state = '1'")
    DataShare getDataShareById(int dataShareId);

    /**根据id删除信息**/
    @Update("update dataShare set state = '0' where dataShareId = #{dataShareId}")
    boolean deleteDataShareById(int dataShareId);
}
