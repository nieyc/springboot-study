package cn.nyc.study.ws;


import cn.nyc.study.ws.server.User;
import cn.nyc.study.ws.server.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 服务端和客户端在一起的时候测试，如果单独客户端调用还是需要在客户度生成代理代码
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientTest.class)
public class ClientTest {

   // @Test
    public void test1() throws Exception{
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient("http://localhost:8080/soap/user?wsdl");
        System.out.println("client:"+client);
        Object[] objects = client.invoke("getUser", 2l);
        System.out.println("=================="+objects[0].toString());
        Object[] result=client.invoke("getName",22l);
        System.out.println(result[0].toString());
    }

    @Test
    public void test2(){
        JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
        svr.setServiceClass(UserService.class);
        svr.setAddress("http://localhost:8080/soap/user?wsdl");
        UserService userService=(UserService)svr.create();
        String userName=  userService.getName(22l);
        System.out.println("userName:"+userName);
        User user=  userService.getUser(1l);
        System.out.println(user.getEmail());
    }
}
