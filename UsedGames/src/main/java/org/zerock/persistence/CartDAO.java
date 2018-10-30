package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.CartVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PostVO;
import org.zerock.domain.SearchVO;

public interface CartDAO {
	
	public void insertCart(CartVO cartVO) throws Exception;
	
	public void updateCart(CartVO cartVO) throws Exception;
	
	public void deleteCart(int idx) throws Exception;
	
	public List<CartVO> listCart(int memberIdx) throws Exception;
	
	public int sumCost(int memberIdx) throws Exception;
	 
	public int countCart(CartVO cartVO) throws Exception;
	
	public void duplicateUpdateCart(CartVO cartVO) throws Exception;
}
