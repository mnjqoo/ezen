package com.edu.order.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edu.common.criteria.OrderArrayCriteria;
import com.edu.common.criteria.PageMaker;
import com.edu.common.criteria.SearchArrayCriteria;
import com.edu.order.dto.OrderDTO;
import com.edu.order.service.OrderService;

@Controller("orderController")
@RequestMapping("/order")
public class OrderController {

	@Inject
	OrderService orderService;
	
	//운송 등록 페이지 이동하기
	@RequestMapping(value="/orderRegister.form", method=RequestMethod.GET)
	public ModelAndView orderRegisterForm() throws Exception {
		System.out.println("OrderController의 orderRegisterForm 불러오기...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/order/orderRegisterForm");
		
		return mav;
	}
	
	//트럭 종류, 거리를 이용해 db에서 금액 가져오기
	@ResponseBody
	@RequestMapping(value="/calcPrice.do", method=RequestMethod.POST)
	public String calcPrice(String truck_type, String distance) throws Exception {
		System.out.println("OrderController의 calcPrice() 시작...");
		
		return orderService.calcPrice(truck_type, distance);
	}
	
	//운송 예약 정보 등록하기
	@ResponseBody
	@RequestMapping(value="/orderRegister.do", method=RequestMethod.POST)
	public int orderRegister(OrderDTO orderDTO, HttpServletRequest request) throws Exception {
		System.out.println("OrderController의 orderRegister 불러오기...");
		
		//운송 번호를 세팅해준다.
		orderDTO.setOrder_num(orderService.getOrderNum());
		
		//해당 정보를 등록한다.
		int result = orderService.orderRegister(orderDTO);
		
		//운송정보를 등록한 후 세션을 대시 발급해준다.(예약한 운송 리스트)
		HttpSession session = request.getSession();
		OrderArrayCriteria oCri = new OrderArrayCriteria();
		oCri.setUser_email(orderDTO.getClient_email());
		session.setAttribute("myOrderSession", orderService.myOrderList(oCri));
		
		return result;
	}
	
	//운송 목록 페이지 이동하기 (전체 운송 목록 + 페이징 + 검색 처리 후 함께 보내주기)
	@RequestMapping(value="/orderList.form", method=RequestMethod.GET)
	public ModelAndView orderListForm(SearchArrayCriteria saCri) throws Exception {
		System.out.println("OrderController의 orderListForm 불러오기...");
		
		ModelAndView mav = new ModelAndView();
		
		//페이지 번호에 해당하는 리스트를 가져와서 model에 담아준다.
		mav.addObject("orderList", orderService.getOrderList(saCri));
		
		//pageMaker에 대한 세팅을 한다.(paging 처리를 위해)
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(saCri);	//Criteria 세팅
		pageMaker.setTotalCount(orderService.getTotalListCount(saCri));		//totalcount 세팅
		//model에 담아준다.
		mav.addObject("pageMaker", pageMaker);
		
		//정렬타입을 model에 담아준다.(select 박스에서 처리를 위해)
		mav.addObject("arrayType", saCri.getArrayType());
		
		mav.setViewName("/order/orderList");
		
		return mav;
	}
	
	//운송 예약 잡기(운전기사가)
	@ResponseBody
	@RequestMapping(value="/bookOrder.do", method=RequestMethod.POST)
	public int bookOrder(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderController의 bookOrder() 처리하기..." + orderDTO);
		
		//해당 기사의 예약중인 데이터가 있는지 찾고, 도착 예정 시간이 겹치지 않는지 확인 한다.
		if(orderService.checkDriverTime(orderDTO)) {
			//괜찮으면
			return orderService.bookOrder(orderDTO);
		} else {
			//아니면
			return -1;
		}
	}
	
	//운송 상세 페이지 이동하기 (운송DTO 함께 보내주기)
	@RequestMapping(value="/orderDetail.form", method=RequestMethod.GET)
	public ModelAndView orderDetailForm(Long order_num) throws Exception {
		System.out.println("OrderController의 orderDetailForm 불러오기..." + order_num);
		
		ModelAndView mav = new ModelAndView();
		
		//주문번호에 해당하는 orderDTO를 model에 담아준다.
		mav.addObject("orderDTO", orderService.getOrderDTO(order_num));
		
		mav.setViewName("/order/orderDetail");
		
		return mav;
	}	
	
	//운송 상태 업데이트 하기
	@ResponseBody
	@RequestMapping(value="/orderStateUpdate.do", method=RequestMethod.POST)
	public int orderStateUpdate(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderController의 orderStateUpdate 불러오기..." + orderDTO);
		
		return orderService.orderStateUpdate(orderDTO);
	}
}
