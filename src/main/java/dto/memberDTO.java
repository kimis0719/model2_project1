// DTO(Data Transfer Object) 클래스

package dto;

import java.sql.Timestamp;
import java.util.Date;

public class memberDTO {

	    private String mem_num;
	    private String mem_id;
	    private String mem_nick;
	    private String mem_pass;
	    private String mem_email;
	    private Date mem_date;
	    private String mem_img;
	    private String mem_phone;
	    private String mem_up_memnum;
	    private Date mem_up_date;
	    private String mem_yn;
	    private String mem_grade;
	    
		public String getMem_num() {
			return mem_num;
		}
		public void setMem_num(String mem_num) {
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
		public Date getMem_date() {
			return mem_date;
		}
		public void setMem_date(Date mem_date) {
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
		public String getMem_up_memnum() {
			return mem_up_memnum;
		}
		public void setMem_up_memnum(String mem_up_memnum) {
			this.mem_up_memnum = mem_up_memnum;
		}
		public Date getMem_up_date() {
			return mem_up_date;
		}
		public void setMem_up_date(Date mem_up_date) {
			this.mem_up_date = mem_up_date;
		}
		public String getMem_yn() {
			return mem_yn;
		}
		public void setMem_yn(String mem_yn) {
			this.mem_yn = mem_yn;
		}
		public String getMem_grade() {
			return mem_grade;
		}
		public void setMem_grade(String mem_grade) {
			this.mem_grade = mem_grade;
		}
	    
		
}
