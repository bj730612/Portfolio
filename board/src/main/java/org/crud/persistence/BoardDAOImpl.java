package org.crud.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.crud.domain.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.crud.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO boardVO) throws Exception {
		session.insert(namespace+".create", boardVO);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read", bno);
	}
	
	@Override
	public void update(BoardVO boardVO) throws Exception {
		session.update(namespace+".create", boardVO);
	}
	
	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".create", bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

}
