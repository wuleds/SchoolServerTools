package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 23:03

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.DataShareDao;
import hjnu.wl.SchoolServerTools.domain.DataShare;
import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.util.GetNowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    public String shareData(String sharerId,String title,String content,String imageMd5)
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

        if(dataShareDao.shareData(sharerId,title,content,imageMd5, GetNowTime.getNowTime(),"1"))
            return "DataShareSuccess";

        return "DataShareFail";
    }

    /**获取所有信息
     * 测试通过**/
    public ArrayList<DataShare> getAllDataShare()
    {
        return dataShareDao.getAllDataShare();
    }

    /**分页查询
     * 测试通过**/
    public PostNum getLimit(int n, int m)
    {
        ArrayList<DataShare> list = dataShareDao.getLimit(n,m);
        String json = JSON.toJSONString(list);
        PostNum postNum = new PostNum(list.size(),json);
        return postNum;
    }

    /**获取信息总数
     * 测试通过**/
    public int getCount()
    {
        return dataShareDao.getCount();
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
