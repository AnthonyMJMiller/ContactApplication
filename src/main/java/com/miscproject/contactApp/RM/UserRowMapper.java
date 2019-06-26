package com.miscproject.contactApp.RM;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.miscproject.contactApp.Domain.User;

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u=new User();
        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setPhoneNo(rs.getString("phoneNo"));
        u.setEmail(rs.getString("email"));
        u.setAddress(rs.getString("address"));
        u.setLoginName(rs.getString("loginName"));
        u.setRole(rs.getInt("role"));
        u.setLoginState(rs.getInt("loginState"));
        return u;
    }    
}