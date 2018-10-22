package org.zerock.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.CartVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.LoginDTO;
import org.zerock.domain.UserVO;
import org.zerock.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	UserDAO userDAO;
	
	//로그인 체크
	@Override
	public UserVO login(LoginDTO loginDTO) throws Exception {
		return userDAO.login(loginDTO);
	}
	
	//로그아웃
	@Override
	public void logout(HttpSession session) throws Exception {
		session.invalidate();
	}
	
	//자동로그인
	@Override
	public void keepLogin(String email, String sessionId, Date next) throws Exception {
		userDAO.keepLogin(email, sessionId, next);
	}
	
	//세션키
	@Override
	public UserVO checkLoginBefore(String value) throws Exception {
		return userDAO.checkUserWithSessionKey(value);
	}
	
	//게시글 추가
	@Override
	public void insertCart(CartVO cartVO) throws Exception {
		userDAO.insertCart(cartVO);
	}
	
	//게시글 수정
	@Override
	public void updateCart(CartVO cartVO) throws Exception {
		userDAO.updateCart(cartVO);
	}
	
	//게시글 삭제
	@Override
	public void deleteCart(int idx) throws Exception {
		userDAO.deleteCart(idx);
	}
	
	//게시글 조회
	@Override
	public CartVO readCart(int idx) throws Exception {
		userDAO.viewCount(idx);
		return userDAO.readCart(idx);
	}
	
	//장바구니 리스트
	@Override
	public List<CartVO> listCriteria(Criteria cri) throws Exception {
		return userDAO.listCriteria(cri);
	}
	
	//게시글 카운트
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return userDAO.countPaging(cri);
	}
}
