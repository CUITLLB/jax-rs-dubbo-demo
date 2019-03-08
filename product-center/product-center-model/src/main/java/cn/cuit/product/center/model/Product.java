package cn.cuit.product.center.model;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 2547456019658847542L;

	private String name;

	private Integer price;

	public Product() {
	}

	public Product(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
