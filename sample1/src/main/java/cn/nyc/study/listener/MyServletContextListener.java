package cn.nyc.study.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    private Logger logger = LogManager.getLogger(getClass());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("init servletContextListener");
        logger.info("sce.getServletContext().getServerInfo():"+ sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("ServletContex销毁");
    }
}
