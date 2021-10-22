package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ReplyDTO;

public class ReplyDAO {
	// 싱글톤
	private static ReplyDAO instance = new ReplyDAO();

	public static ReplyDAO getInstance() {
		return instance;
	}
	
	// 댓글 작성(insert)
	public int replyWrite(ReplyDTO reply) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into reply values(reply_seq.nextval,?,sysdate, ";
			sql += " ?,?,reply_seq.nextval,'y',?,?) ";
				   
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reply.getRe_writer());
			pstmt.setInt(2, 0);			// re_seq
			pstmt.setInt(3, 0);			// re_level
			pstmt.setInt(4, reply.getBoard_num());
			pstmt.setString(5, reply.getRe_content());
			result = pstmt.executeUpdate();		//sql문 실행
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return result;
	}
	
	
	
	// 대댓글 작성(update & insert)
	public int reReplyWrite(ReplyDTO reply) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// 부모댓글에 대한 정보
		int re_ref = reply.getRe_ref();
		int re_level = reply.getRe_level();
		int re_seq = reply.getRe_seq();
		
		try {
			con = getConnection();
			
			//update
			String sql = "update reply set re_seq=re_seq+1 where re_ref=? and re_seq > ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.executeUpdate();
			
			// insert
			sql = "insert into reply values(reply_seq.nextval,?,sysdate ";
			sql += " ?,?,?,'y',?,?) ";
				   
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reply.getRe_writer());
			pstmt.setInt(2, re_seq+1);			// re_seq
			pstmt.setInt(3, re_level+1);			// re_level
			pstmt.setInt(4, re_ref);	// re_ref
			pstmt.setInt(5, reply.getBoard_num());
			pstmt.setString(6, reply.getRe_content());
			result = pstmt.executeUpdate();		//sql문 실행
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return result;
	}
	
	
	//댓글 : 댓글목록 출력
	public List<ReplyDTO> getReplyListAction(int board_num) {
		List<ReplyDTO> list = new ArrayList<ReplyDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;;
		try {
			con = getConnection();
			String sql = "select * from (select rownum rnum, reply.* from (select * from reply order by re_ref asc, ";
			sql += " re_seq desc) reply ) where board_num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyDTO reply = new ReplyDTO();
				reply.setRe_writer(rs.getString("re_writer"));
				reply.setRe_content(rs.getString("re_content"));
				reply.setRe_date(rs.getTimestamp("re_date"));
				reply.setRe_num(rs.getInt("re_num"));
				reply.setRe_yn(rs.getString("re_yn"));
				
				list.add(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return list;
	}
	
	// 댓글 : 댓글 삭제
	public int deleteReplyAction(int re_num) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update reply set re_yn='n' where re_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_num);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		
		return result;
	}

	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

}
