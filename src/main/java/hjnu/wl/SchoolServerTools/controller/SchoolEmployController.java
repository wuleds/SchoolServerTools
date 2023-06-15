package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/8 0:20

import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.domain.SchoolEmploy;
import hjnu.wl.SchoolServerTools.service.SchoolEmployService;
import hjnu.wl.SchoolServerTools.util.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**校园招聘**/
@CrossOrigin
@Controller
@RequestMapping("/schoolEmploy")
public class SchoolEmployController
{
    private static SchoolEmployService schoolEmployService;
    @Autowired
    private void setSchoolEmployService(SchoolEmployService schoolEmployService)
    {
        SchoolEmployController.schoolEmployService = schoolEmployService;
    }

    /**发布学校招聘信息**/
    @RequestMapping("/release")
    @ResponseBody
    public String releaseSchoolEmploy(@RequestParam("file") MultipartFile file, @ModelAttribute SchoolEmploy schoolEmploy)
    {
        String hrName = schoolEmploy.getHrName();                 //hr的名字
        String hrPhoneNumber = schoolEmploy.getHrPhoneNumber();   //联系电话
        String image = "null";                                    //图片
        String companyName = schoolEmploy.getCompanyName();       //公司名称
        String jobName = schoolEmploy.getJobName();                //工作岗位
        String salary = schoolEmploy.getSalary();                  //工资
        String jobPower = schoolEmploy.getJobPower();              //工作能力要求
        String jobContent = schoolEmploy.getJobContent();           //工作内容
        String jobNotices = schoolEmploy.getJobNotices();           //备注

        // 处理文件
        if (!file.isEmpty()) {
            image = FileSave.saveFile(file);
        }
        return schoolEmployService.releaseSchoolEmploy(hrName,hrPhoneNumber,image,companyName,jobName,salary,jobPower,jobContent,jobNotices);
    }

    /**获取所有招聘**/
    @RequestMapping("/getAll")
    @ResponseBody
    public ArrayList<SchoolEmploy> getAllEmploy()
    {
        return schoolEmployService.getAllSchoolEmploy();
    }

    /**分页查询**/
    @RequestMapping("/getLimit")
    @ResponseBody
    public PostNum getEmployByPage(@RequestParam("n") int n,@RequestParam("m") int m)
    {
        return schoolEmployService.getLimit(n,m);
    }

    /**查询招聘信息总数**/
    @RequestMapping("/getCount")
    @ResponseBody
    public int getCount()
    {
        return schoolEmployService.getCount();
    }

    /**根据id获取招聘**/
    @RequestMapping("/getById")
    @ResponseBody
    public PostNum getEmployById(@RequestParam("schoolEmployId") int schoolEmployId)
    {
        return schoolEmployService.getSchoolEmployById(schoolEmployId);
    }

    /**根据id删除招聘**/
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteEmployById(@RequestParam("schoolEmployId") int schoolEmployId)
    {
        return schoolEmployService.deleteSchoolEmploy(schoolEmployId);
    }
}