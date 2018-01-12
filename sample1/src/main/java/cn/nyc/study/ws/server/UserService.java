package cn.nyc.study.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UserService {

    @WebMethod
    public String getName(@WebParam(name = "userId") Long userId);

    @WebMethod
    public User getUser(long userId);
}
