package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/12 17:28

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@RequestMapping("/download")
@CrossOrigin
@Controller
public class DownloadFileController
{
    /**根据编号下载,建立文件输出流*/
    @RequestMapping("/{imageName}")
    public void downloadImg (@PathVariable String imageName, HttpServletResponse response)
    {
        //windows
        String path = "D:\\MyProgramProjects\\SchoolServerTools\\src\\main\\resources\\teststatic\\file";

        //linux
        //String path = "/home/wule/file";

        String targetFile = path + "/" + imageName;

        File file = new File(targetFile);
        byte[] bytes = new byte[1024];

        OutputStream outputStream;
        FileInputStream fileInputStream;
        try
        {
            outputStream = response.getOutputStream();
            fileInputStream = new FileInputStream(file);

            while ((fileInputStream.read(bytes)) != -1)
            {
                //向网页的流写入数据
                outputStream.write(bytes);
                outputStream.flush();
            }
            //关闭流
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}