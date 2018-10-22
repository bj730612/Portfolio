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

	//회원가입 페이지
	@RequestMapping(value="/signUp.do", method=RequestMethod.GET)
	public void signUp(Model model) throws Exception {}
	
	//회원가입
	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public String signUp(UserVO userVO) throws Exception {
		
		userDAO.insertUser(userVO);
		
		return "redirect:/user/login.do";
	}
	
	//로그인 페이지
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public void login() throws Exception {}
	
	//로그인
	@RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
	public void loginCheck(LoginDTO loginDTO, HttpSession session, Model model) throws Exception {
		
		//로그인 세션정보가 있을 경우
		if(session.getAttribute("login") != null) {
			
			//세션정보 삭제
			session.removeAttribute("login");
		}
		
		//로그인
		UserVO userVO = userService.login(loginDTO);
		
		//로그인 실패
		if(userVO == null) {
			return;
		}

		model.addAttribute("userVO", userVO);
		
		// 자동 로그인 체크 확인
		if(loginDTO.isUseCookie()) {
		
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
			
			userService.keepLogin(userVO.getEmail(), session.getId(), sessionLimit);
			
		}
	}
	
	// 로그아웃(자동로그인 기록 삭제)
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Object obj = session.getAttribute("login");
		
		//로그인 세션정보가 있을경우
		if(obj != null) {
			UserVO userVO = (UserVO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie logincookie = WebUtils.getCookie(request, "loginCookie");
			
			//쿠키가 있을경우
			if(logincookie != null) {
				logincookie.setPath("/");
				logincookie.setMaxAge(0);
				response.addCookie(logincookie);
				userService.keepLogin(userVO.getEmail(), session.getId(), new Date());
			}
		}
		return "/user/logout";
	}
	
	//게시글 리스트
	@RequestMapping(value="/cartList.do", method=RequestMethod.GET)
	public void listAll(SearchVO cri, Model model) throws Exception {
		
		PageMaker pm = new PageMaker();
		
		model.addAttribute("carts", userService.listCriteria(cri));
		pm.setCri(cri);
		pm.setTotalCount(userService.listCountCriteria(cri));
		
		model.addAttribute("pm", pm);
	}
	
	//게시글 삭제
	@RequestMapping(value="/deleteCart.do", method=RequestMethod.POST)
	public String deleteCart(@RequestParam("idx") int idx, RedirectAttributes rttr) throws Exception {
		
		//게시글 삭제 후 "SUCCESS메세지 보내기
		userService.deleteCart(idx);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/cartList.do";
	}
	
	//게시글 수정
	@RequestMapping(value="/updateCart.do", method=RequestMethod.GET)
	public void updateCart(@RequestParam("idx") int idx, Model model) throws Exception {
		
		model.addAttribute(userService.readCart(idx));
	}
	
	@RequestMapping(value="/updateCart.do", method=RequestMethod.POST)
	public String updateCart(CartVO cartVO, RedirectAttributes rttr) throws Exception {
		
		userService.updateCart(cartVO);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/cartList.do";
	}
}
