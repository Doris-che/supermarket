package com.cheyuhong.start;

import com.cheyuhong.operator.Operator;
import com.cheyuhong.operator.OperatorImpl;

/*
 * @������ �����
 * @���   ����̨�Ĳ�����ӿڵ�ʵ��
 * @��ʼ���� 2020-12-07
 * @�������� 2020-12-17
 * @�汾V1.0
 * @ϵͳ�����
 */
public class StartApp {
/*
 * ����ϵͳ
 */
	public static void main(String[] args) {
		Operator operator=new OperatorImpl();
		operator.start(); 
	}

}
