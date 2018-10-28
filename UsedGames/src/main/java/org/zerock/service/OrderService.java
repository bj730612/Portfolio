package org.zerock.service;

import java.util.List;

import org.zerock.domain.OrderVO;

public interface OrderService {
	
	public void insertOrder(OrderVO orderVO) throws Exception;
	
	public void updateOrder(OrderVO orderVO) throws Exception;
	
	public void deleteOrder(int idx) throws Exception;
	
	public List<OrderVO> listOrder(int userIdx) throws Exception;
	
	public int sumCost(int userIdx) throws Exception;
	
	public void duplicateUpdateOrder(OrderVO orderVO) throws Exception;

	public int countOrder(OrderVO orderVO) throws Exception;
}
