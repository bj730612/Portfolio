package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.GameCategory2VO;
import org.zerock.domain.GameCategory3VO;
import org.zerock.domain.GameCategory1VO;
import org.zerock.domain.GameVO;
import org.zerock.persistence.GameDAO;

@Service
public class GameServiceImpl implements GameService {

	@Inject
	private GameDAO gameDAO;
	
	//寃뚯엫 移댄뀒怨좊━1
	@Override
	public List<GameCategory1VO> selectGameType() throws Exception {
		return gameDAO.selectGameType();
	}

	//寃뚯엫 由ъ뒪�듃
	@Override
	public List<GameVO> selectAllGame() throws Exception {
		return gameDAO.selectAllGame();
	}
	
	//寃뚯엫 移댄뀒怨좊━2
	@Override
	public List<GameCategory2VO> selectGameCategory2() throws Exception {
		return gameDAO.selectGameCategory2();
	}
	
	//寃뚯엫 移댄뀒怨좊━3
	@Override
	public List<GameCategory3VO> selectGameCategory3() throws Exception {
		return gameDAO.selectGameCategory3();
	}
	
	//�듅�젙 寃뚯엫 由ъ뒪�듃
	@Override
	public List<GameVO> selectGame(int idx) throws Exception {
		return gameDAO.selectGame(idx);
	}
	
	//�듅�젙 寃뚯엫 由ъ뒪�듃2
	@Override
	public List<GameVO> selectGame2(int idx) throws Exception {
		return gameDAO.selectGame2(idx);
	}
	
	@Override
	public List<GameVO> categoryGameList(GameVO gameVO) throws Exception {
		return gameDAO.categoryGameList(gameVO);
	}
	
	@Override
	public List<GameVO> gameInfo(GameVO gameVO) throws Exception {
		return gameDAO.gameInfo(gameVO);
	}
}
