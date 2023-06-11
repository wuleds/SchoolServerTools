package hjnu.wl.SchoolServerTools.util;
//汉江师范学院 数计学院 吴乐创建于2023/6/9 23:28

/**获取文件后缀**/
public class GetFileNameExtension
{
    public static String getFileExtension(String fileName)
    {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < fileName.length() - 1)
        {
            return fileName.substring(dotIndex + 1);
        } else {
            return "";
        }
    }
}