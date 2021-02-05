package com.cheyuhong.bean;

/*
 * @开发者 车玉红
 * @类别   javaBean对象
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @封装用户信息
 */
public class User {
/*
 * 用户标识
 */
	private int id;
	/*
	 * 用户名
	 */
	private String username;
	/*
	 * 用户密码
	 */
	private String userpwd;
	/*
	 * 用户类型     1为库存管理员    2为顾客
	 */
	private int user_type;
	/*
	 * 用户编号
	 */
	private String user_no;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

}
