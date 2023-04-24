package com.edu.order.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.edu.common.criteria.OrderArrayCriteria;
import com.edu.common.criteria.SearchArrayCriteria;
import com.edu.order.dao.OrderDAO;
import com.edu.order.dto.OrderDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Inject
	OrderDAO orderDAO;
	
	@Override
	public String calcPrice(String truck_type, String distance) throws Exception {
		System.out.println("OrderServiceImpl의 calcPrice() 시작...");
		
		//mapper로 보내주기 전에 hashmap에 담아준다.
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("truck_type", truck_type);
		data.put("distance", distance);
		
		return orderDAO.calcPrice(data);
	}

	@Override
	public int orderRegister(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderServiceImpl의 orderRegister() 시작...");
		
		return orderDAO.orderRegister(orderDTO);
	}

	@Override
	public List<OrderDTO> getOrderList(SearchArrayCriteria sCri) throws Exception {
		System.out.println("OrderServiceImpl의 getOrderList() 시작...");
		
		return orderDAO.getOrderList(sCri);
	}

	@Override
	public long getOrderNum() throws Exception {
		System.out.println("OrderServiceImpl의 getOrderNum()....");
		
		//현재 날짜를 구해서 DB의 날짜 형태로 만든다. ex)1999-01-01
		Calendar cal = Calendar.getInstance(); //날짜 정보를 얻기 위한 캘린더 인스턴스
		String date = cal.get(Calendar.YEAR) + "-";
		date += new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1) + "-";
		date += new DecimalFormat("00").format(cal.get(Calendar.DATE));
		System.out.println("현재 날짜: " + date);
		
		//현재 날짜에 해당하는 운송 건수가 없으면
		if(orderDAO.orderDateCount(date) == 0) {
			System.out.println("주문 건수 없음");
			
			//날짜뒤에 001을 붙이고 '-'를 제거한 뒤 숫자로 바꿔서 리턴한다.
			date = date + "001";
			date = date.replaceAll("[-]", "");
			long result = Long.parseLong(date);
			return result;
			
		} else { //건수가 있으면
			System.out.println("주문 건수 있음");
			
			//가장 큰 주문번호 + 1 한 값을 가져와 리턴한다.\
			return orderDAO.getMaxOrderNum();
			
		}
	}

	@Override
	public int getTotalListCount(SearchArrayCriteria saCri) throws Exception {
		System.out.println("OrderServiceImpl의 checkDriverTime()....");
		
		return orderDAO.getTotalListCount(saCri);
	}

	@Override
	public boolean checkDriverTime(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderServiceImpl의 checkDriverTime()...." + orderDTO.getEstimated_time());
		
		//해당 기사의 예약중인 리스트를 가져온다.
		List<OrderDTO> driverList = orderDAO.getDriverOrderList(orderDTO.getDriver_email());
		
		Calendar cal = Calendar.getInstance(); //날짜 정보를 얻기 위한 캘린더 인스턴스
		
		//들어온 날짜를 준비한다.
		String date = orderDTO.getEstimated_time().substring(0, 11).replace("-", "");
		
		//들어온 시각을 준비한다.
		String time = orderDTO.getEstimated_time().substring(12).replace(":", "");
		//========================================================================================
		
		int count = 0;
		
		//for문을 통해서 비교를 진행한다.
		for(int i = 0; i < driverList.size(); i++) {
			
			//운송 상태가 4가 아닌 것들에 대해 비교한다.
			if(!driverList.get(i).getOrder_state().equals("4")) {
				//예약된 건의 날짜를 준비한다.
				String estimatedDate = driverList.get(i).getEstimated_time().substring(0, 11).replace("-", "");
				//예약된 건의 시간을 준비한다.
				String estimatedTime = driverList.get(i).getEstimated_time().substring(12).replace(":", "");
				
				if(date.compareTo(estimatedDate) == 0) {
					//날짜가 같을 때는 시간을 바로 비교한다.
					if(time.compareTo(estimatedTime) < 0) {
						//들어온 숫자가 더 작으면(더 이른 시간)
						count++;
					}
				} else if(date.compareTo(estimatedDate) < 0){
					//들어온 날짜가 더 작으면 
					count++;
				}
			}	
		}
		
		if(count == 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public int bookOrder(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderServiceImpl의 bookOrder()....");
		
		return orderDAO.bookOrder(orderDTO);
	}

	@Override
	public List<OrderDTO> myOrderList(OrderArrayCriteria oCri) throws Exception {
		System.out.println("OrderServiceImpl의 myOrderList()....");
		
		return orderDAO.myOrderList(oCri);
	}

	@Override
	public int getMyListCount(OrderArrayCriteria oCri) throws Exception {
		System.out.println("OrderServiceImpl의 getMyListCount()....");
		
		return orderDAO.getMyListCount(oCri);
	}

	@Override
	public OrderDTO getOrderDTO(Long order_num) throws Exception {
		System.out.println("OrderServiceImpl의 getOrderDTO()....");
		
		return orderDAO.getOrderDTO(order_num);
	}

	@Override
	public int orderStateUpdate(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderServiceImpl의 orderStateUpdate()....");
		
		//운송 상태가 '4'일때(완료일때) 도착 시간을 세팅해준다.
		if(orderDTO.getOrder_state().equals("4")) {
			
			//현재 날짜
			LocalDate nowDate = LocalDate.now();
			//포멧정의
			DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// 포맷 적용
			String formatedDate = nowDate.format(dateformatter);
			 
			//현재 시간
			LocalTime nowTime = LocalTime.now();
			//포멧정의
			DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");
			// 포맷 적용
			String formatedTime = nowTime.format(timeformatter);
			
			//날짜와 시간을 합쳐준다.
			String formatedNow = formatedDate + " " + formatedTime;
			System.out.println("도착 날짜와 시간: " + formatedNow);
			
			orderDTO.setArrived_time(formatedNow);
		}
		
		return orderDAO.orderStateUpdate(orderDTO);
	}

}
