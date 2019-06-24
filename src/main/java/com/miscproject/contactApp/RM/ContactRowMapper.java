package com.miscproject.contactApp.RM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.miscproject.contactApp.Domain.Contact;

public class ContactRowMapper implements RowMapper<Contact>{
    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact c=new Contact();
        c.setContactId(rs.getInt("contactId"));
        c.setUserId(rs.getInt("userId"));
        c.setName(rs.getString("name"));
        c.setEmail(rs.getString("email"));
        c.setAddress(rs.getString("address"));       
        c.setPhoneNo(rs.getString("phone"));       
        c.setRemark(rs.getString("remark"));               
        return c;
    }
    
}