package cn.nyc.study.listener;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/time")
public class MaxSessionController {

    @RequestMapping("/getTime")
    @ResponseBody
    public String getMaxSessionTime(HttpServletRequest request) {
         request.getSession().setAttribute("flag","oo");
         int time=request.getSession().getMaxInactiveInterval();
         System.out.println("获取session 超时时间："+time);
         return String.valueOf(time);

    }


}
