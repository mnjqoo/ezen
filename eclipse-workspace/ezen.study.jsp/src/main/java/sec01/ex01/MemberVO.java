package sec01.ex01;

import java.sql.Date;

//---------------------------------------------------------------------
//회원 정보 클래스
//VO: Value Object (값이 변하지 않는다.)
//DTO: Data Transfer Object (값을 변경 할 수 있다.)

public class MemberVO { 
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberVO() {
		System.out.println("MemberVO 생성자 호출");
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
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", joinDate=" + joinDate
				+ "]";
	}
	
	

}
//---------------------------------------------------------------------