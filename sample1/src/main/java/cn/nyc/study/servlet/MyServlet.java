package cn.nyc.study.servlet;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet implements Servlet {

    //private Logger logger =LogManager.getLogger(getClass());




    @Override
    public void init(ServletConfig config) throws ServletException {
        //logger.info("myservlet is init ................");
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("do it ,i will kkk lyw");
        String message="hello,servlet";
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        writer.write("<h1>" + message + "</h1>");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory it");
    }
}
