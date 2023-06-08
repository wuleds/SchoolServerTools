package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 20:17

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.SchoolEmployDao;
import hjnu.wl.SchoolServerTools.util.GetNowTime;
import hjnu.wl.SchoolServerTools.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**学校招聘业务逻辑层*/
@Service
public class SchoolEmployService
{
    private static SchoolEmployDao schoolEmployDao;
    @Autowired
    private void setSchoolEmployService(SchoolEmployDao schoolEmployDao)
    {
        SchoolEmployService.schoolEmployDao = schoolEmployDao;
    }

    /**发布学校招聘信息*/
    public String releaseSchoolEmploy(String hrName,String hrPhoneNumber,String imageMd5,String companyName,String jobName,String salary,String jobPower,String jobContent,String jobNotices)
    {
        try{
            if (hrName.length() < 2 || hrName.length() > 10)
                return "hrNameLengthError";
            if(hrPhoneNumber.length() != 11)
                return "hrPhoneNumberLengthError";
            if(companyName.length() < 2 || companyName.length() > 20)
                return "companyNameLengthError";
            if(salary.length() < 2 || salary.length() > 10)
                return "salaryLengthError";
            if(jobName.length() < 2 || jobName.length() > 10)
                return "jobNameLengthError";
            if(jobPower.length() < 2 || jobPower.length() > 100)
                return "jobPowerLengthError";
            if(jobContent.length() < 2 || jobContent.length() > 100)
                return "jobContentLengthError";
            if(jobNotices.length() < 2 || jobNotices.length() > 100)
                return "jobNoticesLengthError";
        }catch (NullPointerException e){
            e.printStackTrace();
            return "NullPointException";
        }

        if(schoolEmployDao.releaseSchoolEmploy(hrName,hrPhoneNumber,imageMd5,companyName,jobName,salary,jobPower,jobContent,jobNotices,GetNowTime.getNowTime(),"1"))
            return "releaseSuccess";

        return "releaseFail";
    }

    /**根据id学校招聘信息*/
    public String getSchoolEmployById(int schoolEmployId)
    {
        String json = JSON.toJSONString(schoolEmployDao.getSchoolEmployById(schoolEmployId));
        return json;
    }

    /**删除学校招聘信息*/
    public String deleteSchoolEmploy(int schoolEmployId)
    {
        if(schoolEmployDao.deleteSchoolEmploy(schoolEmployId))
            return "deleteSuccess";
        return "deleteFail";
    }

    /**获取所有的学校招聘信息*/
    public String getAllSchoolEmploy()
    {
        String json = JSON.toJSONString(schoolEmployDao.getAllSchoolEmploy());
        return json;
    }
}
