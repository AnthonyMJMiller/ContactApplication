package com.miscproject.contactApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.miscproject.contactApp.DAO.ContactDAO;
import com.miscproject.contactApp.Domain.Contact;
import com.miscproject.contactApp.RM.ContactRowMapper;
import com.miscproject.contactApp.Utilities.StringUtil;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
    private ContactDAO contactDAO;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(Contact c) {
		contactDAO.save(c);
		
	}

	@Override
	public void update(Contact c) {
		contactDAO.update(c);
		
	}

	@Override
	public void delete(Integer contactId) {
		contactDAO.delete(contactId);
		
	}

	@Override
	public void delete(Integer[] contactIds) {
		String ids = StringUtil.toCommaSeparatedString(contactIds);
        String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
        jdbcTemplate.update(sql);
		
	}

	@Override
    public Contact findById(Integer contactId) {
        return contactDAO.findById(contactId);
    }

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return contactDAO.findByProperty("userId", userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return jdbcTemplate.query(sql, new ContactRowMapper(),userId); 
	}

}
