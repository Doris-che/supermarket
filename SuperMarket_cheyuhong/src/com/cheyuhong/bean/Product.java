package com.cheyuhong.bean;

/*
 * @������ �����
 * @���   javaBean����
 * @��ʼ���� 2020-12-07
 * @�������� 2020-12-17
 * @�汾V1.0
 * @��װ��Ʒ��Ϣ
 */
public class Product {
	/*
	 * ��Ʒ��ʶ
	 */
    private int  id;
    /*
	 * ��Ʒ����
	 */
    private String product_name;
    /*
	 * ��Ʒ���
	 */
    private String product_no;
    /*
	 * ��Ʒ�۸�
	 */
    private double product_price;
    /*
	 * ��Ʒ��λ
	 */
    private String product_unit;
    /*
	 * ��Ʒ����
	 */
    private int product_num;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getProduct_unit() {
		return product_unit;
	}
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
    
    
}
