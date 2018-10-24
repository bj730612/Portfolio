package org.zerock.web;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.CartVO;
import org.zerock.domain.LoginDTO;
import org.zerock.domain.PageMaker;
import org.zerock.domain.SearchVO;
import org.zerock.domain.UserVO;
import org.zerock.persistence.UserDAO;
import org.zerock.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Inject
	private UserDAO userDAO;
	
	@Inject 
	private UserService userService;

	//�쉶�썝媛��엯 �럹�씠吏�
	@RequestMapping(value="/signUp.do", method=RequestMethod.GET)
	public void signUp(Model model) throws Exception {}
	
	//�쉶�썝媛��엯
	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public String signUp(UserVO userVO) throws Exception {
		
		userDAO.insertUser(userVO);
		
		return "redirect:/user/login.do";
	}
	
	//濡쒓렇�씤 �럹�씠吏�
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public void login() throws Exception {}
	
	//濡쒓렇�씤
	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
	public void loginCheck(LoginDTO loginDTO, HttpSession session, Model model) throws Exception {
		
		//濡쒓렇�씤 �꽭�뀡�젙蹂닿� �엳�쓣 寃쎌슦
		if(session.getAttribute("login") != null) {
			
			//�꽭�뀡�젙蹂� �궘�젣
			session.removeAttribute("login");
		}
		
		//濡쒓렇�씤
		UserVO userVO = userService.login(loginDTO);
		
		//濡쒓렇�씤 �떎�뙣
		if(userVO == null) {
			return;
		}

		model.addAttribute("userVO", userVO);
		
		// �옄�룞 濡쒓렇�씤 泥댄겕 �솗�씤
		if(loginDTO.isUseCookie()) {
		
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
			
			userService.keepLogin(userVO.getEmail(), session.getId(), sessionLimit);
			
		}
	}
	
	// 濡쒓렇�븘�썐(�옄�룞濡쒓렇�씤 湲곕줉 �궘�젣)
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Object obj = session.getAttribute("login");
		
		//濡쒓렇�씤 �꽭�뀡�젙蹂닿� �엳�쓣寃쎌슦
		if(obj != null) {
			UserVO userVO = (UserVO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie logincookie = WebUtils.getCookie(request, "loginCookie");
			
			//荑좏궎媛� �엳�쓣寃쎌슦
			if(logincookie != null) {
				logincookie.setPath("/");
				logincookie.setMaxAge(0);
				response.addCookie(logincookie);
				userService.keepLogin(userVO.getEmail(), session.getId(), new Date());
			}
		}
		return "/user/logout";
	}
}
