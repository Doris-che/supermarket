
package com.cheyuhong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cheyuhong.bean.Product;
import com.cheyuhong.util.DBUtil;


public class ProductDaoImpl implements ProductDao  {
	
	
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	@Override
	
	public List<Product> fetchALLProductList() throws Exception {
		List<Product> productList=null;
		connection=DBUtil.getConnection();
		String sql="select * from product ";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		productList= new ArrayList<Product>();
		while (resultSet.next()) {
			Product product=new Product();
			product.setId(resultSet.getInt("id"));
			product.setProduct_no(resultSet.getString("product_no"));
			product.setProduct_name(resultSet.getString("product_name"));
			product.setProduct_price(resultSet.getDouble("product_price"));
			product.setProduct_unit(resultSet.getString("product_unit"));
			product.setProduct_num(resultSet.getInt("product_num"));
			
			productList.add(product);	
			}
		
		return productList;
	}
	@Override
	public Product queryByProductno(String product_no) throws Exception{
		Product product=null;
		connection=DBUtil.getConnection();
		String sql="select * from product where product_no=? ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, product_no);
		resultSet=preparedStatement.executeQuery();
		
				while (resultSet.next()) {
					product=new Product();
					product.setId(resultSet.getInt("id"));
					product.setProduct_no(resultSet.getString("product_no"));
					product.setProduct_name(resultSet.getString("product_name"));
					product.setProduct_price(resultSet.getDouble("product_price"));
					product.setProduct_unit(resultSet.getString("product_unit"));
					product.setProduct_num(resultSet.getInt("product_num"));
				}
		return product;
	}
	@Override
	public int countByProduct_no(String product_no) throws Exception {
		int rows=0;
		connection=DBUtil.getConnection();
		String sql="select count(*) from product where product_no=? ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, product_no);
		resultSet=preparedStatement.executeQuery();
		
				while (resultSet.next()) {
					rows=resultSet.getInt(1);
			}
		
		return rows;
	}
	@Override
	public int addProduct(Product product) throws Exception {
		connection=DBUtil.getConnection();
		int rows=0;
		String sql="insert into product (product_no,product_name,product_price,product_unit,product_num) value (?,?,?,?,?) ";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, product.getProduct_no());
		preparedStatement.setString(2, product.getProduct_name());
		preparedStatement.setDouble(3, product.getProduct_price());
		preparedStatement.setString(4, product.getProduct_unit());
		preparedStatement.setInt(5, product.getProduct_num());
		rows=preparedStatement.executeUpdate();
		return rows;
	}
	@Override
	public int ruKuChaChong(String product_no,int product_num) throws Exception {
		connection=DBUtil.getConnection();
		int rows=0;
		String sql="update product set product_num=product_num+? where product_no=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, product_num);
		preparedStatement.setString(2, product_no);
		rows=preparedStatement.executeUpdate();
		return rows;
	}
	@Override
	public int chuKuByProduct_no(String product_no, int product_num) throws Exception {
		connection=DBUtil.getConnection();
		int rows=0;
		String sql="update product set product_num=product_num-? where product_no=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, product_num);
		preparedStatement.setString(2, product_no);
		rows=preparedStatement.executeUpdate();
		return rows;
	}
	
	
	
	
		
		

}
