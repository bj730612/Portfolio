package org.zerock.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.UserVO;
import org.zerock.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController{
	
	@Inject
	private ReviewService reviewService;
	
	//�뙎湲� �벑濡�
	@RequestMapping(value="/insertReview.do", method=RequestMethod.POST)
	@ResponseBody
	public String insertReview(ReviewVO reviewVO, @RequestParam("boardIdx") int boardIdx, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		//濡쒓렇�씤 �깉�뀡 �젙蹂� 媛��졇�삤湲�
		UserVO userVO = (UserVO)session.getAttribute("login");
		
		try {
			reviewVO.setUserIdx(userVO.getIdx());
			reviewService.insertReview(reviewVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	//�뙎湲� 由ъ뒪�듃 
	@RequestMapping(value="/selectReview.do", method=RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public ResponseEntity selectReview(@RequestParam("boardIdx") int boardIdx,  HttpServletRequest request) throws Exception {
		
		HttpHeaders responseHeaders = new HttpHeaders();
        ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
        
        List<ReviewVO> reviewVO = reviewService.selectReview(boardIdx);
        
        if(reviewVO.size() > 0) {
        	for(int i=0; i<reviewVO.size(); i++) {
        		HashMap hm = new HashMap();
        		hm.put("idx", reviewVO.get(i).getIdx());
        		hm.put("content", reviewVO.get(i).getContent());
        		hm.put("name", reviewVO.get(i).getName());
        		
        		hmlist.add(hm);
        	}
        }
        
        JSONArray json = new JSONArray(hmlist);
        return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
	
//	@RequestMapping(value="/deleteBoard.do", method=RequestMethod.POST)
//	public String deleteBoard(@RequestParam("boardIdx") int idx, RedirectAttributes rttr) throws Exception {
//		
//		//게시글 삭제 후 "SUCCESS메세지 보내기
//		boardService.deleteBoard(idx);
//		rttr.addFlashAttribute("msg", "SUCCESS");
//		
//		return "redirect:/board/listAll.do";
//	}
//	
//	//게시글 수정
//	@RequestMapping(value="/updateReview.do", method=RequestMethod.GET)
//	public void updateReview(@RequestParam("idx") int idx, Model model) throws Exception {
//		
//		model.addAttribute(ReviewService.readReview(idx));
//	}
}
