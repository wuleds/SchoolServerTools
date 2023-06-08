package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 23:03

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.DataShareDao;
import hjnu.wl.SchoolServerTools.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataShareService
{
    private static DataShareDao dataShareDao;
    @Autowired
    public DataShareService(DataShareDao dataShareDao)
    {
        DataShareService.dataShareDao = dataShareDao;
    }

    /**发布信息
     * 测试通过**/
    public String shareData(String sharerId,String title,String content,String imageMd5,String shareTime)
    {
        try{
            if(title.length() < 1 || title.length() > 10)
                return "TitleLengthError";
            if(content.length() < 1 || content.length() > 100)
                return "ContentLengthError";
        }catch (NullPointerException e){
            e.printStackTrace();
            return "NullPointerException";
        }

        if(dataShareDao.shareData(sharerId,title,content,imageMd5,shareTime,"1"))
            return "DataShareSuccess";

        return "DataShareFail";
    }

    /**获取所有信息
     * 测试通过**/
    public String getAllDataShare()
    {
        String json = JSON.toJSONString(dataShareDao.getAllDataShare());
        return json;
    }

    /**根据id获取信息
     * 测试通过**/
    public String getDataShareById(int dataShareId)
    {
        String json = JSON.toJSONString(dataShareDao.getDataShareById(dataShareId));
        return json;
    }

    /**根据id删除信息
     * 测试通过**/
    public String deleteDataShareById(int dataShareId)
    {
        if(dataShareDao.deleteDataShareById(dataShareId))
            return "DeleteDataShareSuccess";
        return "DeleteDataShareFail";
    }


}
