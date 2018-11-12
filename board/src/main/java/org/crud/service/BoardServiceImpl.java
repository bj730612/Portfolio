package org.crud.service;

import java.util.List;

import javax.inject.Inject;

import org.crud.domain.BoardVO;
import org.crud.persistence.BoardDAO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO boardVO) throws Exception {
		dao.create(boardVO);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}
	
	@Override
	public void modify(BoardVO boardVO) throws Exception {
		dao.update(boardVO);
	}
	
	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

}
