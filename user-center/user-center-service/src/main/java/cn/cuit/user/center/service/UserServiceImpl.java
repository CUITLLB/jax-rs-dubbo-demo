package cn.cuit.user.center.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.cuit.user.center.api.UserService;
import cn.cuit.user.center.model.User;

@Service(version = "${user.service.version}", validation = "true", timeout = 5000)
@Component("userService")
public class UserServiceImpl implements UserService {

	@Override
	public User getUserByUsername(String username) {
		User user = new User();
		user.setUsername("userService : CUIT ->" + username);
		user.setPassword("userService : rootllb");
		return user;
	}

	@Override
	public String testCallUserService() {
		return "user-center-service -> testCallUserService has been called";
	}

}
