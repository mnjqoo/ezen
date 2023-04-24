package com.edu.member.dto;

import org.springframework.stereotype.Component;

@Component("memberDTO")
public class MemberDTO {
	
	private String user_email; //개인/업체 이메일
	private String user_pwd; //비밀번호
	private String user_name; //이름
	private String user_phone; //휴대폰번호
	private String user_birthdate; //생년월일
	private String user_type; //고객 타입
	
	private String license_num; //기사 면허번호
	private String license_date; //기사 면허 취득 날짜
	private String user_image; //기사 사진
	private int order_count; //주문 완료 건수
	private int raiting_avg; //기사 평균 별점
	private String image; //기사 이미지 이름
	
	

	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_birthdate() {
		return user_birthdate;
	}
	public void setUser_birthdate(String user_birthdate) {
		this.user_birthdate = user_birthdate;
	}
	
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getLicense_date() {
		return license_date;
	}
	public void setLicense_date(String license_date) {
		this.license_date = license_date;
	}
	public String getUser_image() {
		return user_image;
	}
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public int getRaiting_avg() {
		return raiting_avg;
	}
	public void setRaiting_avg(int raiting_avg) {
		this.raiting_avg = raiting_avg;
	}
	public String getLicense_num() {
		return license_num;
	}
	public void setLicense_num(String license_num) {
		this.license_num = license_num;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "MemberDTO [user_email=" + user_email + ", user_pwd=" + user_pwd + ", user_name=" + user_name
				+ ", user_phone=" + user_phone + ", user_birthdate=" + user_birthdate + ", user_type=" + user_type
				+ ", license_num=" + license_num + ", license_date=" + license_date + ", user_image=" + user_image
				+ ", order_count=" + order_count + ", raiting_avg=" + raiting_avg + ", image=" + image + "]";
	}

	

}
