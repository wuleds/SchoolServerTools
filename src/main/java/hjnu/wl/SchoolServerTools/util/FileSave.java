package hjnu.wl.SchoolServerTools.util;
//汉江师范学院 数计学院 吴乐创建于2023/6/10 16:54

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileSave
{
    public static String saveFile(MultipartFile file)
    {
        String fileName = "null";
        String windowsPath = "D:\\MyProgramProjects\\SchoolServerTools\\src\\main\\resources\\teststatic\\file\\";
        String linuxPath = "/home/wule/file/";

        String path = windowsPath;

        try {
            //获取文件名
            fileName = file.getOriginalFilename();
            if (fileName != null)
            {
                System.out.println("处理文件");
                //获取文件后缀
                String fileExtension = GetFileNameExtension.getFileExtension(fileName);
                //将名字变为md5.
                String fileNameMd5 = Md5Util.getMd5(fileName);

                fileName = fileNameMd5 + "." + fileExtension;
                // 保存文件到本地

                file.transferTo(new File( path+ fileName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}