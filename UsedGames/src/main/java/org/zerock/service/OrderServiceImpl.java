package org.zerock.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.OrderVO;
import org.zerock.domain.PaymentTypeVO;
import org.zerock.persistence.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDAO orderDAO;

    //장바구니 추가
    @Override
    public void insertOrderMt(OrderVO orderVO) throws Exception {
        orderDAO.insertOrderMt(orderVO);
    }
    
    @Override
    public void insertOrderDt(Map<String, Object> listOrderVO) throws Exception {
        orderDAO.insertOrderDt(listOrderVO);
    }
    
    @Override
    public int selectOrderMtLastIdx(OrderVO orderVO) throws Exception {
        return orderDAO.selectOrderMtLastIdx(orderVO);
    }
    
    //장바구니 목록
    @Override
    public List<OrderVO> listOrder(int memberIdx) throws Exception {
        return orderDAO.listOrder(memberIdx);
    }
    
    //장바구니 삭제
    @Override
    public void deleteOrder(int idx) throws Exception {
        orderDAO.deleteOrder(idx);
    }
    
    //장바구니 수정
    @Override
    public void updateOrder(OrderVO orderVO) throws Exception {
        orderDAO.updateOrder(orderVO);
    }
    
    //장바구니 금액 합계
    @Override
    public int sumCost(int memberIdx) throws Exception {
        return orderDAO.sumCost(memberIdx);
    }
    
    //장바구니 상품 확인
    @Override
    public int countOrder(OrderVO orderVO) throws Exception {
        return orderDAO.countOrder(orderVO);
    }
    
    //장바구니 상품 수량 변경
    @Override
    public void duplicateUpdateOrder(OrderVO orderVO) throws Exception {
        orderDAO.duplicateUpdateOrder(orderVO);
    }
    
	@Override
	public List<PaymentTypeVO> selectPaymentType() throws Exception {
		return orderDAO.selectPaymentType();
	}
}