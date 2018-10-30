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
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDAO;
	
	//로그인 체크
	@Override
	public MemberVO login(LoginDTO loginDTO) throws Exception {
		return memberDAO.login(loginDTO);
	}
	
	//로그아웃
	@Override
	public void logout(HttpSession session) throws Exception {
		session.invalidate();
	}
	
	//자동로그인
	@Override
	public void keepLogin(String email, String sessionId, Date next) throws Exception {
		memberDAO.keepLogin(email, sessionId, next);
	}
	
	//세션키
	@Override
	public MemberVO checkLoginBefore(String value) throws Exception {
		return memberDAO.checkMemberWithSessionKey(value);
	}
	
	//게시글 추가
	@Override
	public void insertCart(CartVO cartVO) throws Exception {
		memberDAO.insertCart(cartVO);
	}
	
	//게시글 수정
	@Override
	public void updateCart(CartVO cartVO) throws Exception {
		memberDAO.updateCart(cartVO);
	}
	
	//게시글 삭제
	@Override
	public void deleteCart(int idx) throws Exception {
		memberDAO.deleteCart(idx);
	}
	
	//게시글 조회
	@Override
	public CartVO readCart(int idx) throws Exception {
		memberDAO.viewCount(idx);
		return memberDAO.readCart(idx);
	}
	
	//장바구니 리스트
	@Override
	public List<CartVO> listCriteria(Criteria cri) throws Exception {
		return memberDAO.listCriteria(cri);
	}
	
	//게시글 카운트
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return memberDAO.countPaging(cri);
	}
}
