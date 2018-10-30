package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.CartVO;
import org.zerock.persistence.CartDAO;

@Service
public class CartServiceImpl implements CartService {

    @Inject
    private CartDAO cartDAO;

    //장바구니 추가
    @Override
    public void insertCart(CartVO cartVO) throws Exception {
        cartDAO.insertCart(cartVO);
    }
    //장바구니 목록
    @Override
    public List<CartVO> listCart(int memberIdx) throws Exception {
        return cartDAO.listCart(memberIdx);
    }
    //장바구니 삭제
    @Override
    public void deleteCart(int idx) throws Exception {
        cartDAO.deleteCart(idx);
    }
    //장바구니 수정
    @Override
    public void updateCart(CartVO cartVO) throws Exception {
        cartDAO.updateCart(cartVO);
    }
    //장바구니 금액 합계
    @Override
    public int sumCost(int memberIdx) throws Exception {
        return cartDAO.sumCost(memberIdx);
    }
    //장바구니 상품 확인
    @Override
    public int countCart(CartVO cartVO) throws Exception {
        return cartDAO.countCart(cartVO);
    }
    //장바구니 상품 수량 변경
    @Override
    public void duplicateUpdateCart(CartVO cartVO) throws Exception {
        cartDAO.duplicateUpdateCart(cartVO);
    }
}