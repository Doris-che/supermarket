package com.cheyuhong.bean;

/*
 * @������ �����
 * @���   javaBean����
 * @��ʼ���� 2020-12-07
 * @�������� 2020-12-17
 * @�汾V1.0
 * @��װ�û���Ϣ
 */
public class User {
/*
 * �û���ʶ
 */
	private int id;
	/*
	 * �û���
	 */
	private String username;
	/*
	 * �û�����
	 */
	private String userpwd;
	/*
	 * �û�����     1Ϊ������Ա    2Ϊ�˿�
	 */
	private int user_type;
	/*
	 * �û����
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
