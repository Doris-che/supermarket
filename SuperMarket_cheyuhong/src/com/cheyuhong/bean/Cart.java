package com.cheyuhong.bean;


/*
 * @开发者 车玉红
 * @类别   javaBean对象
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @封装购物车信息
 */
public class Cart {
	/*
	 * 购物车中购买的商品编号
	 */
	private String product_no;
	/*
	 * 购物车中购买的商品名称
	 */
	private String product_name;
	/*
	 * 购物车中购买的商品单位
	 */
	private String product_unit;
	/*
	 * 购物车中购买的商品价格
	 */
	private double product_price;
	/*
	 * 购物车的数量
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
