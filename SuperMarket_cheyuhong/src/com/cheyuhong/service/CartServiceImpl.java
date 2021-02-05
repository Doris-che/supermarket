package com.cheyuhong.service;

import java.util.List;
import com.cheyuhong.bean.Cart;
import com.cheyuhong.dao.CartDao;
import com.cheyuhong.dao.CartDaolmpl;

public class CartServiceImpl implements CartService {
      CartDao cartDao=new CartDaolmpl();
		
		@Override
		public List<Cart> queryAllCart() {
			List<Cart> cartList=null;
			try {
				cartList=cartDao.queryAllCart();
			} catch (Exception e) {
				e.printStackTrace();
				cartList=null;
			}
			return cartList;
	}

	@Override
	public int addCatrByProduct_no(String product_no) {
		int rows=0;
		try {
			int rows2=cartDao.countCartByProduct_no(product_no);
			if (rows2==1) {
				rows=cartDao.addOldCart(product_no);//累加操作
			} else {
				rows=cartDao.addNewCart(product_no);//新增操作
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int updateCart(String product_no, int cart_num) {
		int rows=0;
		try {
			rows=cartDao.updateCart(product_no,cart_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int countCartByProduct_no(String product_no) {
		int count=0;
		try {
			count=cartDao.countCartByProduct_no(product_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Cart queryCatrByProduct_no(String product_no) {
		Cart cart=null;
		try {
			cart=cartDao.queryCartByProduct_no(product_no);
		} catch (Exception e) {
			e.printStackTrace();
			cart=null;
		}
		return cart;
	}

	@Override
	public int updateCartStatus() {
		int rows=0;
		try {
			rows=cartDao.updateCartStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public double fetchTotalMoney() {
		double totalMoney=0;
		try {
			totalMoney=cartDao.fetchTotalMoney();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalMoney;
	}
	

}
