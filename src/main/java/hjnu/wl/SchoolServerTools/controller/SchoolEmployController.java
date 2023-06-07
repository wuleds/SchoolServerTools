package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/8 0:20

import hjnu.wl.SchoolServerTools.model.SchoolEmploy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/schoolEmploy")
public class SchoolEmployController
{
    @RequestMapping("/release")
    @ResponseBody
    public String releaseSchoolEmploy(SchoolEmploy schoolEmploy)
    {
        return "ReleaseSchoolEmployFail";
    }

}
