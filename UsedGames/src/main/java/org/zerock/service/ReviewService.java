package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReviewVO;

public interface ReviewService {

	//�뙎湲� �깮�꽦
	public void insertReview(ReviewVO reviewVO) throws Exception;
		
	//�뙎湲� 由ъ뒪�듃
	public List<ReviewVO> selectReview(int boardIdx) throws Exception;
	
}
