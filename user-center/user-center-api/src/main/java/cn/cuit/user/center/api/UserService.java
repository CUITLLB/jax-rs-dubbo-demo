package cn.cuit.user.center.api;

import cn.cuit.user.center.model.User;

public interface UserService {
	User getUserByUsername(String username);

	String testCallUserService();
}