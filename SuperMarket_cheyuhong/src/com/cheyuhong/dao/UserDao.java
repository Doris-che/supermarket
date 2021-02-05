package com.cheyuhong.dao;

import com.cheyuhong.bean.User;

public interface UserDao {

	User loginByUsernameAndUserpwd(String username, String userpwd) throws Exception;

}