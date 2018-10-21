package org.zerock.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Inject
	private UserService userService;
	
	private String saveDest(HttpServletRequest req) {
		
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		
		if(query == null || query.equals("null")) {
			query = "";
		}else {
			query = "?" + query;
		}
		
		if(req.getMethod().equals("GET")) {
			req.getSession().setAttribute("dest", uri + query);
		}
		System.out.println("url = " + uri + query);
		return uri + query;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		//濡쒓렇�씤 �뾾�씠 �럹�씠吏� �씠�룞�떆
		if(session.getAttribute("login") == null) {
			
			String url = saveDest(request);
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			//�옄�룞 濡쒓렇�씤 荑좏궎 �쑀臾� �솗�씤
			if(loginCookie != null) {
				UserVO userVO = userService.checkLoginBefore(loginCookie.getValue());
				
				//�쑀�� �젙蹂� �쑀臾� �솗�씤
				if(userVO != null) {
					session.setAttribute("login", userVO);
					
					// �젒�냽�븳 �럹�씠吏� �솗�씤
					if(url.equals("/main.do")) {
						return true;
					}else {
						return false;
					}
				}
			}
			if(url.equals("/main.do")) {
				return true;
			}else {
				response.sendRedirect("/user/login.do");
				return false;
			}
		}
		return true;
	}

}
