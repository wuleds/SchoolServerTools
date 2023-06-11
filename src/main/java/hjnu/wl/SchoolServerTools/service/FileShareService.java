package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 23:57

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.FileShareDao;
import hjnu.wl.SchoolServerTools.domain.FileShare;
import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.util.GetNowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 资源分享
 */
@Service
public class FileShareService
{
    private static FileShareDao fileShareDao;
    @Autowired
    public void setFileShareDao(FileShareDao fileShareDao)
    {
        FileShareService.fileShareDao = fileShareDao;
    }

    /**
     * 发布资源
     * 测试通过
     */
    public String uploadFile(String sharerId,String fileIdMd5,String notices)
    {
        try{
            if(notices.length() < 1 || notices.length() > 100)
            {
                return "NoticesLengthError";
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            return "NoticesLengthError";
        }
        if(fileShareDao.uploadFile(sharerId,fileIdMd5,notices,GetNowTime.getNowTime(),"1"))
        {
            return "FileShareSuccess";
        }
        return "FileShareFail";
    }

    /**
     * 分页获取资源分享
     * 测试通过
     */
    public PostNum getLimit(int n, int m)
    {
        ArrayList<FileShare> list = fileShareDao.getLimit(n,m);
        String json = JSON.toJSONString(list);
        PostNum postNum = new PostNum(list.size(),json);
        return postNum;
    }

    /**
     * 获取资源分享总数
     * 测试通过
     */
    public int getCount()
    {
        return fileShareDao.getCount();
    }

    /**
     * 根据资源id获取文件编号
     * 测试通过
     */
    public String getFileIdById(int fileShareId)
    {
        return fileShareDao.getFileIdById(fileShareId);
    }

    /**
     * 获取所有资源分享
     * 测试通过
     */
    public PostNum getAllFileShare()
    {
        ArrayList<FileShare> list = fileShareDao.getAllFileShare();
        String json = JSON.toJSONString(list);
        PostNum postNum = new PostNum(list.size(),json);
        return postNum;
    }

    /**
     * 根据资源id查看资源分享
     * 测试通过
     */
    public PostNum getFileShareById(int fileShareId)
    {
        FileShare fIleShare = fileShareDao.getFileShareById(fileShareId);
        String json = JSON.toJSONString(fIleShare);
        PostNum postNum = new PostNum("null".equals(json)?0:1,json);
        return postNum;
    }

    /**
     * 根据资源id删除资源分享
     * 测试通过
     */
    public String deleteFileShare(int fileShareId)
    {
        if(fileShareDao.deleteFileShare(fileShareId))
        {
            return "DeleteFileShareSuccess";
        }
        return "DeleteFileShareFail";
    }
}