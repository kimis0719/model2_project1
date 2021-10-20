//DAO(Data Access Object)

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.MemberDTO;

public class MemberDAO{
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	//회원가입
	public int insert(MemberDTO member) {
		int result =0;
		Connection con =null;
		PreparedStatement pstmt =null;
		
		try {
			con = getConnection();

String sql="insert into member ";
		sql+=" values(member_seq.nextval,?,?,?,?,sysdate,?,?,'','','y',1) ";
		
		pstmt= con.prepareStatement(sql);
		pstmt.setString(1, member.getMem_id());
		pstmt.setString(2, member.getMem_nick());
		pstmt.setString(3, member.getMem_pass());
		pstmt.setString(4, member.getMem_email());
		pstmt.setString(5, member.getMem_img());
		pstmt.setString(6, member.getMem_phone());
		
		result = pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try { pstmt.close(); }catch(Exception e) {}
			if(con != null) try { con.close(); }catch(Exception e) {}
		}
		
		return result;
		
	}
	
	//id중복검사
	public int idcheck(String mem_id) {
		int result =0;
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			
			String sql=" select * from member where mem_id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;	//이미 존재하는 id
			}else {
				result = -1; //사용 가능 id
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close();}catch(Exception e) {}
			if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
			if(con != null) try { con.close();}catch(Exception e) {}
		}
		return result;
	}
	//닉네임 중복검사
	public int nickcheck(String mem_nick) {
		int result=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con =getConnection();
			
			String sql=" select * from member where mem_nick = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_nick);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 2;	//사용중 nick
			}else {
				result = 3;	//사용가능 nick
			}
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close();}catch(Exception e) {}
			if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
			if(con != null) try { con.close();}catch(Exception e) {}
		}
		
		return result;
		
	}
	//로그인(회원인증)
	public int memberAuth(String mem_id, String mem_pass) {
		int result =0;
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			con = getConnection();
			
			String sql= " select * from member where mem_id = ? and mem_pass = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;		//인증성공
			}else {
				result = -1;	//실패
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(pstmt != null)try{pstmt.close();}catch(Exception e) {}
			if(con != null)try {con.close();}catch(Exception e) {}
		}
		return result;
	}
	
}

	

