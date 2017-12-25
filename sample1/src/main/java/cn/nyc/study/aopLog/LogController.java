package cn.nyc.study.aopLog;

import org.springframework.web.bind.annotation.*;

/**
 * http://localhost:8080/saveLog?name=nieyc
 * 测试多个aop执行顺序@Before
 * 不同类按照类名首字母顺序执行，执行顺序：OTHERASPECT > TIMEASPECT >WEBLOGASPECT
 * 同一个类按照类名首字母排序，如WebLogAspect 类中的doBefore 和doACheckUserName顺序是 doBefore>doACheckUserName
 *
 * 测试多个aop执行顺序@After,@AfterReturning 执行顺序相反
 *
 *
 *
 *
 */

@RestController
public class LogController {

    @RequestMapping(value = "/saveLog", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello SPRING AOP ? " + name;
    }
}
