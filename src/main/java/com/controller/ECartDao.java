package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ECartBean;
import com.bean.ProductBean;

@Repository
public class ECartDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void addToCart(Integer productId,Integer userId)
	{
		ECartBean cart = null;

		try {
			cart = stmt.queryForObject("select * from cart where productId = ? and userId = ? ",
					new BeanPropertyRowMapper<>(ECartBean.class),
					new Object[] { productId, userId });
		} catch (Exception e) {

		}

		if (cart == null) {
			stmt.update("insert into cart (productId,userId,qty) values (?,?,?)", productId,
					userId, 1);
		} else {
			stmt.update("update cart set qty = ? where productId =? and userId = ? ", cart.getQty() + 1,
					cart.getProductId(), cart.getUserId());
		}

	}
	
	public List<ProductBean> myCart(Integer userId)
	{
		List<ProductBean> products = stmt.query("select p.*,c.qty cqty, cartId  from products p join cart c using (productId) where userId= ?", new BeanPropertyRowMapper<>(ProductBean.class),new Object[] {userId});
		
		return products;
	
	}
	
	public void removecartitem(Integer cartId,Integer cqty)
	{
		if(cqty>1)
		{
			stmt.update("update cart set qty = ? where cartId= ?",cqty-1,cartId);
		}
		else {
			stmt.update("delete from cart where cartId = ?",cartId);
		}
		
	}
}
