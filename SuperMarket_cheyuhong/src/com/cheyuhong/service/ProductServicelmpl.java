package com.cheyuhong.service;

import java.util.List;

import com.cheyuhong.bean.Product;
import com.cheyuhong.dao.ProductDao;
import com.cheyuhong.dao.ProductDaoImpl;

public class ProductServicelmpl implements ProductService{
    ProductDao productDao=new ProductDaoImpl();
	@Override
	public List<Product> fetchALLProductList() {
		List<Product> productList=null;
		try {
			productList=productDao.fetchALLProductList();
		} catch (Exception e) {
			e.printStackTrace();
			productList=null;
		}		
		return productList;
	}
	@Override
	public Product queryByProductno(String product_no) {
		Product product=null;
		try {
			product=productDao.queryByProductno(product_no);
		} catch (Exception e) {
			e.printStackTrace();
			product=null;
		}		
		return product;
	}
	@Override
	public int countByProduct_no(String product_no) {
		int rows=0;
		try {
			rows=productDao.countByProduct_no(product_no);
		} catch (Exception e) {
			e.printStackTrace();
			rows=0;
		}
		
		return rows;
	}
	@Override
	public int addProduct(Product product) {
		int rows=0;
		try {
			rows=productDao.addProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			rows=0;
		}
		
		return rows;
	}
	@Override
	public int ruKuChaChong(String product_no,int product_num) {
		int rows=0;
		try {
			rows=productDao.ruKuChaChong(product_no,product_num);
		} catch (Exception e) {
			e.printStackTrace();
			rows=0;
		}
		
		return rows;
	}
	@Override
	public int chuKuByProduct_no(String product_no, int product_num) {
		int rows=0;
		try {
			rows=productDao.chuKuByProduct_no(product_no,product_num);
		} catch (Exception e) {
			e.printStackTrace();
			rows=0;
		}
		
		return rows;
	}
 
	

	 
}
