package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomUserBean;
import com.bean.UserBean;


@Repository
public class EUserDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void insertUser(EcomUserBean euserbean)
	{
		stmt.update("insert into ecomuser(firstName,email,password,masterpath) value (?,?,?,?)",euserbean.getFirstName(),euserbean.getEmail(),euserbean.getPassword(),euserbean.getMasterpath());
	}
	
	public EcomUserBean authenticate(String email, String password) {
		// select * from users where email = ? and password = ?
		try {
			EcomUserBean userBean = stmt.queryForObject("select * from ecomuser where email = ? and password = ?", new BeanPropertyRowMapper<>(EcomUserBean.class),new Object[] {email,password});
			return userBean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;// invalid
	}

	
}
