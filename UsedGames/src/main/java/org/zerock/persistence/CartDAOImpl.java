package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {

    @Inject
    private SqlSession sqlSession;
    
    private static final String NAMESPACE = "org.zerock.mapper.CartMapper";

    //장바구니 추가    
    @Override
	public void insertCart(CartVO cartVO) throws Exception {
		sqlSession.insert(NAMESPACE+".insertCart", cartVO);
	}
    
    //장바구니 목록
    @Override
    public List<CartVO> listCart(int memberIdx) throws Exception {
        return sqlSession.selectList(NAMESPACE+".listCart", memberIdx);
    }
    
    //장바구니 삭제
    @Override
    public void deleteCart(int cartIdx) {
        sqlSession.delete(NAMESPACE + ".deleteCart", cartIdx);
    }
    
    //장바구니 수정
    @Override
    public void updateCart(CartVO cartVO) {
        sqlSession.update(NAMESPACE + ".updateCart",cartVO);
    }
    
    //장바구니 금액 합계
    @Override
    public int sumCost(int memberIdx) {
        sqlSession.selectOne(NAMESPACE + ".sumCost", memberIdx);
        return sqlSession.selectOne(NAMESPACE + ".sumCost", memberIdx);
    }
    
    //장바구니 동일한 상품 레코드 확인
    @Override
    public int countCart(CartVO cartVO) {
        return sqlSession.selectOne(NAMESPACE + ".countCart", cartVO);
    }
    //장바구니 상품수량 변경
    @Override
    public void duplicateUpdateCart(CartVO cartVO) {
        sqlSession.update(NAMESPACE + ".duplicateUpdateCart", cartVO);
    }
}
