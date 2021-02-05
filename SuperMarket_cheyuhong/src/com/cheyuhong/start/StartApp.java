package com.cheyuhong.start;

import com.cheyuhong.operator.Operator;
import com.cheyuhong.operator.OperatorImpl;

/*
 * @开发者 车玉红
 * @类别   控制台的操作类接口的实现
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @系统的入口
 */
public class StartApp {
/*
 * 启动系统
 */
	public static void main(String[] args) {
		Operator operator=new OperatorImpl();
		operator.start(); 
	}

}
