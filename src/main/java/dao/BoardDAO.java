package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {
		// 싱글톤
		private static BoardDAO instance = new BoardDAO();

		public static BoardDAO getInstance() {
			return instance;
		}
		
		// 컨넥션풀에서 컨넥션을 구해오는 메소드
		private Connection getConnection() throws Exception{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
	  		return ds.getConnection();
		}
		
		// 글 목록 : 총 데이터 갯수 구하기
		public int getCount(int cate_num) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// 해당 게시판에 있는 글 중 Y인 게시글만 검색
			try {
				con = getConnection();
				
				String sql= "select count(*) from board where cate_num=? and board_yn='y'";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cate_num);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt(1);	
				//	result = rs.getInt("count(*)");	
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();} catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
				if(con != null) try {con.close();} catch(Exception e) {}
			}
			return result;
		}
		// 글목록 : 각 게시판별 글목록 구해오기
		public List<BoardDTO> getList(int start, int end, int cate_num){
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				String sql = "select * from (select rownum rnum, board.* from ";
					sql	+= " (select * from board where cate_num=? and board_yn='y' order by board_num desc) board )";
					sql += "  where rnum >=? and rnum<=? "  ;
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cate_num);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					BoardDTO board = new BoardDTO();
					board.setBoard_num(rs.getInt("board_num"));
					board.setBoard_title(rs.getString("board_title"));
					board.setBoard_content(rs.getString("board_content"));
					board.setBoard_memnum(rs.getInt("board_memnum"));
					board.setBoard_nick(rs.getString("board_nick"));
					board.setBoard_date(rs.getTimestamp("board_date"));
					board.setBoard_count(rs.getInt("board_count"));
					board.setBoard_good(rs.getInt("board_good"));
					board.setBoard_bad(rs.getInt("board_bad"));
					board.setBoard_up_memnum(rs.getInt("board_up_memnum"));
					board.setBoard_up_date(rs.getTimestamp("board_up_date"));
					board.setBoard_yn(rs.getString("board_yn"));
					board.setCate_num(rs.getInt("cate_num"));
					
					list.add(board);
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
		
		// 글목록 : 정렬 - 각 게시판별 정렬된 글 목록 가져오기
		public List<BoardDTO> getOrderList(int start, int end, int cate_num, String order){
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();

				String sql = "select * from (select rownum rnum, board.* from ";
				sql	+= " (select * from board where cate_num=? and board_yn='y' order by "+order+" desc) board) ";
				sql += "  where rnum >=? and rnum<=? ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cate_num);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					BoardDTO board = new BoardDTO();
					board.setBoard_num(rs.getInt("board_num"));
					board.setBoard_title(rs.getString("board_title"));
					board.setBoard_content(rs.getString("board_content"));
					board.setBoard_memnum(rs.getInt("board_memnum"));
					board.setBoard_nick(rs.getString("board_nick"));
					board.setBoard_date(rs.getTimestamp("board_date"));
					board.setBoard_count(rs.getInt("board_count"));
					board.setBoard_good(rs.getInt("board_good"));
					board.setBoard_bad(rs.getInt("board_bad"));
					board.setBoard_up_memnum(rs.getInt("board_up_memnum"));
					board.setBoard_up_date(rs.getTimestamp("board_up_date"));
					board.setBoard_yn(rs.getString("board_yn"));
					board.setCate_num(rs.getInt("cate_num"));
					list.add(board);
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
		
		public List<BoardDTO> getFindList(int start, int end, int cate_num, String sel, String find){
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();

				String sql = "select * from (select rownum rnum, board.* from ";
				sql	+= " (select * from board where cate_num=? and board_yn='y' and "+sel+" like '%"+find+"%'order by board_num desc) board) ";
				sql += "  where rnum >=? and rnum<=? ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cate_num);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					BoardDTO board = new BoardDTO();
					board.setBoard_num(rs.getInt("board_num"));
					board.setBoard_title(rs.getString("board_title"));
					board.setBoard_content(rs.getString("board_content"));
					board.setBoard_memnum(rs.getInt("board_memnum"));
					board.setBoard_nick(rs.getString("board_nick"));
					board.setBoard_date(rs.getTimestamp("board_date"));
					board.setBoard_count(rs.getInt("board_count"));
					board.setBoard_good(rs.getInt("board_good"));
					board.setBoard_bad(rs.getInt("board_bad"));
					board.setBoard_up_memnum(rs.getInt("board_up_memnum"));
					board.setBoard_up_date(rs.getTimestamp("board_up_date"));
					board.setBoard_yn(rs.getString("board_yn"));
					board.setCate_num(rs.getInt("cate_num"));
					list.add(board);
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
		
	
}
