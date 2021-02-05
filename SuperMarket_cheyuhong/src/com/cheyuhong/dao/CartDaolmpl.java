package com.cheyuhong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.cheyuhong.bean.Cart;
import com.cheyuhong.util.DBUtil;

public class CartDaolmpl implements CartDao {
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;

	@Override
	public List<Cart> queryAllCart() throws Exception {
		List<Cart> cartList=null;
		connection=DBUtil.getConnection();
		String sql = "select  p.product_no product_no, p.product_name product_name, p.product_unit product_unit,p.product_price product_price, c.cart_num cart_num from  cart c,product p where c.product_no=p.product_no and c.status=0";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		cartList=new ArrayList<Cart>();
		while (resultSet.next()) {
			Cart cart=new Cart();
			cart.setProduct_no(resultSet.getString("product_no"));
			cart.setProduct_name(resultSet.getString("product_name"));
			cart.setProduct_unit(resultSet.getString("product_unit"));
			cart.setProduct_price(resultSet.getDouble("product_price"));
			cart.setCart_num(resultSet.getInt("cart_num"));
			cartList.add(cart);
		}
		return cartList;
	}

	@Override
	public int countCartByProduct_no(String product_no) throws Exception {
		int count=0;
		connection=DBUtil.getConnection();
		String sql = "select count(*) from cart where product_no=?  and  status=0";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,product_no);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			count=resultSet.getInt(1);
		}
		return count;
	}

	@Override
	public int updateCart(String product_no, int cart_num) throws Exception {
		int rows=0;
		connection=DBUtil.getConnection();
		String sql="update cart set cart_num=?  where product_no=? and status=0";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,cart_num);
		preparedStatement.setString(2,product_no);
		rows=preparedStatement.executeUpdate();
		return rows;
	}

	@Override
	public int addNewCart(String product_no) throws Exception {
		int rows=0;
		connection=DBUtil.getConnection();
		String sql = "insert into cart (product_no,cart_num,status) values (?,1,0) ";		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,product_no);
		rows=preparedStatement.executeUpdate();
		return rows;
	}

	@Override
	public int addOldCart(String product_no) throws Exception {
		int rows=0;
		connection=DBUtil.getConnection();
		String sql = "update cart set cart_num=cart_num+1 where product_no=?  and  status=0";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,product_no);
		rows=preparedStatement.executeUpdate();
		return rows;
	}

	

	@Override
	public Cart queryCartByProduct_no(String product_no) throws Exception {
		Cart cart=null;
		connection=DBUtil.getConnection();
		String sql = "select  p.product_no product_no, p.product_name product_name, p.product_unit product_unit,p.product_price product_price, c.cart_num cart_num from  cart c,product p where c.product_no=p.product_no and c.product_no=?  and c.status=0";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,product_no);
		resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			cart=new Cart();
			cart.setProduct_no(resultSet.getString("product_no"));
			cart.setProduct_name(resultSet.getString("product_name"));
			cart.setProduct_unit(resultSet.getString("product_unit"));
			cart.setProduct_price(resultSet.getDouble("product_price"));
			cart.setCart_num(resultSet.getInt("cart_num"));
		}
		return cart;
	}

	@Override
	public double fetchTotalMoney() throws Exception {
		double totalMoney = 0;
		connection = DBUtil.getConnection();
		String sql = "select  sum(p.product_price*c.cart_num)  "
				+ "from  cart c,product p where c.product_no=p.product_no  and c.status=0";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			totalMoney = resultSet.getDouble(1);
		}
		return totalMoney;
	}

	@Override
	public int updateCartStatus() throws Exception {
		int rows = 0;
		connection = DBUtil.getConnection();
		String sql = "update cart set status=1  where status=0";
		preparedStatement = connection.prepareStatement(sql);
		rows = preparedStatement.executeUpdate();
		return rows;
	}

	
	
}
