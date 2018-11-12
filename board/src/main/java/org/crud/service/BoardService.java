package org.crud.service;

import java.util.List;

import org.crud.domain.BoardVO;

public interface BoardService {
	
	public void regist(BoardVO boardVO) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void modify(BoardVO boardVO) throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;

}
