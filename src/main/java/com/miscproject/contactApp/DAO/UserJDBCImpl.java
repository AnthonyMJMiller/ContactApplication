package com.miscproject.contactApp.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.miscproject.contactApp.Domain.User;
import com.miscproject.contactApp.RM.UserRowMapper;

public class UserJDBCImpl implements UserDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public void save(User u) {
		String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
                + " VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhoneNo());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("loginName", u.getLoginName());
        m.put("password", u.getPassword());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginState());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        jdbcTemplate.update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setUserId(userId);
		
	}

	@Override
	public void update(User u) {
		String sql = "UPDATE user "
                + " SET name=:name,"
                + " phone=:phone, "
                + " email=:email,"
                + " address=:address,"
                + " role=:role,"
                + " loginStatus=:loginStatus "
                + " WHERE userId=:userId";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhoneNo());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());       
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginState());
        m.put("userId", u.getUserId());
        jdbcTemplate.update(sql, m);
		
	}

	@Override
	public void delete(User u) {
		this.delete(u.getUserId());
		
	}

	@Override
	public void delete(Integer userId) {
		String sql="DELETE FROM user WHERE userId=?";
        jdbcTemplate.update(sql, userId);
		
	}

	@Override
	public User findById(Integer userId) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE userId=?";
//        User u = 
        return (User) jdbcTemplate.queryForObject(sql, new UserRowMapper(),userId);
	}

	@Override
	public List<User> findAll() {
		 String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
	                + " FROM user";
	          
	           return jdbcTemplate.query(sql, new UserRowMapper());
	}

	@Override
	public List<User> findByProperty(String propName, Object propValue) {
		 String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
	                + " FROM user WHERE "+propName+"=?";
	         return jdbcTemplate.query(sql, new UserRowMapper(), propValue);
	}

}
