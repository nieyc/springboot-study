package cn.nyc.study.ws.server;

import javax.jws.WebService;

@WebService(targetNamespace = "http://server.ws.study.nyc.cn/", serviceName="UserService",endpointInterface = "cn.nyc.study.ws.server.UserService")
public class UserServiceImpl implements UserService {
    @Override
    public String getName(Long userId) {
        return "xiaogao" + userId;
    }

    @Override
    public User getUser(long userId) {
        User user = new User();
        user.setUserId(2l);
        user.setUsername("gaoyi");
        user.setEmail("315319976@qq.com");
        return user;
    }
}
