package org.zerock.service;

import java.util.List;

import org.zerock.domain.QuestionVO;

public interface QuestionService {

	//�뙎湲� �깮�꽦
	public void insertQuestion(QuestionVO questionVO) throws Exception;
		
	//�뙎湲� 由ъ뒪�듃
	public List<QuestionVO> selectQuestion(int boardIdx) throws Exception;
	
	
	//수정
	public void updateQuestion(QuestionVO questionVO) throws Exception;
	
	//삭제
	public void deleteQuestion(int idx) throws Exception;
}
