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
    public List<CartVO> listCart(int userIdx) throws Exception {
        return cartDAO.listCart(userIdx);
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
    public int sumCost(int userIdx) throws Exception {
        return cartDAO.sumCost(userIdx);
    }
    //장바구니 상품 확인
    @Override
    public int countCart(int gameIdx, int userIdx) throws Exception {
        return cartDAO.countCart(gameIdx, userIdx);
    }
    //장바구니 상품 수량 변경
    @Override
    public void changeCart(CartVO cartVO) throws Exception {
        cartDAO.changeCart(cartVO);
    }
}