package com.edu.order.dto;

import java.sql.Timestamp;

public class OrderDTO {

	private long order_num;
	private String client_email;
	private String driver_email;
	private Timestamp order_date;
	private String departure_postnum;
	private String departure_address1;
	private String departure_address2;
	private String arrival_postnum;
	private String arrival_address1;
	private String arrival_address2;
	private String order_memo;
	private String distance;
	private String truck_type;
	private String order_price;
	private String departure_date;
	private String estimated_time;
	private String arrived_time;
	private String order_state;
	private String review_YN = "N"; //기본값은 N
	
	
	
	
	public long getOrder_num() {
		return order_num;
	}
	public void setOrder_num(long order_num) {
		this.order_num = order_num;
	}
	public String getClient_email() {
		return client_email;
	}
	public void setClient_email(String client_email) {
		this.client_email = client_email;
	}
	public String getDriver_email() {
		return driver_email;
	}
	public void setDriver_email(String driver_email) {
		this.driver_email = driver_email;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public String getDeparture_postnum() {
		return departure_postnum;
	}
	public void setDeparture_postnum(String departure_postnum) {
		this.departure_postnum = departure_postnum;
	}
	public String getDeparture_address1() {
		return departure_address1;
	}
	public void setDeparture_address1(String departure_address1) {
		this.departure_address1 = departure_address1;
	}
	public String getDeparture_address2() {
		return departure_address2;
	}
	public void setDeparture_address2(String departure_address2) {
		this.departure_address2 = departure_address2;
	}
	public String getArrival_postnum() {
		return arrival_postnum;
	}
	public void setArrival_postnum(String arrival_postnum) {
		this.arrival_postnum = arrival_postnum;
	}
	public String getArrival_address1() {
		return arrival_address1;
	}
	public void setArrival_address1(String arrival_address1) {
		this.arrival_address1 = arrival_address1;
	}
	public String getArrival_address2() {
		return arrival_address2;
	}
	public void setArrival_address2(String arrival_address2) {
		this.arrival_address2 = arrival_address2;
	}
	public String getOrder_memo() {
		return order_memo;
	}
	public void setOrder_memo(String order_memo) {
		this.order_memo = order_memo;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTruck_type() {
		return truck_type;
	}
	public void setTruck_type(String truck_type) {
		this.truck_type = truck_type;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	public String getEstimated_time() {
		return estimated_time;
	}
	public void setEstimated_time(String estimated_time) {
		this.estimated_time = estimated_time;
	}
	public String getArrived_time() {
		return arrived_time;
	}
	public void setArrived_time(String arrived_time) {
		this.arrived_time = arrived_time;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getReview_YN() {
		return review_YN;
	}
	public void setReview_YN(String review_YN) {
		this.review_YN = review_YN;
	}
	@Override
	public String toString() {
		return "OrderDTO [order_num=" + order_num + ", client_email=" + client_email + ", driver_email=" + driver_email
				+ ", order_date=" + order_date + ", departure_postnum=" + departure_postnum + ", departure_address1="
				+ departure_address1 + ", departure_address2=" + departure_address2 + ", arrival_postnum="
				+ arrival_postnum + ", arrival_address1=" + arrival_address1 + ", arrival_address2=" + arrival_address2
				+ ", order_memo=" + order_memo + ", distance=" + distance + ", truck_type=" + truck_type
				+ ", order_price=" + order_price + ", departure_date=" + departure_date + ", estimated_time="
				+ estimated_time + ", arrived_time=" + arrived_time + ", order_state=" + order_state + ", review_YN="
				+ review_YN + "]";
	}
	
}
