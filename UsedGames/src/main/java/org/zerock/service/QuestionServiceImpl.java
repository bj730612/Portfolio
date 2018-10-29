package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.QuestionVO;
import org.zerock.persistence.QuestionDAO;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Inject
	private QuestionDAO questionDAO;
	
	//�뙎湲� �깮�꽦
	@Override
	public void insertQuestion(QuestionVO questionVO) throws Exception {
		questionDAO.insertQuestion(questionVO);
	}
		
	//�뙎湲� 由ъ뒪�듃
	@Override
	public List<QuestionVO> selectQuestion(int boardIdx) throws Exception {	
		return questionDAO.selectQuestion(boardIdx);
	}
	
	//게시글 수정
	@Override
	public void updateQuestion(QuestionVO questionVO) throws Exception {
		questionDAO.updateQuestion(questionVO);
	}
	
	//게시글 삭제
	@Override
	public void deleteQuestion(int idx) throws Exception {
		questionDAO.deleteQuestion(idx);
	}
	
}
