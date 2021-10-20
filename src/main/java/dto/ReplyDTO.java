package dto;

import java.sql.Timestamp;

public class ReplyDTO {
	private int re_num;
	private String re_writer;
	private Timestamp re_date;
	private int re_seq;
	private int re_level;
	private int re_ref;
	private String re_yn;
	private int board_num;
	private String re_content;

	public int getRe_num() {
		return re_num;
	}
	public String getRe_writer() {
		return re_writer;
	}
	public Timestamp getRe_date() {
		return re_date;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public int getRe_level() {
		return re_level;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public String getRe_yn() {
		return re_yn;
	}
	public int getBoard_num() {
		return board_num;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public void setRe_writer(String re_writer) {
		this.re_writer = re_writer;
	}
	public void setRe_date(Timestamp re_date) {
		this.re_date = re_date;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public void setRe_yn(String re_yn) {
		this.re_yn = re_yn;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	
	
}
