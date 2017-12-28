package cn.nyc.study.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

   // ThreadLocal<Long> startTime = new ThreadLocal<>();
    //private static Long startTime=System.currentTimeMillis();
    static  Long  startTime=0l;
    private Logger logger = LogManager.getLogger(getClass());
    @Override
    public void sessionCreated(HttpSessionEvent se) {
         startTime=System.currentTimeMillis();
       // startTime.set(start);

        logger.info("sessionCreated:"+startTime);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Long endTime=System.currentTimeMillis();
        logger.info("endTime:"+endTime);
        logger.info("session 超时时间总共："+(endTime-startTime));
        logger.info("sessionDestroyed");
    }
}
