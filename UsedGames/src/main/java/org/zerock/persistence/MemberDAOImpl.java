package org.zerock.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.CartVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.LoginDTO;
import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl  implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.MemberMapper";
	
	//회원가입
	@Override
	public void insertMember(MemberVO memberVO) throws Exception {
		sqlSession.insert(namespace+".insertMember", memberVO);
	}
	
	//회원 로그인 체크
	@Override
	public MemberVO login(LoginDTO loginDTO) throws Exception {
		return sqlSession.selectOne(namespace+".login", loginDTO);
	}
	
	//회원 로그아웃
	@Override
	public void logout(HttpSession session) throws Exception {}
	
	//자동로그인
	@Override
	public void keepLogin(String email, String sessionId, Date next) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("sessionId", sessionId);
		map.put("next", next);
		sqlSession.update(namespace+".keepLogin", map);
	}
	
	//세션키
	@Override
	public MemberVO checkMemberWithSessionKey(String value) throws Exception {
		return sqlSession.selectOne(namespace+".checkMemberWithSessionKey", value);
	}
	
	// 게시글 추가
	@Override
	public void insertCart(CartVO cartVO) throws Exception {
		sqlSession.insert(namespace+".insertCart", cartVO);
	}
	
	// 게시글 수정
	@Override
	public void updateCart(CartVO cartVO) throws Exception {
		sqlSession.update(namespace + ".updateCart", cartVO);
	}

	// 게시글 삭제
	@Override
	public void deleteCart(int idx) throws Exception {
		sqlSession.delete(namespace + ".deleteCart", idx);
	}

	//게시글 조회
	@Override
	public CartVO readCart(int idx) throws Exception {
		return sqlSession.selectOne(namespace + ".readCart", idx);
	}
	
	//게시글 리스트
	@Override
	public List<CartVO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(namespace+".listCriteria", cri);
	}
	
	//게시글 카운트
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(namespace+".countPaging", cri);
	}
	
	// 게시글 조회수
	@Override
	public int viewCount(int idx) throws Exception {
		return sqlSession.update(namespace + ".viewCount", idx);
	}
}
