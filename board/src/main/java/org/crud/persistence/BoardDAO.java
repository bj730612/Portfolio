package org.crud.persistence;

import java.util.List;

import org.crud.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO boardVO) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;

}
