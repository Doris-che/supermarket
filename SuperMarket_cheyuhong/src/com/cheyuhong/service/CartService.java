package com.cheyuhong.service;



import java.util.List;

import com.cheyuhong.bean.Cart;

public interface CartService {

	
	List<Cart> queryAllCart();

	int addCatrByProduct_no(String product_no);

	int updateCart(String product_no, int cart_num);

	int countCartByProduct_no(String product_no);

	Cart queryCatrByProduct_no(String product_no);

	int updateCartStatus();

	double fetchTotalMoney();

	

	
}
