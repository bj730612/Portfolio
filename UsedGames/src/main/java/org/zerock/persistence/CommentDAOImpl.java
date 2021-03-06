package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.CommentMapper";
	
	//�뙎湲� �깮�꽦
	@Override
	public void insertComment(CommentVO commnetVO) throws Exception {
		sqlSession.insert(namespace+".insertComment", commnetVO);
	}
	
	//�뙎湲� 由ъ뒪�듃
	@Override
	public List<CommentVO> selectComment(int boardIdx) throws Exception {
		return sqlSession.selectList(namespace+".selectComment", boardIdx);
	}
	
}
