package com.cheyuhong.dao;

import java.util.List;

import com.cheyuhong.bean.Product;
/*
 * @������ �����
 * @���   ���ݷ��ʲ�ӿ�
 * @��ʼ���� 2020-12-07
 * @�������� 2020-12-17
 * @�汾V1.0
 * @��Ʒ��Daoʵ��
 */

public interface ProductDao {
	/*
	 * �鿴������Ʒ
	 */
	List<Product> fetchALLProductList() throws Exception;
	/*
	 * ������Ʒ���
	 */
	Product queryByProductno(String product_no) throws Exception;
	/*
	 * �ж���Ʒ����
	 */
	int countByProduct_no(String product_no) throws Exception;
	/*
	 * ������Ʒ
	 */
	int addProduct(Product product) throws Exception;
	/*
	 * ��Ʒ����
	 */
	int ruKuChaChong(String product_no,int product_num) throws Exception;
	/*
	 * ��Ʒ����
	 */
	int chuKuByProduct_no(String product_no, int product_num) throws Exception;

	

}
