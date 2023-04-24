package com.edu.order.service;

import java.util.List;

import com.edu.common.criteria.OrderArrayCriteria;
import com.edu.common.criteria.SearchArrayCriteria;
import com.edu.order.dto.OrderDTO;

public interface OrderService {

	//결제 예상 금액 가져오기
	public String calcPrice(String truck_type, String distance) throws Exception;
	
	//운송 정보 등록하기
	public int orderRegister(OrderDTO orderDTO) throws Exception;
	
	//운송 데이터 리스트 가져오기
	public List<OrderDTO> getOrderList(SearchArrayCriteria saCri) throws Exception;
	
	//전체 운송 데이터 리스트 갯수 가져오기
	public int getTotalListCount(SearchArrayCriteria saCri) throws Exception;
	
	//order_num 가져오기
	public long getOrderNum() throws Exception;
	
	//기사가 예약을 잡기 전에 합당한지 검사하는 메소드
	public boolean checkDriverTime(OrderDTO orderDTO) throws Exception;
	
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
