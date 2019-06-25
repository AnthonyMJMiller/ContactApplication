package com.miscproject.contactApp.Services;

import java.util.List;

import com.miscproject.contactApp.Domain.User;
import com.miscproject.contactApp.Exception.UserBlockedException;

public class UserServiceImpl implements UserService{

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean isUsernameExist(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
