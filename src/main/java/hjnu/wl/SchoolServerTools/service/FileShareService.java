package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 23:57

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.FileShareDao;
import hjnu.wl.SchoolServerTools.util.GetNowTime;
import hjnu.wl.SchoolServerTools.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if(fileShareDao.uploadFile(sharerId,fileIdMd5,notices, GetNowTime.getNowTime(),"1"))
        {
            return "FileShareSuccess";
        }

        return "FileShareFail";
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
    public String getAllFileShare()
    {
        String json = JSON.toJSONString(fileShareDao.getAllFileShare());
        return json;
    }

    /**
     * 根据资源id查看资源分享
     * 测试通过
     */
    public String getFileShareById(int fileShareId)
    {
        String json = JSON.toJSONString(fileShareDao.getFileShareById(fileShareId));
        return json;
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