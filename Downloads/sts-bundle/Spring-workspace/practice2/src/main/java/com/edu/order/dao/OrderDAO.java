package com.edu.order.dao;

import java.util.HashMap;
import java.util.List;

import com.edu.common.criteria.OrderArrayCriteria;
import com.edu.common.criteria.SearchArrayCriteria;
import com.edu.order.dto.OrderDTO;

public interface OrderDAO {
	
	//운송 예상 결제 금액 가져오기
	public String calcPrice(HashMap<String, String> data) throws Exception;
	
	//운송 정보 등록하기
	public int orderRegister(OrderDTO orderDTO) throws Exception;	

	//운송 데이터 리스트 가져오기
	public List<OrderDTO> getOrderList(SearchArrayCriteria saCri) throws Exception;

	//전체 운송 데이터 리스트 갯수 가져오기
	public int getTotalListCount(SearchArrayCriteria saCri) throws Exception;	
	
	//날짜에 해당하는 운송 건수 가져오기
	public int orderDateCount(String date) throws Exception;
	
	//가장 큰 운송 번호 +1 가져오기
	public long getMaxOrderNum() throws Exception;
	
	//운전기사의 예약중인 건수 리스트 가져오기
	public List<OrderDTO> getDriverOrderList(String email) throws Exception;
	
	//운송 예약잡기(운전자가)
	public int bookOrder(OrderDTO orderDTO) throws Exception;
	
	//나의 운송 목록 가져오기
	public List<OrderDTO> myOrderList(OrderArrayCriteria oCri) throws Exception;

	//나의 운송 데이터 리스트 갯수 가져오기
	public int getMyListCount(OrderArrayCriteria oCri) throws Exception;	
	
	//운송 번호에 해당하는 orderDTO  가져오기
	public OrderDTO getOrderDTO(Long order_num) throws Exception;	
	
	//운송상태 업데이트 하기
	public int orderStateUpdate(OrderDTO orderDTO) throws Exception;
}
