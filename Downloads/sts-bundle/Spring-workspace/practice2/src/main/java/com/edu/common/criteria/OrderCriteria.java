package com.edu.common.criteria;

//나의 orderList에 활용할 criteria
public class OrderCriteria  extends Criteria{
	
	private String user_email;
	private String user_type;
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "OrderCriteria [user_email=" + user_email + ", user_type=" + user_type + "]";
	}
	
	
}
