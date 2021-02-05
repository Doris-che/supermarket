package com.cheyuhong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;




public class DBUtil {
  public static  Connection getConnection() throws Exception{
	  //获取数据库资源
	  Connection connection=null;
	  String className="com.mysql.jdbc.Driver";
	  Class.forName(className);
	String url="jdbc:mysql://localhost:3306/supermarket?useSSL=false";
	String user="root";
	String password="wangyibo";
	connection=DriverManager.getConnection(url, user, password);  
    return connection;
  }
  //
  public void closeDBResources(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet)throws Exception {
	if (resultSet!=null) {
		try {
			resultSet.close();
		} finally {
			resultSet=null;
		}
	}
	if (preparedStatement!=null) {
		try {
			preparedStatement.close();
		} finally {
			preparedStatement=null;
		}
	}
	if (connection!=null) {
		try {
			connection.close();
		} finally {
			connection=null;
		}
	}
}
  
  
  
}
