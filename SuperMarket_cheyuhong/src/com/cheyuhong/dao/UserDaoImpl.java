package com.cheyuhong.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.cheyuhong.bean.User;
import com.cheyuhong.util.DBUtil;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao  {
	
	
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	@Override
	public User loginByUsernameAndUserpwd(String username, String userpwd) throws Exception {
		User user=null;
		connection=DBUtil.getConnection();
		String sql="select * from user where username=? and userpwd=?";
		preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, userpwd);
		resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			user=new User();
			user.setId(resultSet.getInt("id"));
			user.setUsername(resultSet.getString("username"));
			user.setUser_type(resultSet.getInt("user_type"));
			user.setUser_no(resultSet.getString("user_no"));
			
		}
		
		return user;
	}

}
