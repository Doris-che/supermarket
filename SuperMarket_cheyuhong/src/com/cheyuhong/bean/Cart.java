package com.cheyuhong.bean;


/*
 * @������ �����
 * @���   javaBean����
 * @��ʼ���� 2020-12-07
 * @�������� 2020-12-17
 * @�汾V1.0
 * @��װ���ﳵ��Ϣ
 */
public class Cart {
	/*
	 * ���ﳵ�й������Ʒ���
	 */
	private String product_no;
	/*
	 * ���ﳵ�й������Ʒ����
	 */
	private String product_name;
	/*
	 * ���ﳵ�й������Ʒ��λ
	 */
	private String product_unit;
	/*
	 * ���ﳵ�й������Ʒ�۸�
	 */
	private double product_price;
	/*
	 * ���ﳵ������
	 */
	private int cart_num;
	
	
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_unit() {
		return product_unit;
	}
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}

	

    
}
