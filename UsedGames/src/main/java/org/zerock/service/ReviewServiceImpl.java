package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.ReviewVO;
import org.zerock.persistence.ReviewDAO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Inject
	private ReviewDAO reviewDAO;
	
	//�뙎湲� �깮�꽦
	@Override
	public void insertReview(ReviewVO reviewVO) throws Exception {
		reviewDAO.insertReview(reviewVO);
	}
		
	//�뙎湲� 由ъ뒪�듃
	@Override
	public List<ReviewVO> selectReview(int boardIdx) throws Exception {	
		return reviewDAO.selectReview(boardIdx);
	}
	
	//게시글 수정
	@Override
	public void updateReview(ReviewVO reviewVO) throws Exception {
		reviewDAO.updateReview(reviewVO);
	}
	
	//게시글 삭제
	@Override
	public void deleteReview(int idx) throws Exception {
		reviewDAO.deleteReview(idx);
	}
	
}
