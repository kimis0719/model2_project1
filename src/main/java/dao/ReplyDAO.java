package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public int replyWrite(ReplyDTO reply) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into reply values(reply_seq.nextval,?,sysdate ";
				   sql += " ?,?,model2_seq.nextval,'y',?,?) ";
				   
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reply.getRe_writer());
			pstmt.setInt(2, 0);		// re_seq
			pstmt.setInt(3, 0);		// re_level
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
	
	
	//댓글 : 댓글목록 출력
	public List<ReplyDTO> replylistAction(int cate, int board_num) {
		List<ReplyDTO> list = new ArrayList<ReplyDTO>();
		
		return list;
	}

	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

}
