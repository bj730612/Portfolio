package org.zerock.persistence;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.zerock.domain.BoardVO;
import org.zerock.domain.CartVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.LoginDTO;
import org.zerock.domain.UserVO;

public interface UserDAO {

	//회원가입
	public void insertUser(UserVO userVO) throws Exception;

	//로그인 체크
	public UserVO login(LoginDTO loginDTO) throws Exception;

	//로그아웃
	public void logout(HttpSession session) throws Exception;

	//자동로그인
	public void keepLogin(String email, String sessionId, Date next) throws Exception;

	//세션키
	public UserVO checkUserWithSessionKey(String value) throws Exception;
	
	// 게시글 추가
	public void insertCart(CartVO cartVO) throws Exception;
	
	// 게시글 수정
	public void updateCart(CartVO cartVO) throws Exception;
	
	// 게시글 삭제
	public void deleteCart(int idx) throws Exception;
	
	// 게시글 조회
	public CartVO readCart(int idx) throws Exception;
	
	//게시글 리스트
	public List<CartVO> listCriteria(Criteria cri) throws Exception;
	
	//게시글 카운트
	public int countPaging(Criteria cri) throws Exception;
	
	//게시글 조회수 
	public int viewCount(int idx) throws Exception;

}
