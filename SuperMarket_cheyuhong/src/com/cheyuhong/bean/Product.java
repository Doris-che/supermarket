package com.cheyuhong.bean;

/*
 * @开发者 车玉红
 * @类别   javaBean对象
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @封装商品信息
 */
public class Product {
	/*
	 * 商品标识
	 */
    private int  id;
    /*
	 * 商品名称
	 */
    private String product_name;
    /*
	 * 商品编号
	 */
    private String product_no;
    /*
	 * 商品价格
	 */
    private double product_price;
    /*
	 * 商品单位
	 */
    private String product_unit;
    /*
	 * 商品总数
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
