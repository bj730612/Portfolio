package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.ReviewMapper";
	
	//�뙎湲� �깮�꽦
	@Override
	public void insertReview(ReviewVO reviewVO) throws Exception {
		sqlSession.insert(namespace+".insertReview", reviewVO);
	}
	
	//�뙎湲� 由ъ뒪�듃
	@Override
	public List<ReviewVO> selectReview(int boardIdx) throws Exception {
		return sqlSession.selectList(namespace+".selectReview", boardIdx);
	}
	
	// 수정
	@Override
	public void updateReview(ReviewVO reviewVO) throws Exception {
		sqlSession.update(namespace + ".updateReview", reviewVO);
	}

	// 삭제
	@Override
	public void deleteReview(int idx) throws Exception {
		sqlSession.delete(namespace + ".deleteReview", idx);
	}
	
}
