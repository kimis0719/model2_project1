package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.memberDTO;

public class memberDAO {

	// 싱글톤
	
	private static memberDAO instance = new memberDAO();
	
	public static memberDAO getinstance() {
		return instance;
	}
	
	// 컨넥션 풀
	
	private Connection getConnection() throws Exception{
		// dbcpAPITest내에 try아래 3줄을 복사하여 붙여넣기 필요한것들 임포트
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();  // conn= 을 return으로 변경
	}
	
	// 로그인(회원인증)
	public int memberAuth(String mem_id, String mem_pass) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
String sql = "select * from member where mem_id=? and mem_pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pass);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {  // id , 비번 일치시
				result = 1;
			}else {			 // id , 비번 불일치시
				result = -1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try { rs.close();}catch(Exception e) {};
			if(pstmt != null)try { pstmt.close();}catch(Exception e) {};
			if(con != null)try { con.close();}catch(Exception e) {};
		}
		
		return result;
	}
	
	// 1명의 회원정보 구하기
	public memberDTO getMember(String id) {
		memberDTO member = new memberDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection(); // 컨넥션풀 사용해서 컨넥션 구해옴
			
			String sql = "select * from member where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();  // select SQL문 실행
			
			if(rs.next()) {
				member.setMem_num(rs.getString("mem_num"));
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_nick(rs.getString("mem_nick"));
				member.setMem_pass(rs.getString("mem_pass"));
				member.setMem_email(rs.getString("mem_email"));
				member.setMem_date(rs.getTimestamp("mem_date"));
				member.setMem_img(rs.getString("mem_img"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_up_memnum(rs.getString("mem_up_memnum"));
				member.setMem_up_date(rs.getTimestamp("mem_up_date"));
				member.setMem_yn(rs.getString("mem_yn"));
				member.setMem_grade(rs.getString("mem_grade"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null)try { rs.close();}catch(Exception e) {};
			if(pstmt != null)try { pstmt.close();}catch(Exception e) {};
			if(con != null)try { con.close();}catch(Exception e) {};
		}
			return member;
		}
	// 회원정보 수정
	
	public int update(memberDTO member) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
				
		try {
			con = getConnection();
String sql="update member set mem_nick=?,mem_pass,mem_email,mem_img,mem_phone where mem_id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getMem_nick());
		pstmt.setString(2, member.getMem_pass());
		pstmt.setString(3, member.getMem_email());
		pstmt.setString(4, member.getMem_img());
		pstmt.setString(5, member.getMem_phone());
		
		result = pstmt.executeUpdate();  // update SQL문 실행
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)try { pstmt.close();}catch(Exception e) {};
			if(con != null)try { con.close();}catch(Exception e) {};
		}
		
		
		return result;
	}
	
	// 회원 탈퇴
	public int delete(String mem_yn) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
String sql="update member set use_yn=? where id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, mem_yn);
		result = pstmt.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)try { pstmt.close();}catch(Exception e) {};
			if(con != null)try { con.close();}catch(Exception e) {};
		}
		
		return result;
	}
	
	}

