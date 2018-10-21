package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.CommentVO;
import org.zerock.persistence.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Inject
	private CommentDAO commentDAO;
	
	//�뙎湲� �깮�꽦
	@Override
	public void insertComment(CommentVO commentVO) throws Exception {
		commentDAO.insertComment(commentVO);
	}
		
	//�뙎湲� 由ъ뒪�듃
	@Override
	public List<CommentVO> selectComment(int boardIdx) throws Exception {	
		return commentDAO.selectComment(boardIdx);
	}
	
}
