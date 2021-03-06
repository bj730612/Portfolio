package org.crud.controller;

import javax.inject.Inject;

import org.crud.domain.BoardVO;
import org.crud.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO boardVO, Model model) throws Exception {
		
		logger.info("register get ...........");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		
		logger.info("regist post ..........");
		logger.info(boardVO.toString());
		
		service.regist(boardVO);
		
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		
		logger.info("show all list..........");
	}	
}
