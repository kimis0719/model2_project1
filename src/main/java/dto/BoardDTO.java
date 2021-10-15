// DTO (data transfer object)

package dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int board_num;
	private String board_title;
	private String board_content;
	private int board_memnum;
	private String board_nick;
	private Timestamp board_date;
	private int board_count;
	private int board_good;
	private int board_bad;
	private int board_up_memnum;
	private Timestamp board_up_date;
	private String board_yn;
	private int cate_num;
	
	public int getBoard_num() {
		return board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public int getBoard_memnum() {
		return board_memnum;
	}
	public String getBoard_nick() {
		return board_nick;
	}
	public Timestamp getBoard_date() {
		return board_date;
	}
	public int getBoard_count() {
		return board_count;
	}
	public int getBoard_good() {
		return board_good;
	}
	public int getBoard_bad() {
		return board_bad;
	}
	public int getBoard_up_memnum() {
		return board_up_memnum;
	}
	public Timestamp getBoard_up_date() {
		return board_up_date;
	}
	public String getBoard_yn() {
		return board_yn;
	}
	public int getCate_num() {
		return cate_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public void setBoard_memnum(int board_memnum) {
		this.board_memnum = board_memnum;
	}
	public void setBoard_nick(String board_nick) {
		this.board_nick = board_nick;
	}
	public void setBoard_date(Timestamp board_date) {
		this.board_date = board_date;
	}
	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}
	public void setBoard_good(int board_good) {
		this.board_good = board_good;
	}
	public void setBoard_bad(int board_bad) {
		this.board_bad = board_bad;
	}
	public void setBoard_up_memnum(int board_up_memnum) {
		this.board_up_memnum = board_up_memnum;
	}
	public void setBoard_up_date(Timestamp board_up_date) {
		this.board_up_date = board_up_date;
	}
	public void setBoard_yn(String board_yn) {
		this.board_yn = board_yn;
	}
	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}
	
	

}
