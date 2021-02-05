package com.cheyuhong.service;

import com.cheyuhong.bean.Member;

public interface MemberService {

	Member countMemberByMember_no(String member_no);

	int updateIntegral(String member_no, int integral);

}
