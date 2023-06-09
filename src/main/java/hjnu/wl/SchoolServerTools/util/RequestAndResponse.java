package hjnu.wl.SchoolServerTools.util;
//汉江师范学院 数计学院 吴乐创建于2023/6/9 17:31

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class RequestAndResponse
{
    public static HttpServletRequest getRequest()
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            request = attributes.getRequest();
        }
        return  request;
    }

    public static HttpServletResponse getResponse()
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = null;
        if(attributes != null)
        {
            response = attributes.getResponse();
        }
        return response;
    }
}