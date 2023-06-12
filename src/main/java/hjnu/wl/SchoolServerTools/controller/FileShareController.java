package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/8 0:19

import hjnu.wl.SchoolServerTools.domain.FileShare;
import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.service.FileShareService;
import hjnu.wl.SchoolServerTools.util.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@Controller
@RequestMapping("/fileShare")
public class FileShareController
{
    private static FileShareService fileShareService;
    @Autowired
    public void setFileShareService(FileShareService fileShareService)
    {
        FileShareController.fileShareService = fileShareService;
    }

    /**
     * 发布资源
     * 测试通过
     */
    @RequestMapping("/release")
    @ResponseBody
    public String releaseFile(@RequestParam("file") MultipartFile file, @ModelAttribute FileShare fIleShare)
    {
        String sharerId = fIleShare.getSharerId();
        String fileId = "null";
        String notices = fIleShare.getNotices();

        // 处理文件
        if (!file.isEmpty()) {
            fileId = FileSave.saveFile(file);
        }

        return fileShareService.uploadFile(sharerId,fileId,notices);
    }

    /**
     * 查询所有资源
     * 测试通过
     */
    @RequestMapping("/getAll")
    @ResponseBody
    public PostNum getAllFileShare()
    {
        return fileShareService.getAllFileShare();
    }

    /**
     * 分页查询资源
     * 测试通过
     */
    @RequestMapping("/getLimit")
    @ResponseBody
    public PostNum getFileShareByPage(@RequestParam("n") int n,@RequestParam("m") int m)
    {
        return fileShareService.getLimit(n,m);
    }

    /**根据资源信息Id查询文件**/
    @RequestMapping("/getFile")
    @ResponseBody
    public String getFileById(@RequestParam("fileShareId") int fileShareId)
    {
        return fileShareService.getFileIdById(fileShareId);
    }

    /**
     * 根据id查询资源
     * 测试通过
     */
    @RequestMapping("/getFileShareById")
    @ResponseBody
    public PostNum getFileShareById(@RequestParam("fileShareId") int fileShareId)
    {
        return fileShareService.getFileShareById(fileShareId);
    }

    /**
     * 根据id删除资源
     * 测试通过
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteFileShareById(@RequestParam("fileShareId") int fileShareId)
    {
        return fileShareService.deleteFileShare(fileShareId);
    }
}