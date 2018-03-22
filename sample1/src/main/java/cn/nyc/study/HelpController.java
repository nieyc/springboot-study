package cn.nyc.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:35 2018/3/22
 * @Description
 **/
@RestController
public class HelpController {
    @RequestMapping("/lyw")
    public String index() {
        return "Hello World";
    }
}
