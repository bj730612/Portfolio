package org.zerock.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.zerock.domain.CartVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.LoginDTO;
import org.zerock.domain.MemberVO;

public interface MemberService {

	//로그인 체크
	public MemberVO login(LoginDTO loginDTO) throws Exception;

	//로그아웃
	public void logout(HttpSession session) throws Exception;

	//자동로그인
	public void keepLogin(String email, String sessionId, Date next) throws Exception;

	//세션키
	public MemberVO checkLoginBefore(String value) throws Exception;
	
	//장바구니 추가
	public void insertCart(CartVO cartVO) throws Exception;
		
	//장바구니 수정
	public void updateCart(CartVO cartVO) throws Exception;
	
	//장바구니 삭제
	public void deleteCart(int idx) throws Exception;
	
	//게시글 조회
	public CartVO readCart(int idx) throws Exception;
	
	//장바구니 리스트
	public List<CartVO> listCriteria(Criteria cri) throws Exception;
	
	//장바구니 카운트
	public int listCountCriteria(Criteria cri) throws Exception;

}
