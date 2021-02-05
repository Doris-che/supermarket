package com.cheyuhong.dao;

import com.cheyuhong.bean.Member;
/*
 * @开发者 车玉红
 * @类别   数据访问层接口
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @会员的Dao实现
 */
public interface MemberDao {
	/*
	 * 获取会员号
	 */
	Member countMemberByMember_no(String member_no) throws Exception;
	/*
	 * 更新积分
	 */
	int updateIntegral(String member_no, int integral) throws Exception;

}
