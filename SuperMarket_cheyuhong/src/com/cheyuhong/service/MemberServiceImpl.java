package com.cheyuhong.service;


import com.cheyuhong.bean.Member;
import com.cheyuhong.dao.MemberDao;
import com.cheyuhong.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	MemberDao memberDao=new MemberDaoImpl();
	@Override
	public Member countMemberByMember_no(String member_no) {
		Member member=null;
		try {
			member=memberDao.countMemberByMember_no(member_no);
		} catch (Exception e) {
			e.printStackTrace();
			member=null;
		}
		return member;
	}

	@Override
	public int updateIntegral(String member_no, int integral) {
		int rows=0;
		try {
			rows=memberDao.updateIntegral(member_no,integral);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

}
