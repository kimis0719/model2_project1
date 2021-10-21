package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.CateDTO;

public class CateDAO {
			// 싱글톤
			private static CateDAO instance = new CateDAO();

			public static CateDAO getInstance() {
				return instance;
			}
			
			// 컨넥션풀에서 컨넥션을 구해오는 메소드
			private Connection getConnection() throws Exception{
				Context init = new InitialContext();
		  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		  		return ds.getConnection();
			}
			
			// 카데고리별 게시판정보 불러오기
			public List<CateDTO> getcatelist(int cate){
				List<CateDTO> list = new ArrayList<CateDTO>();
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					con = getConnection();
					
					String sql = "select * from category where cate_code=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, cate);
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						CateDTO category = new CateDTO();
						category.setCate_num(rs.getInt("cate_num"));
						category.setCate_code(rs.getInt("cate_code"));
						category.setCate_name(rs.getString("cate_name"));
						
						list.add(category);
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
			
			// 게시판 이름 가져오기
			public String getBoardName(int cate_num) {
				String result = null;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					con = getConnection();
					
					String sql = "select cate_name from category where cate_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, cate_num);
					
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						CateDTO category = new CateDTO();
						category.setCate_name(rs.getString("cate_name"));
						
						result = category.getCate_name();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
					if(con != null) try {con.close();} catch(Exception e) {}
				}
				return result;
			}
			// 게시판 추가하기
			public int addboard(int cate_code, String cate_name) {
				int result = 0;
				Connection con = null;
				PreparedStatement pstmt = null;
				
				
				try {
					con = getConnection();
					
					String sql = "insert into category values(CATEGORY_SEQ.nextval, ?, ?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, cate_code);
					pstmt.setString(2, cate_name);
					
					result = pstmt.executeUpdate();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
					if(con != null) try {con.close();} catch(Exception e) {}
				}
				return result;
			}
			
			// 게시판 삭제하기
			public int killboard(int cate_num) {
				int result = 0;
				Connection con = null;
				PreparedStatement pstmt = null;
				
				
				try {
					con = getConnection();
					
					String sql = "delete from category where cate_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, cate_num);
					
					result = pstmt.executeUpdate();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
					if(con != null) try {con.close();} catch(Exception e) {}
				}
				return result;
			}

}
