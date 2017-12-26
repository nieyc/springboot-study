package cn.nyc.study.asnyc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TaskTest.class)
@ComponentScan(value="cn.nyc.study")
public class TaskTest {

    @Autowired Task task;

    @Autowired AsnycTask asnycTask;

    //@Test
    public void test() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

   // @Test
    public void testAsnyc() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        asnycTask.doTaskOne();
        asnycTask.doTaskTwo();
        asnycTask.doTaskThree();
        long currentTimeMillis1 = System.currentTimeMillis();
       System.out.println("task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }


    //所有异步任务都完成在执行最后操作
    @Test
    public void testAsnycCallBack() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        Future<String> task4 = asnycTask.doTaskFour();
        Future<String> task5 = asnycTask.doTaskFive();
        Future<String> task6 = asnycTask.doTaskSix();

        while(true) {
            if(task4.isDone() && task5.isDone() && task6.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }
}
