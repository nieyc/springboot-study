package cn.nyc.study.aopLog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class OtherAspect {

    private Logger logger = LogManager.getLogger(getClass());

    @Pointcut("execution(public * cn.nyc.study.aopLog..*.*(..))")
    public void check(){}

    @Before("check()")
    @Order(10)
    public void doTestOrder(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("http请求 : " + request.getRequestURL().toString());
        logger.info("方法 : " + request.getMethod());
        logger.info("IP地址 : " + request.getRemoteAddr());
        logger.info("类和方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("入参 : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("-------------------测试aop执行顺序-----------------------------------------");

    }

    @AfterReturning(returning = "ret", pointcut = "check()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE IN OTHERASPECT : " + ret);
    }

}
