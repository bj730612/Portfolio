package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.CommentVO;

public interface CommentDAO {
	
	// �뙎湲� �깮�꽦
	public void insertComment(CommentVO commentVO) throws Exception;
	
	// �뙎湲� 由ъ뒪�듃
	public List<CommentVO> selectComment(int boardIdx) throws Exception;

}
