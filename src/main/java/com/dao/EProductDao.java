package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public class EProductDao {

	
	@Autowired
	JdbcTemplate stmt;
	
	public void addProduct(ProductBean pbean)
	{
		stmt.update("insert into products(productName,category,qty,price) values (?,?,?,?)",pbean.getPname(),pbean.getCategory(),pbean.getQty(),pbean.getPrice());
	}
}
