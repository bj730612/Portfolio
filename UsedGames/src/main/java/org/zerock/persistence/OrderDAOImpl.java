package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.OrderVO;
import org.zerock.domain.PaymentTypeVO;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Inject
    private SqlSession sqlSession;
    
    private static final String NAMESPACE = "org.zerock.mapper.OrderMapper";

    //장바구니 추가    
    @Override
	public void insertOrder(OrderVO orderVO) throws Exception {
		sqlSession.insert(NAMESPACE+".insertOrder", orderVO);
	}
    
    //장바구니 목록
    @Override
    public List<OrderVO> listOrder(int memberIdx) throws Exception {
        return sqlSession.selectList(NAMESPACE+".listOrder", memberIdx);
    }
    
    //장바구니 삭제
    @Override
    public void deleteOrder(int orderIdx) {
        sqlSession.delete(NAMESPACE + ".deleteOrder", orderIdx);
    }
    
    //장바구니 수정
    @Override
    public void updateOrder(OrderVO orderVO) {
        sqlSession.update(NAMESPACE + ".updateOrder",orderVO);
    }
    
    //장바구니 금액 합계
    @Override
    public int sumCost(int memberIdx) {
        sqlSession.selectOne(NAMESPACE + ".sumCost", memberIdx);
        return sqlSession.selectOne(NAMESPACE + ".sumCost", memberIdx);
    }
    
    //장바구니 동일한 상품 레코드 확인
    @Override
    public int countOrder(OrderVO orderVO) {
        return sqlSession.selectOne(NAMESPACE + ".countOrder", orderVO);
    }
    
    //장바구니 상품수량 변경
    @Override
    public void duplicateUpdateOrder(OrderVO orderVO) {
        sqlSession.update(NAMESPACE + ".duplicateUpdateOrder", orderVO);
    }
    
	@Override
	public List<PaymentTypeVO> selectPaymentType() throws Exception {
		return sqlSession.selectList(NAMESPACE+".selectPaymentType");
	}
}
