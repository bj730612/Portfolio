package org.zerock.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.GameCategory1VO;
import org.zerock.domain.GameCategory2VO;
import org.zerock.service.GameService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private GameService gameService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//硫붿씤 �럹�씠吏�
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public void main() throws Exception{}
	
	//�뿤�뜑 �럹�씠吏�
	@RequestMapping(value="/header.do", method=RequestMethod.GET)
	public void header() throws Exception{}
	
	//硫붾돱諛� �럹�씠吏�
	@RequestMapping(value="/nav.do", method=RequestMethod.GET)
	public void navi(Model model, GameCategory1VO gameCategory1VO, GameCategory2VO gameCategory2VO) throws Exception{
		
		model.addAttribute("gameCategories", gameService.selectGameType());
		model.addAttribute("gameCategory2s", gameService.selectGameCategory2());
	}
	
	//�뫖�꽣 �럹�씠吏�
	@RequestMapping(value="/footer.do", method=RequestMethod.GET)
	public void footer() throws Exception{}
	
}
