package cn.nyc.study.aopLog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 记录执行时间
 */
@Aspect
@Component
public class TimeAspect {

    private Logger logger = LogManager.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * cn.nyc.study.aopLog..*.*(..))")
    public void recordTime(){}

    @Before("recordTime()")
    @Order(10)
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        logger.info("-------------------记录程序执行开始时间-----------------------------------------");

    }

    @AfterReturning(returning = "ret", pointcut = "recordTime()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("执行总时间 : " + (System.currentTimeMillis() - startTime.get())+"毫秒");
        logger.info("RESPONSE IN ZEROASPECT : " + ret);
    }


/*    @Around("recordTime()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("已经记录下操作日志@Around 方法执行前");
        long strartTime=System.currentTimeMillis();
        pjp.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("测试程序执行时间:"+(endTime-strartTime));
        logger.info("已经记录下操作日志@Around 方法执行后");
    }*/
}
