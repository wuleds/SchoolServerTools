package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/8 0:20

import hjnu.wl.SchoolServerTools.model.SchoolEmploy;
import hjnu.wl.SchoolServerTools.service.SchoolEmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/release")
    @ResponseBody
    public String releaseSchoolEmploy(SchoolEmploy schoolEmploy)
    {
        return "ReleaseSchoolEmployFail";
    }

}
