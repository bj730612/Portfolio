package org.zerock.web;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.CommentVO;
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
	public void gameInfo(Model model, @RequestParam("idx") int idx) throws Exception {
		
		model.addAttribute("gameVOs", gameService.gameInfo(idx));
	}

	@RequestMapping(value="/categoryList.do", method=RequestMethod.GET)
	public void categoryList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1");
		GameVO gameVO = new GameVO();
		
		String resultStr = "";
		
		String deviceIdxList = request.getParameter("device_idx");
		String typeIdxList = request.getParameter("type_idx");
		
		gameVO.setDevice_idx(deviceIdxList);
		gameVO.setType_idx(typeIdxList);
		
		List list = (List)gameService.categoryGameList(gameVO);
		
		for (int i = 0; i < list.size(); i++) {
			Map tmp_map = (Map) list.get(i);
			String name = (String) tmp_map.get("name");
			String title = (String) tmp_map.get("title");
			String image = (String) tmp_map.get("image");
			int price = (int) tmp_map.get("price");
			//int viewcount = (int) tmp_map.get("viewcount");

			if (i == 0) {
				resultStr += name + "&" + title + "&" + image + "&" + price;// + "&" + viewcount;
			}
			else {
				resultStr += "," + name + "&" + title + "&" + image + "&" + price;// + "&" + viewcount;
			}
		}

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(resultStr);
	}
}
