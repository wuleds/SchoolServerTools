package hjnu.wl.SchoolServerTools.dao;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 23:47

import hjnu.wl.SchoolServerTools.model.FIleShare;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * 资源分享
 */
@Mapper
public interface FileShareDao
{
    /**
     * 发布资源
     */
    @Insert("insert into fileShare (sharerId,fileId,notices,shareTime,state) values (#{sharerId},#{fileId},#{notices},#{shareTime},#{state})")
    boolean uploadFile(String sharerId,String fileId,String notices,String shareTime,String state);

    /**
     * 根据资源id获取文件编号
     */
    @Select("select fileId from fileShare where fileShareId=#{fileShareId} and state='1'")
    String getFileIdById(int fileShareId);

    /**
     * 获取所有资源分享
     */
    @Select("select * from fileShare where state='1'")
    ArrayList<FIleShare> getAllFileShare();

    /**
     * 根据资源id查看资源分享
     */
    @Select("select * from fileShare where fileShareId=#{fileShareId} and state='1'")
    FIleShare getFileShareById(int fileShareId);

    /**
     * 根据资源id删除资源分享
     */
    @Update("update fileShare set state='0' where fileShareId=#{fileShareId}")
    boolean deleteFileShare(int fileShareId);
}