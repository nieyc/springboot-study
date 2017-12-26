package cn.nyc.study.asnyc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test2")
@RestController
public class AsyncTaskController {

    @Autowired
    private AsnycTask asnycTask;

    @RequestMapping("/async")
    public String doTask() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        asnycTask.doTaskOne();
        asnycTask.doTaskTwo();
        asnycTask.doTaskThree();
        long currentTimeMillis1 = System.currentTimeMillis();
        return "task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";

    }
}
