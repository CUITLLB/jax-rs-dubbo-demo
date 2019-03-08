package cn.cuit.product.center.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.cuit.product.center.api.ProductService;
import cn.cuit.product.center.model.Product;
import cn.cuit.user.center.api.UserService;
import cn.cuit.user.center.model.User;

/**
 * 总结：
 * 
 * 使用javax.ws.rs包实现RestFul的类，他和Spring的不能混用，只能用它提供的
 * 
 * @RestController @RequestMapping @PathVariable这些Spring的注解等貌似不好使
 *                 在方法上使用@RequestMapping映射请求的url访问不了【类上面的Spring注解 @Service， @Controller， @RestController， @Component都是可以的
 *                 他们都是语义区别上的@Component，可以看他们的源码都是被@Component注解修饰的】
 * 
 *                 maven clean后一定要执行maven install, 否则启动说找不到启动类
 * 
 *                 由于使用了Jrebel热部署，但是如果修改了代码发现不好使了，重启试试
 * 
 *                 两个service之间不能相互依赖，会报错，可以看下面的Problems视图有提示
 * 
 *                 可以结合IDEA 的zookeeper视图查看注册的服务
 * 
 */
// @Service
@RestController
@Path("/api/products")
@Consumes({ MediaType.APPLICATION_JSON_UTF8_VALUE })
@Produces({ MediaType.APPLICATION_JSON_UTF8_VALUE })
public class ProductController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	// 这种写法感觉不太好维护，因为可能代码里面到处都是，还是统一在xml文件中写感觉比较好
	@Reference(url = "dubbo://127.0.0.1:20880", interfaceName = "cn.cuit.user.center.api.UserService", version = "1.0")
	private UserService userService;

	@GET
	@Path("/{id:[a-zA-Z0-9]+}")
	public Product getProductById(@PathParam("id") String id) {
		LOG.info(">>>>>>>>>>id = {}", id);
		return productService.getProductById(id);
	}

	// 请求路径为：localhost:8081/product/api/products/testCallUserService
	@GET
	@Path("/testCallUserService")
	public String testCallUserService() {
		return userService.testCallUserService();
	}

	@GET
	@Path("/getUserByUsername/{username}")
	public User getUserByUsername(@PathParam("username") String username) {
		return userService.getUserByUsername(username);
	}
}
