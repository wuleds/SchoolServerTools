package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 17:06

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.LostFoundDao;
import hjnu.wl.SchoolServerTools.util.GetNowTime;
import hjnu.wl.SchoolServerTools.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**失物招领业务逻辑层*/
@Service
public class LostFoundService
{
    private static LostFoundDao lostFoundDao;
    @Autowired
    private void setLostFoundDao(LostFoundDao lostFoundDao)
    {
        LostFoundService.lostFoundDao = lostFoundDao;
    }

    /**发布失物招领**/
    public String releaseLostFound(String userId,String phoneNumber,String thingName,String thingImageMd5,String thingDescribe)
    {
        try {
            if (phoneNumber.length() != 11)
                return "PhoneNumberLengthError";
            if (thingName.length() < 2 || thingName.length() > 10)
                return "ThingNameLengthError";
            if (thingDescribe.length() < 2 || thingDescribe.length() > 100)
                return "ThingDescribeLengthError";
        }catch (NullPointerException e) {
            e.printStackTrace();
            return "NullPointerException";
        }

        if(lostFoundDao.releaseLostFound(userId,phoneNumber,thingName,thingImageMd5,thingDescribe, GetNowTime.getNowTime(),"1"))
            return "ReleaseSuccess";
        return "ReleaseFail";
    }

    /**查询所有失物招领**/
    public String  getAllLostFound()
    {
        String json = JSON.toJSONString(lostFoundDao.getAllLostFound());
        return json;
    }

    /**根据id查询失物招领**/
    public String getLostFoundById(int lostFoundId)
    {
        String json = JSON.toJSONString(lostFoundDao.getLostFoundById(lostFoundId));
        return json;
    }

    /**根据id删除失物招领**/
    public String deleteLostFoundById(int lostFoundId)
    {
        if(lostFoundDao.deleteLostFoundById(lostFoundId))
            return "DeleteLostFoundSuccess";
        return "DeleteLostFoundFail";
    }
}
