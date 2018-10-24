package org.zerock.service;

import java.util.List;

import org.zerock.domain.CartVO;

public interface CartService {
	
	public void insertCart(CartVO cartVO) throws Exception;
	
	public void updateCart(CartVO cartVO) throws Exception;
	
	public void deleteCart(int idx) throws Exception;
	
	public List<CartVO> listCart(int userIdx) throws Exception;
	
	public int sumCost(int userIdx) throws Exception;
	
	public void duplicateUpdateCart(CartVO cartVO) throws Exception;

	public int countCart(CartVO cartVO) throws Exception;
}
