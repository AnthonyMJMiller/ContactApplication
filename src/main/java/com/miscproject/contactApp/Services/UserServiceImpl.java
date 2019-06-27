package com.miscproject.contactApp.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.miscproject.contactApp.DAO.UserDAO;
import com.miscproject.contactApp.Domain.User;
import com.miscproject.contactApp.Exception.UserBlockedException;
import com.miscproject.contactApp.RM.UserRowMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void register(User u) {
		userDAO.save(u);
		
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		
		String sql = "SELECT userId, name, phoneNo, email, address, role, loginState, loginName"
                + " FROM user WHERE loginName="+"'"+loginName+"'" + "AND password="+"'"+password+"'";
//        Map m = new HashMap();
//        m.put("ln", loginName);
//        m.put("pw", password);
        User u = new User();
        u = jdbcTemplate.queryForObject(sql, new UserRowMapper());
        try {
        	
            if (u.getLoginState().equals(UserService.LOGIN_STATE_BLOCKED)) {
                throw new UserBlockedException("Your accout has been blocked. Contact to admin.");
            } else {
                return u;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
	}

	@Override
	public List<User> getUserList() {
		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginState) {
		String sql = "UPDATE user SET loginState=:lst WHERE userId=:uid";
//        Map m = new HashMap();
//        m.put("uid", userId);
//        m.put("lst", loginState);
        jdbcTemplate.update(sql, new Object[] {userId, loginState});
		
	}

	@Override
	public Boolean isUsernameExist(String username) {
		String sql = "SELECT count(loginName) FROM user WHERE loginName=?";
        Integer count = jdbcTemplate.queryForObject(sql, new String[]{username}, Integer.class);
        if(count==1){
            return true;
        }else{
            return false;
        }
	}

}
