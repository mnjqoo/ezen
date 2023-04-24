package com.edu.common.criteria;

//나의 orderList에 활용할 criteria
public class OrderArrayCriteria  extends Criteria{
	
	private String user_email;
	private String arrayType = "r"; //기본값은 r
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getArrayType() {
		return arrayType;
	}
	public void setArrayType(String arrayType) {
		this.arrayType = arrayType;
	}
	@Override
	public String toString() {
		return "OrderArrayCriteria [user_email=" + user_email + ", arrayType=" + arrayType + "]";
	}
	
}
