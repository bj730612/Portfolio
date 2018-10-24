package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.GameCategory2VO;
import org.zerock.domain.GameCategory3VO;
import org.zerock.domain.GameCategory1VO;
import org.zerock.domain.GameVO;

@Repository
public class GameDAOImpl implements GameDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.zerock.mapper.GameMapper";
	
	//寃뚯엫 移댄뀒怨좊━1
	@Override
	public List<GameCategory1VO> selectGameType() throws Exception {
		return sqlSession.selectList(NAMESPACE+".selectGameType");
	}
	
	//寃뚯엫 由ъ뒪�듃
	@Override
	public List<GameVO> selectAllGame() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAllGame");
	}
	
	//寃뚯엫 移댄뀒怨좊━2
	@Override
	public List<GameCategory2VO> selectGameCategory2() throws Exception {
		return sqlSession.selectList(NAMESPACE+".selectGameCategory2");
	}
	
	//寃뚯엫 移댄뀒怨좊━3
	@Override
	public List<GameCategory3VO> selectGameCategory3() throws Exception {
		return sqlSession.selectList(NAMESPACE+".selectGameCategory3");
	}
	
	//�듅�젙 寃뚯엫 由ъ뒪�듃
	@Override
	public List<GameVO> selectGame(int idx) throws Exception {
		return sqlSession.selectList(NAMESPACE+".selectGame", idx);
	}
	
	//�듅�젙 寃뚯엫 由ъ뒪�듃
	@Override
	public List<GameVO> selectGame2(int idx) throws Exception {
		return sqlSession.selectList(NAMESPACE+".selectGame2", idx);
	}
	
	@Override
	public List<GameVO> categoryGameList(GameVO gameVO) throws Exception {
		return sqlSession.selectList(NAMESPACE+".categoryGameList", gameVO);
	}
	
	@Override
	public List<GameVO> gameInfo(GameVO gameVO) throws Exception {
		return sqlSession.selectList(NAMESPACE+".gameInfo", gameVO);
	}
}
