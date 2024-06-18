package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomUserBean;


@Repository
public class EUserDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void insertUser(EcomUserBean euserbean)
	{
		stmt.update("insert into ecomuser(firstName,email,password) value (?,?,?)",euserbean.getFname(),euserbean.getEmail(),euserbean.getPwd());
	}
	
}
