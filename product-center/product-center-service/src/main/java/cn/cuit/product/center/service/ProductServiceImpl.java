package cn.cuit.product.center.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.cuit.product.center.api.ProductService;
import cn.cuit.product.center.model.Product;

@Component
@Service(version = "${product.service.version}")
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	// @SentinelResource(value = "testSentinel", fallback = "doFallback",
	// blockHandler = "exceptionHandler")
	public Product getProductById(String id) {
		LOG.info("..........id = {}", id);
		Product product = new Product();
		product.setName("CUIT -> " + id);
		product.setPrice(19999);
		return product;
	}

}