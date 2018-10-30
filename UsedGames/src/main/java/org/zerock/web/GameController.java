package org.zerock.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.GameVO;
import org.zerock.service.GameService;

@RequestMapping("/game")
@Controller
public class GameController {
	
	@Inject
	private GameService gameService;
	
	//寃뚯엫 移댄뀒怨좊━
	@RequestMapping(value="/gameType.do", method=RequestMethod.GET)
	public void gameType(Model model) throws Exception {
		
		model.addAttribute("gameTypes", gameService.selectGameType());
	}
	
	//理쒖떊 寃뚯엫 �긽�뭹
	@RequestMapping(value="/allGame.do", method=RequestMethod.GET)
	public void allGame(Model model) throws Exception {
		
		model.addAttribute("gameVOs", gameService.selectAllGame());
	}
	
	//寃뚯엫 由ъ뒪�듃
	@RequestMapping(value="/gameList.do", method=RequestMethod.GET)
	public String gameList(Model model) throws Exception {
		
		model.addAttribute("gameCategories", gameService.selectGameType());
		model.addAttribute("gameCategory2s", gameService.selectGameCategory2());
		
		return "/game/gameList";
	}
	
	@RequestMapping(value="/gameInfo.do", method=RequestMethod.GET)
	public String gameInfo(Model model, @RequestParam("gameIdx") int gameIdx) throws Exception {
		
		GameVO gameVO = new GameVO();
		gameVO.setIdx(gameIdx);
		List<GameVO> list = gameService.gameInfo(gameVO);
		model.addAttribute("gameVO", list);
		
		return "/game/gameInfo";
	}

	
	@ResponseBody
	@RequestMapping(value="/categoryList.do", method=RequestMethod.GET)
	public GameVO categoryList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GameVO gameVO = new GameVO();
		
		String resultStr = "";
		
		String deviceIdxList = request.getParameter("deviceIdx");
		String typeIdxList = request.getParameter("typeIdx");
		
		gameVO.setDeviceIdx(deviceIdxList);
		gameVO.setTypeIdx(typeIdxList);

//		List list = (List)gameService.categoryGameList(gameVO);
//
//		for (int i = 0; i < list.size(); i++) {
//			Map tmp_map = (Map) list.get(i);
//			String title = (String) tmp_map.get("title");
//			String image = (String) tmp_map.get("image");
//			int price = (Integer) tmp_map.get("price");
//			int viewCount = (Integer) tmp_map.get("viewCount");
//
//			if (i == 0) {
//				resultStr += title + "&" + image + "&" + price + "&" + viewCount;
//			}
//			else {
//				resultStr += "," + title + "&" + image + "&" + price + "&" + viewCount;
//			}
//		}
//
//		response.setContentType("text/json");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer = response.getWriter();
//		writer.print(resultStr);
		return gameVO;
	}
}
