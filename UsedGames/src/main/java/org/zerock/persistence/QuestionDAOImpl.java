package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.QuestionVO;

@Repository
public class QuestionDAOImpl implements QuestionDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.QuestionMapper";
	
	//�뙎湲� �깮�꽦
	@Override
	public void insertQuestion(QuestionVO questionVO) throws Exception {
		sqlSession.insert(namespace+".insertQuestion", questionVO);
	}
	
	//�뙎湲� 由ъ뒪�듃
	@Override
	public List<QuestionVO> selectQuestion(int boardIdx) throws Exception {
		return sqlSession.selectList(namespace+".selectQuestion", boardIdx);
	}
	
	// 수정
	@Override
	public void updateQuestion(QuestionVO questionVO) throws Exception {
		sqlSession.update(namespace + ".updateQuestion", questionVO);
	}

	// 삭제
	@Override
	public void deleteQuestion(int idx) throws Exception {
		sqlSession.delete(namespace + ".deleteQuestion", idx);
	}
	
}
