package cn.nyc.study.ws.client;


import cn.nyc.study.ws.server.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
public class ClientTest {
	public static void main(String[] args) throws Exception {  
		  
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient("http://localhost:8080/soap/user?wsdl");  
        System.out.println("client:"+client);
        Object[] objects = client.invoke("getUser", 2l);  
        System.out.println("=================="+objects[0].toString());
            Object[] result=client.invoke("getName",22l);
            System.out.println(result[0].toString());

    }  

}
