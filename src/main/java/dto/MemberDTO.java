package dto;

import java.sql.Timestamp;

public class MemberDTO {
	private int mem_num;
	private String mem_id;
	private String mem_nick;
	private String mem_pass;
	private String mem_email;
	private Timestamp mem_date;
	private String mem_img;
	private String mem_phone;
	private int men_up_memnum;
	private Timestamp mem_up_date;
	private String mem_yn;
	private int mem_grade;
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public Timestamp getMem_date() {
		return mem_date;
	}
	public void setMem_date(Timestamp mem_date) {
		this.mem_date = mem_date;
	}
	public String getMem_img() {
		return mem_img;
	}
	public void setMem_img(String mem_img) {
		this.mem_img = mem_img;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public int getMen_up_memnum() {
		return men_up_memnum;
	}
	public void setMen_up_memnum(int men_up_memnum) {
		this.men_up_memnum = men_up_memnum;
	}
	public Timestamp getMem_up_date() {
		return mem_up_date;
	}
	public void setMem_up_date(Timestamp mem_up_date) {
		this.mem_up_date = mem_up_date;
	}
	public String getMem_yn() {
		return mem_yn;
	}
	public void setMem_yn(String mem_yn) {
		this.mem_yn = mem_yn;
	}
	public int getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(int mem_grade) {
		this.mem_grade = mem_grade;
	}
}
