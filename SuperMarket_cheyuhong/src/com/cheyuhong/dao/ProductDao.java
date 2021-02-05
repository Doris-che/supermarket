package com.cheyuhong.dao;

import java.util.List;

import com.cheyuhong.bean.Product;
/*
 * @开发者 车玉红
 * @类别   数据访问层接口
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @商品的Dao实现
 */

public interface ProductDao {
	/*
	 * 查看所有商品
	 */
	List<Product> fetchALLProductList() throws Exception;
	/*
	 * 接收商品编号
	 */
	Product queryByProductno(String product_no) throws Exception;
	/*
	 * 判断商品有无
	 */
	int countByProduct_no(String product_no) throws Exception;
	/*
	 * 新增商品
	 */
	int addProduct(Product product) throws Exception;
	/*
	 * 商品查重
	 */
	int ruKuChaChong(String product_no,int product_num) throws Exception;
	/*
	 * 商品出库
	 */
	int chuKuByProduct_no(String product_no, int product_num) throws Exception;

	

}
