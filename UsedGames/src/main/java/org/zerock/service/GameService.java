package org.zerock.service;

import java.util.List;

import org.zerock.domain.GameCategory2VO;
import org.zerock.domain.GameCategory3VO;
import org.zerock.domain.GameCategory1VO;
import org.zerock.domain.GameVO;

public interface GameService {
	
	//寃뚯엫 移댄뀒怨좊━1
	public List<GameCategory1VO> selectGameType() throws Exception;
	
	//寃뚯엫 由ъ뒪�듃
	public List<GameVO> selectAllGame() throws Exception;
	
	//寃뚯엫 移댄뀒怨좊━2
	public List<GameCategory2VO> selectGameCategory2() throws Exception;
	
	//寃뚯엫 移댄뀒怨좊━3
	public List<GameCategory3VO> selectGameCategory3() throws Exception;
	
	//�듅�젙 寃뚯엫 由ъ뒪�듃
	public List<GameVO> selectGame(int idx) throws Exception;
	
	//�듅�젙 寃뚯엫 由ъ뒪�듃2
	public List<GameVO> selectGame2(int idx) throws Exception;
	
	public List<GameVO> categoryGameList(GameVO gameVO) throws Exception;
	
	public GameVO gameInfo(int idx) throws Exception;

}
