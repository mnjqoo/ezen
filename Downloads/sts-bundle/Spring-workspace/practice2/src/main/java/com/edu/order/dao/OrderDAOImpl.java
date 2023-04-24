package com.edu.order.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.common.criteria.OrderArrayCriteria;
import com.edu.common.criteria.SearchArrayCriteria;
import com.edu.order.dto.OrderDTO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.edu.order";
	
	@Override
	public String calcPrice(HashMap<String, String> data) throws Exception {
		System.out.println("OrderDAOImpl의 calcPrice() 시작...");
		
		return sqlSession.selectOne(Namespace + ".calcPrice", data);
	}

	@Override
	public int orderRegister(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderDAOImpl의 orderRegister() 시작...");
		
		return sqlSession.insert(Namespace + ".orderRegister", orderDTO);
	}

	@Override
	public List<OrderDTO> getOrderList(SearchArrayCriteria saCri) throws Exception {
		System.out.println("OrderDAOImpl의 getOrderList() 시작...");
		
		return sqlSession.selectList(Namespace + ".getOrderList", saCri);
	}

	@Override
	public int orderDateCount(String date) throws Exception {
		System.out.println("OrderDAOImpl의 orderDateCount()....");
		
		return sqlSession.selectOne(Namespace + ".orderDateCount", date);
	}

	@Override
	public int getTotalListCount(SearchArrayCriteria saCri) throws Exception {
		System.out.println("OrderDAOImpl의 getTotalListCount()....");
		
		return sqlSession.selectOne(Namespace + ".getTotalListCount", saCri);
	}

	@Override
	public long getMaxOrderNum() throws Exception {
		System.out.println("OrderDAOImpl의 getMaxOrderNum()....");
		
		return sqlSession.selectOne(Namespace + ".getMaxOrderNum");
	}

	@Override
	public List<OrderDTO> getDriverOrderList(String email) throws Exception {
		System.out.println("OrderDAOImpl의 getDriverOrderList()....");
		
		return sqlSession.selectList(Namespace + ".getDriverOrderList", email);
	}

	@Override
	public int bookOrder(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderDAOImpl의 bookOrder()....");
		
		return sqlSession.update(Namespace + ".bookOrder", orderDTO);
	}

	@Override
	public List<OrderDTO> myOrderList(OrderArrayCriteria oCri) throws Exception {
		System.out.println("OrderDAOImpl의 myOrderList() 시작..." + oCri);
		
		return sqlSession.selectList(Namespace + ".myOrderList", oCri);
	}

	@Override
	public int getMyListCount(OrderArrayCriteria oCri) throws Exception {
		System.out.println("OrderDAOImpl의 getMyListCount()....");
		
		return sqlSession.selectOne(Namespace + ".getMyListCount", oCri);
	}

	@Override
	public OrderDTO getOrderDTO(Long order_num) throws Exception {
		System.out.println("OrderDAOImpl의 getOrderDTO() 시작...");
		
		return sqlSession.selectOne(Namespace + ".getOrderDTO", order_num);
	}

	@Override
	public int orderStateUpdate(OrderDTO orderDTO) throws Exception {
		System.out.println("OrderDAOImpl의 orderStateUpdate()....");
		
		return sqlSession.update(Namespace + ".orderStateUpdate", orderDTO);
	}

}
