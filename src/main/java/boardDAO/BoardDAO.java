package boardDAO;

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
		
		// 마이페이지 : 내가 작성한 글 목록 , 총 데이터 갯수 구하기
		public int getCount(int board_memnum) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql= "select count(*) from board where board_yn='y' and board_memnum=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_memnum);
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
		// 마이페이지 : 내가 작성한 글 목록 
		public List<BoardDTO> getList(int start, int end, int board_memnum){
			List<BoardDTO> list = new ArrayList<BoardDTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				String sql = "select * from (select rownum rnum, board.* from (select * from model2 order by board_re_ref desc, ";
				sql += " board_re_seq asc) board ) where rnum >=? and rnum<=? and board_yn='y'and board_memnum=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				pstmt.setInt(3, board_memnum);
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
		
		//글작성:원문작성
		public int insert(BoardDTO boardDTO) {
			int result = 0;
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = getConnection();
				
				String sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, sysdate, 0, 0, 0, '', '', 'y', ?)";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, boardDTO.getBoard_title());
				ps.setString(2, boardDTO.getBoard_content());
				ps.setInt(3, boardDTO.getBoard_memnum());
				ps.setString(4, boardDTO.getBoard_nick());
				ps.setInt(5, boardDTO.getCate_num());
				
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(ps != null) try {ps.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}//insert end

		//글 수정
		public int update(BoardDTO boardDTO) {
			int result = 0;
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = getConnection();
				
				String sql = "update board set board_title=?, board_content=?, board_nick=?, board_up_memnum=?, board_up_date=sysdate where board_num=?";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, boardDTO.getBoard_title());
				ps.setString(2, boardDTO.getBoard_content());
				ps.setString(3, boardDTO.getBoard_nick());
				ps.setInt(4, boardDTO.getBoard_memnum());
				ps.setInt(5, boardDTO.getBoard_num());
				
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(ps != null) try {ps.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			return result;
		}//update end
		
		//글 삭제
		public int delete(BoardDTO boardDTO) {
			int result = 0;
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = getConnection();
				
				String sql = "update board set board_yn='n' where board_num=?";
				
				ps = con.prepareStatement(sql);
				ps.setInt(1, boardDTO.getBoard_num());
				
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(ps != null) try {ps.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}//delete end
}
