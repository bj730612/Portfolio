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
import org.zerock.domain.QuestionVO;
import org.zerock.domain.UserVO;
import org.zerock.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController{
	
	@Inject
	private QuestionService questionService;
	
	//�뙎湲� �벑濡�
	@RequestMapping(value="/insertQuestion.do", method=RequestMethod.POST)
	@ResponseBody
	public String insertQuestion(QuestionVO questionVO, @RequestParam("boardIdx") int boardIdx, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		//濡쒓렇�씤 �깉�뀡 �젙蹂� 媛��졇�삤湲�
		UserVO userVO = (UserVO)session.getAttribute("login");
		
		try {
			questionVO.setUserIdx(userVO.getIdx());
			questionService.insertQuestion(questionVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	//�뙎湲� 由ъ뒪�듃 
	@RequestMapping(value="/selectQuestion.do", method=RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public ResponseEntity selectQuestion(@RequestParam("boardIdx") int boardIdx,  HttpServletRequest request) throws Exception {
		
		HttpHeaders responseHeaders = new HttpHeaders();
        ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
        
        List<QuestionVO> questionVO = questionService.selectQuestion(boardIdx);
        
        if(questionVO.size() > 0) {
        	for(int i=0; i<questionVO.size(); i++) {
        		HashMap hm = new HashMap();
        		hm.put("idx", questionVO.get(i).getIdx());
        		hm.put("content", questionVO.get(i).getContent());
        		hm.put("name", questionVO.get(i).getName());
        		
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
//	@RequestMapping(value="/updateQuestion.do", method=RequestMethod.GET)
//	public void updateQuestion(@RequestParam("idx") int idx, Model model) throws Exception {
//		
//		model.addAttribute(QuestionService.readQuestion(idx));
//	}
}
