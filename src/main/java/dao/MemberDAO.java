//DAO(Data Access Object)

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

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
		// 1명의 회원정보 구하기
		public MemberDTO getMember(String mem_id) {
			MemberDTO member = new MemberDTO();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection(); // 컨넥션풀 사용해서 컨넥션 구해옴
				
				String sql = "select * from member where mem_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				rs = pstmt.executeQuery();  // select SQL문 실행
				
				if(rs.next()) {
					member.setMem_num(rs.getInt("mem_num"));
					member.setMem_id(rs.getString("mem_id"));
					member.setMem_nick(rs.getString("mem_nick"));
					member.setMem_pass(rs.getString("mem_pass"));
					member.setMem_email(rs.getString("mem_email"));
					member.setMem_date(rs.getTimestamp("mem_date"));
					member.setMem_img(rs.getString("mem_img"));
					member.setMem_phone(rs.getString("mem_phone"));
					member.setMem_up_memnum(rs.getInt("mem_up_memnum"));
					member.setMem_up_date(rs.getTimestamp("mem_up_date"));
					member.setMem_yn(rs.getString("mem_yn"));
					member.setMem_grade(rs.getInt("mem_grade"));
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
		
		public int update(MemberDTO member) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
					
			try {
				con = getConnection();
String sql="update member set mem_nick=?,mem_pass=?,mem_email=?,mem_img=?,mem_phone=? where mem_id=?";
			
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
		//아이디 찾기
		public String searchId(String mem_nick, String mem_email) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String mem_id = null;
			
			try {
				con = getConnection();
				
				String sql=" select * from member where mem_nick = ? and mem_email = ?";
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1, mem_nick);
				pstmt.setString(2, mem_email);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {				
					mem_id = rs.getString("mem_id"); 
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null)try{pstmt.close();}catch(Exception e) {}
				if(con != null)try {con.close();}catch(Exception e) {}
			}
			return mem_id;
		}
		//비밀번호 찾기
		public String searchPw(String mem_id, String mem_nick ) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String mem_pass = null;
			
			try {
				con = getConnection();
				
				String sql=" select * from member where mem_id = ? and mem_nick = ? ";
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				pstmt.setString(2, mem_nick);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {				
					mem_pass = rs.getString("mem_pass"); 
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null)try{pstmt.close();}catch(Exception e) {}
				if(con != null)try {con.close();}catch(Exception e) {}
			}
			return mem_pass;
		}
		
}

