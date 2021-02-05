package com.cheyuhong.service;

import com.cheyuhong.bean.User;

public interface UserService {

	User loginByUsernameAndUserpwd(String username, String userpwd);

}
