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
import org.springframework.stereotype.Repository;

import com.miscproject.contactApp.Domain.Contact;
import com.miscproject.contactApp.RM.ContactRowMapper;

@Repository
public class ContactJDBCImpl implements ContactDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(Contact c) {
		 String sql = "INSERT INTO contact(userId, name, phone, email, address, remark) VALUES(:userId, :name, :phone, :email, :address, :remark)";
	        Map m = new HashMap();
	        m.put("userId", c.getUserId());
	        m.put("name", c.getName());
	        m.put("phone", c.getPhoneNo());
	        m.put("email", c.getEmail());
	        m.put("address", c.getAddress());
	        m.put("remark", c.getRemark());
	        SqlParameterSource ps = new MapSqlParameterSource(m);
	        KeyHolder kh = new GeneratedKeyHolder();
	        jdbcTemplate.update(sql, ps, kh);
	        c.setContactId(kh.getKey().intValue());
		
	}

	@Override
	public void update(Contact c) {
		 String sql = "UPDATE contact SET name=:name, phone=:phone, email=:email, address=:address, remark=:remark WHERE contactId=:contactId";
	        Map m = new HashMap();
	        m.put("contactId", c.getContactId());
	        m.put("name", c.getName());
	        m.put("phone", c.getPhoneNo());
	        m.put("email", c.getEmail());
	        m.put("address", c.getAddress());
	        m.put("remark", c.getRemark());
	        jdbcTemplate.update(sql, m);
		
	}

	@Override
	public void delete(Contact c) {
		this.delete(c.getContactId());
		
	}

	@Override
	public void delete(Integer contactId) {
		String sql = "DELETE FROM contact WHERE contactId=?";
        jdbcTemplate.update(sql, contactId);
		
	}

	@Override
	public Contact findById(Integer contactId) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE contactId=?";
        return jdbcTemplate.queryForObject(sql, new ContactRowMapper(), contactId);
	}

	@Override
	public List<Contact> findAll() {
		 String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact";
	        return jdbcTemplate.query(sql, new ContactRowMapper());
	}

	@Override
	public List<Contact> findByProperty(String propName, Object propValue) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE "+propName+"=?";
        return jdbcTemplate.query(sql, new ContactRowMapper(), propValue);
	}

}
