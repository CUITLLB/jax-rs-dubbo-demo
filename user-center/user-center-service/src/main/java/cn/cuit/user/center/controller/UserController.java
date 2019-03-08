package cn.cuit.user.center.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import cn.cuit.user.center.api.UserService;
import cn.cuit.user.center.model.User;

@Service
@Path("/api/users")
@Consumes({ MediaType.APPLICATION_JSON_UTF8_VALUE })
@Produces({ MediaType.APPLICATION_JSON_UTF8_VALUE })
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	// @GetMapping(value = "/getUserByUsername/{username}")
	@GET
	@Path("/getUserByUsername/{username}")
	// 这里的路径参数使用Spring的@PathVariable获取不到，要使用下面这个注解
	public User getUserByUsername(@PathParam(value = "username") String username) {
		LOG.info("username = {}", username);
		return userService.getUserByUsername(username);
	}

	@GET
	@Path("/testCallUserService")
	public String testCallUserService() {
		return userService.testCallUserService();
	}
}
