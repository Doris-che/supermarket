package com.cheyuhong.bean;

/*
 * @开发者 车玉红
 * @类别   javaBean对象
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @封装会员信息
 */
public class Member {
	/*
	 * 会员标识
	 */
	private int id;
	/*
	 * 会员号
	 */
	private String member_no;
	/*
	 * 会员积分
	 */
	private int integral;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	

}
