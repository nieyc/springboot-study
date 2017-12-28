package cn.nyc.study.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName="myFilter",urlPatterns="/*")
public class MyFilter implements Filter {

    private Logger logger = LogManager.getLogger(getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("filter is running");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        logger.info("filter destroy");
    }
}
