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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.CommentVO;
import org.zerock.domain.MemberVO;
import org.zerock.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController{
	
	@Inject
	private CommentService commentService;
	
	//�뙎湲� �벑濡�
	@RequestMapping(value="/insertComment.do", method=RequestMethod.POST)
	@ResponseBody
	public String insertComment(CommentVO commentVO, @RequestParam("boardIdx") int boardIdx, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		//濡쒓렇�씤 �깉�뀡 �젙蹂� 媛��졇�삤湲�
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		
		try {
			commentVO.setMemberIdx(memberVO.getIdx());
			commentService.insertComment(commentVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	//�뙎湲� 由ъ뒪�듃 
	@RequestMapping(value="/selectComment.do", method=RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public ResponseEntity selectComment(@RequestParam("boardIdx") int boardIdx,  HttpServletRequest request) throws Exception {
		
		HttpHeaders responseHeaders = new HttpHeaders();
        ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
        
        List<CommentVO> commentVO = commentService.selectComment(boardIdx);
        
        if(commentVO.size() > 0) {
        	for(int i=0; i<commentVO.size(); i++) {
        		HashMap hm = new HashMap();
        		hm.put("idx", commentVO.get(i).getIdx());
        		hm.put("content", commentVO.get(i).getContent());
        		hm.put("name", commentVO.get(i).getName());
        		
        		hmlist.add(hm);
        	}
        }
        
        JSONArray json = new JSONArray(hmlist);
        return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
}
