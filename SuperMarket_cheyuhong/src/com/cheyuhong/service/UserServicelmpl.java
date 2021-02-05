package com.cheyuhong.service;

import com.cheyuhong.bean.User;
import com.cheyuhong.dao.UserDao;
import com.cheyuhong.dao.UserDaoImpl;

public class UserServicelmpl implements UserService{
 
	
	UserDao userDao=new UserDaoImpl();
	@Override
	public User loginByUsernameAndUserpwd(String username, String userpwd) {
		User user=null;
		
		
		try {
			user=userDao.loginByUsernameAndUserpwd(username,userpwd);
		} catch (Exception e) {
			e.printStackTrace();
			user=null;
		}
		return user;
	}

	 
}
