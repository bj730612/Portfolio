package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.OrderVO;
import org.zerock.domain.PaymentTypeVO;

public interface OrderDAO {
	
	public void insertOrderMt(OrderVO orderVO) throws Exception;
	
	public void insertOrderDt(OrderVO orderVO) throws Exception;
	
	public void updateOrder(OrderVO orderVO) throws Exception;
	
	public void deleteOrder(int idx) throws Exception;
	
	public List<OrderVO> listOrder(int memberIdx) throws Exception;
	
	public int sumCost(int memberIdx) throws Exception;
	 
	public int countOrder(OrderVO orderVO) throws Exception;
	
	public void duplicateUpdateOrder(OrderVO orderVO) throws Exception;
	
	public List<PaymentTypeVO> selectPaymentType() throws Exception;
}
