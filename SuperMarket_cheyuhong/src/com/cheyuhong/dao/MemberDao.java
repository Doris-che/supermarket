package com.cheyuhong.dao;

import com.cheyuhong.bean.Member;
/*
 * @������ �����
 * @���   ���ݷ��ʲ�ӿ�
 * @��ʼ���� 2020-12-07
 * @�������� 2020-12-17
 * @�汾V1.0
 * @��Ա��Daoʵ��
 */
public interface MemberDao {
	/*
	 * ��ȡ��Ա��
	 */
	Member countMemberByMember_no(String member_no) throws Exception;
	/*
	 * ���»���
	 */
	int updateIntegral(String member_no, int integral) throws Exception;

}
