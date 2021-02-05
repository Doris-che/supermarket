package com.cheyuhong.dao;

import java.util.List;

import com.cheyuhong.bean.Cart;
/*
 * @������ �����
 * @���   ���ݷ��ʲ�ӿ�
 * @��ʼ���� 2020-12-07
 * @�������� 2020-12-17
 * @�汾V1.0
 * @���ﳵ��Daoʵ��
 */
public interface CartDao {
      /*
               * ��ȡ���й��ﳵ��Ϣ
      */
	List<Cart> queryAllCart() throws Exception;
	/*
	 * ����product_no��ȡ��ƥ��Ĺ��ﳵ����
	 * ɨ����Ʒʱ��Ӱ�����
	 */
	int countCartByProduct_no(String product_no) throws Exception;
	/*
	 * ����product_no��ȡ���еĹ��ﳵ����
	 */
	int addOldCart(String product_no) throws Exception;
	/*
	 * ����product_no��ȡ�����Ĺ��ﳵ����
	 */
	int addNewCart(String product_no) throws Exception;
	/*
	 * ����product_no��ȡɨ����Ʒ�ɹ��󣬹��ﳵ������
	 */
	Cart queryCartByProduct_no(String product_no) throws Exception;
	/*
	 * �޸Ĺ��ﳵ������
	 */
	int updateCart(String product_no, int cart_num) throws Exception;
	/*
	 * ����ʱ���ܽ��
	 */
	double fetchTotalMoney() throws Exception;
	/*
	 * �޸Ĺ��ﳵ��״̬
	 */
	int updateCartStatus() throws Exception;

}
