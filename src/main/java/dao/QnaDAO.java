package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.QnaDTO;
import util.Pager;

public class QnaDAO {

	// 싱글톤
	private static QnaDAO instance = new QnaDAO();

	public static QnaDAO getInstance() {
		return instance;
	}

	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

	// 전체 글 개수
	public int qnaCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select count(qna_ref) from qna where qna_yn='y'";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
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
	}// qnaCount end

	// 글목록
	public List<QnaDTO> qnaList(Pager pager) {
		
		System.out.println("QnaDAO");
		List<QnaDTO> list = new ArrayList<QnaDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from (select rownum rnum, qnas.* from (select qna_num, qna_writer, REGEXP_REPLACE(qna_writer, '.', '*', 4) as qna_writerS, qna_title, qna_content, qna_date, qna_ref, qna_step, qna_depth, qna_sec, qna_check from qna where qna_num > 0 and qna_yn='y' order by qna_ref desc, qna_step asc) qnas ) where rnum>=? and rnum<=?";

			ps = con.prepareStatement(sql);
			System.out.println("pager.startrow : "+pager.getStartRow());
			ps.setInt(1, pager.getStartRow());
			ps.setInt(2, pager.getLastRow());
			rs = ps.executeQuery();

			while (rs.next()) {
				QnaDTO qnaDTO = new QnaDTO();
				qnaDTO.setQna_num(rs.getInt("qna_num"));
				qnaDTO.setQna_writer(rs.getString("qna_writer"));
				qnaDTO.setQna_writerS(rs.getString("qna_writerS")); 
				qnaDTO.setQna_title(rs.getString("qna_title"));
				qnaDTO.setQna_content(rs.getString("qna_content"));
				qnaDTO.setQna_date(rs.getDate("qna_date"));
				qnaDTO.setQna_ref(rs.getInt("qna_ref"));
				qnaDTO.setQna_step(rs.getInt("qna_step"));
				qnaDTO.setQna_depth(rs.getInt("qna_depth"));
				qnaDTO.setQna_sec(rs.getInt("qna_sec"));
				qnaDTO.setQna_check(rs.getInt("qna_check"));

				list.add(qnaDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
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
		return list;
	}
}
