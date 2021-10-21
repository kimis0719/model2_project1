package dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
	private Connection getConnection() throws Exception {
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

			String sql = "select count(*) from board where cate_num=? and board_yn='y'";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
				// result = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return result;
	}// select end

	// 글작성:원문작성
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
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}// insert end

	// 글 수정
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
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return result;
	}// update end

	// 글 삭제
	public int delete(BoardDTO boardDTO) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConnection();

			String sql = "update board set board_yn='n', board_up_memnum=?, board_up_date=sysdate where board_num=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, boardDTO.getBoard_up_memnum());
			ps.setInt(2, boardDTO.getBoard_num());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}// delete end

	// 글목록 : 각 게시판별 글목록 구해오기
	public List<BoardDTO> getList(int start, int end, int cate_num) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "select * from (select rownum rnum, board.* from ";
			sql += " (select * from board where cate_num=? and board_yn='y' order by board_num desc) board )";
			sql += "  where rnum >=? and rnum<=? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return list;
	}// select end

	// 글목록 : 정렬 - 각 게시판별 정렬된 글 목록 가져오기
	public List<BoardDTO> getOrderList(int start, int end, int cate_num, String order) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from (select rownum rnum, board.* from ";
			sql += " (select * from board where cate_num=? and board_yn='y' order by " + order + " desc) board) ";
			sql += "  where rnum >=? and rnum<=? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return list;
	}

	// 글 목록 : 게시판 - 검색 데이터 갯수 구하기
	public int getFindCount(int cate_num, String sel, String find) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 해당 게시판에 있는 글 중 Y인 게시글만 검색
		try {
			con = getConnection();

			String sql = "select count(*) from board where cate_num=? and board_yn='y' ";
			sql += "and " + sel + " like '%" + find + "%'";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
				// result = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return result;
	}

	// 글 목록 : 게시판 - 검색
	public List<BoardDTO> getFindList(int start, int end, int cate_num, String sel, String find) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from (select rownum rnum, board.* from ";
			sql += " (select * from board where cate_num=? and board_yn='y' and " + sel + " like '%" + find
					+ "%'order by board_num desc) board) ";
			sql += "  where rnum >=? and rnum<=? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return list;
	}

	// 카테코리 번호별 5개 목록 구하기

	public List<BoardDTO> getboardlist(int cate) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from board, category ";
			sql += " where  board.cate_num = category.cate_num and board.cate_num=?  and rownum <= 5 ";
			sql += "  order by board.board_date desc";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate);

			rs = pstmt.executeQuery();

			while (rs.next()) {
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
				board.setCate_code(rs.getInt("cate_code"));

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return list;
	}

	// 글상세 : 조회수 증가
	public void readCountUpdate(int cate_num, int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();

			String sql = "update board set board_count=board_count+1 where cate_num=? and board_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			pstmt.setInt(2, board_num);
			pstmt.executeUpdate(); // SQL문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	// 글상세 : 글 상세페이지 출력
	public BoardDTO getBoardDetail(int cate_num, int board_num) {
		BoardDTO board = new BoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "select * from board where cate_num=? and board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			pstmt.setInt(2, board_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
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

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return board;
	}

	// 총 데이터 갯수 구하기 - 통합검색
	public int getUnifiedSearchDate() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@13.125.162.102:1521:xe";
		String sql;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "system", "oracle");

			sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
//							result = rs.getInt("count(*)");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}

	// 검색된 데이터 갯수
	public int getUnifiedSearch(String sel, String find) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@13.125.162.102:1521:xe";
		String sql;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "system", "oracle");

			sql = "select count(*) from board where " + sel + " like '%" + find + "%'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
//							result = rs.getInt("count(*)");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}

	// 검색된 글목록
	public List<BoardDTO> selectUnifiedSearchBoard(int start, int end) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = null;
		String url = "jdbc:oracle:thin:@13.125.162.102:1521:xe";
		String sql;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "system", "oracle");

			sql = "select * from ( select rownum rnum, board_num, ";
			sql += "board_nick, board_title, board_content  from ";
			sql += "(select * from board order by board_num desc)) ";
			sql += "where rnum >= ? and rnum <= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			list = new ArrayList<BoardDTO>();
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_nick(rs.getString("board_nick"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_content(rs.getString("board_content"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return list;
	}

	// 검색 목록 - 통합 검색 끝
	public List<BoardDTO> selectUnifiedSearchFboard(int start, int end, String sel, String find) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = null;
		String url = "jdbc:oracle:thin:@13.125.162.102:1521:xe";
		String sql;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "system", "oracle");

			sql = "select * from ( select rownum rnum, board_num, ";
			sql += "board_nick, board_title, content  from ";
			sql += "(select * from board where " + sel + " like '%" + find + "%' order by board_num desc)) ";
			sql += "where rnum >= ? and rnum <= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			list = new ArrayList<BoardDTO>();
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_nick(rs.getString("board_nick"));
				board.setBoard_title(rs.getString("board_title"));
				board.setBoard_content(rs.getString("board_content"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return list;
	}
}
