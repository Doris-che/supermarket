package com.cheyuhong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.cheyuhong.bean.Member;
import com.cheyuhong.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	@Override
	public Member countMemberByMember_no(String member_no) throws Exception {
		Member member=null;
		connection = DBUtil.getConnection();
		String sql = "select * from member where member_no=? ";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, member_no);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			member=new Member();
			member.setId(resultSet.getInt("id"));
			member.setMember_no(resultSet.getString("member_no"));
			member.setIntegral(resultSet.getInt("integral"));
		}
		return member;
	}

	@Override
	public int updateIntegral(String member_no, int integral) throws Exception {
		int rows = 0;
		connection = DBUtil.getConnection();
		String sql = "update member set integral=integral+?  where member_no=? ";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, integral);
		preparedStatement.setString(2, member_no);
		rows = preparedStatement.executeUpdate();
		return rows;
	}

}
