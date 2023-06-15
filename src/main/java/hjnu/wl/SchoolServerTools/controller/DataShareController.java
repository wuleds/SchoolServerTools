package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/8 0:19

import hjnu.wl.SchoolServerTools.domain.DataShare;
import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.service.DataShareService;
import hjnu.wl.SchoolServerTools.util.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**信息分享**/
@CrossOrigin
@Controller
@RequestMapping("/dataShare")
public class DataShareController
{
    private static DataShareService dataShareService;
    @Autowired
    private void setDataShareService(DataShareService dataShareService)
    {
        DataShareController.dataShareService = dataShareService;
    }

    /**发布信息分享**/
    @RequestMapping("/release")
    @ResponseBody
    public String publishDataShare(@RequestParam("file") MultipartFile file, @ModelAttribute DataShare dataShare)
    {
        String sharerId = dataShare.getSharerId();                     //信息分享者的id
        String dataShareTitle = dataShare.getTitle();                 //信息分享的标题
        String dataShareContent = dataShare.getContent();             //信息分享的内容
        String image = "null";                                         //图片

        // 处理文件
        if (!file.isEmpty()) {
            image = FileSave.saveFile(file);
        }

        return dataShareService.shareData(sharerId,dataShareTitle,dataShareContent,image);
    }

    /**获取所有的信息分享**/
    @RequestMapping("/getAll")
    @ResponseBody
    public ArrayList<DataShare> getAllDataShare()
    {
        return dataShareService.getAllDataShare();
    }

    /**分页查询**/
    @RequestMapping("/getLimit")
    public PostNum getLimit(@RequestParam("n") int n, @RequestParam("m") int m)
    {
        return dataShareService.getLimit(n,m);
    }

    /**获取信息总数**/
    @RequestMapping("/getCount")
    public int getCount()
    {
        return dataShareService.getCount();
    }

    /**根据Id获取一个信息分享**/
    @RequestMapping("/getById")
    public String getOneDataShare(@RequestParam("dataShareId") int dataShareId)
    {
        return dataShareService.getDataShareById(dataShareId);
    }

    /**删除信息分享**/
    @RequestMapping("/deleteById")
    public String deleteOneDataShare(@RequestParam("dataShareId") int dataShareId)
    {
        return dataShareService.deleteDataShareById(dataShareId);
    }
}