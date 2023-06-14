package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/8 0:19

import hjnu.wl.SchoolServerTools.domain.LostFound;
import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.service.LostFoundService;
import hjnu.wl.SchoolServerTools.util.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@CrossOrigin
@Controller
@RequestMapping("/lostFound")
public class LostFoundController
{
    private static LostFoundService lostFoundService;
    @Autowired
    public void setLostFoundService(LostFoundService lostFoundService)
    {
        LostFoundController.lostFoundService = lostFoundService;
    }

    /**
     * 发布失物招领
     * 测试通过
     */
    @RequestMapping("/release")
    @ResponseBody
    public String releaseLostFound(@RequestParam("file") MultipartFile file, @ModelAttribute LostFound lostFound)
    {
        String userId = lostFound.getUserId();
        String phoneNumber = lostFound.getPhoneNumber();
        String thingName = lostFound.getThingName();
        String describe = lostFound.getThingDescribe();
        String image = "null";

        // 处理文件
        if (!file.isEmpty()) {
            image = FileSave.saveFile(file);
        }

        return lostFoundService.releaseLostFound(userId,phoneNumber,thingName,image,describe);
    }

    /**
     * 查询所有失物招领
     * 测试通过
     */
    @RequestMapping("/getAll")
    @ResponseBody
    public ArrayList<LostFound> getAllLostFound()
    {
        System.out.println("getAllLostFound");
        return lostFoundService.getAllLostFound();
    }

    /**
     * 分页查询失物招领
     * 测试通过
     */
    @RequestMapping("/getLimit")
    @ResponseBody
    public PostNum getLostFoundByPage(@RequestParam("n") int n,@RequestParam("m") int m)
    {
        return lostFoundService.getLimit(n,m);
    }

    /**
     * 根据id查询失物招领
     * 测试通过
     */
    @RequestMapping("/getById")
    @ResponseBody
    public PostNum getLostFoundById(@RequestParam("lostFoundId") int lostFoundId)
    {
        return lostFoundService.getLostFoundById(lostFoundId);
    }

    /**查询总数**/
    @RequestMapping("/getCount")
    @ResponseBody
    public int getCount()
    {
        return lostFoundService.getLostFoundCount();
    }

    /**
     * 根据id删除失物招领
     * 测试通过
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteLostFoundById(@RequestParam("lostFoundId") int lostFoundId)
    {
        return lostFoundService.deleteLostFoundById(lostFoundId);
    }
}