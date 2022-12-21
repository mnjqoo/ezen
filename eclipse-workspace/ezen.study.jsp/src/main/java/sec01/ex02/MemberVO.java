package sec01.ex02;

import java.sql.Date;

public class MemberVO { //Value Object

	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberVO() {//기본생성자
		
		System.out.println("MemberVO 생성자를 호출하였습니다.");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "MemberVO [아이디 : " + id + ", 비밀번호 : " + pwd + ", 이름 : " + name + ", 이메일 : " + email + ", 가입날짜 : " + joinDate
				+ "]";
	}
	
	
}
