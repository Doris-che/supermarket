package com.cheyuhong.dao;

import java.util.List;

import com.cheyuhong.bean.Cart;
/*
 * @开发者 车玉红
 * @类别   数据访问层接口
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @购物车的Dao实现
 */
public interface CartDao {
      /*
               * 获取所有购物车信息
      */
	List<Cart> queryAllCart() throws Exception;
	/*
	 * 根据product_no获取相匹配的购物车数量
	 * 扫描商品时受影响的行
	 */
	int countCartByProduct_no(String product_no) throws Exception;
	/*
	 * 根据product_no获取已有的购物车数量
	 */
	int addOldCart(String product_no) throws Exception;
	/*
	 * 根据product_no获取新增的购物车数量
	 */
	int addNewCart(String product_no) throws Exception;
	/*
	 * 根据product_no获取扫描商品成功后，购物车的数量
	 */
	Cart queryCartByProduct_no(String product_no) throws Exception;
	/*
	 * 修改购物车的数量
	 */
	int updateCart(String product_no, int cart_num) throws Exception;
	/*
	 * 结账时的总金额
	 */
	double fetchTotalMoney() throws Exception;
	/*
	 * 修改购物车的状态
	 */
	int updateCartStatus() throws Exception;

}
