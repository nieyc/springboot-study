package cn.nyc.study.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyStartupRunner implements CommandLineRunner {

    private Logger logger = LogManager.getLogger(getClass());
    @Override
    public void run(String... args) throws Exception {
        logger.info("启动初始化加载");
    }
}
