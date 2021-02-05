package com.cheyuhong.service;

import java.util.List;

import com.cheyuhong.bean.Product;


public interface ProductService {

	List<Product> fetchALLProductList();
	Product queryByProductno(String product_no);
	int countByProduct_no(String product_no);
	int addProduct(Product product);
	int ruKuChaChong(String product_no,int product_num);
	int chuKuByProduct_no(String product_no, int product_num);


	
	

	

}
