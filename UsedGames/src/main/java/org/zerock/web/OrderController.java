package org.zerock.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.GameVO;
import org.zerock.domain.MemberVO;
import org.zerock.domain.OrderVO;
import org.zerock.service.GameService;
import org.zerock.service.OrderService;

@RequestMapping("/order")
@Controller
public class OrderController {
	
    @Inject
    private OrderService orderService;
    @Inject
    private GameService gameService;
    
    @RequestMapping(value="/writeOrder.do", method=RequestMethod.GET)
    public void writeOrder(Model model, @ModelAttribute GameVO gameVO, HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	MemberVO memberVO = (MemberVO)session.getAttribute("login");
    	int gameIdx = Integer.parseInt(request.getParameter("gameIdx"));
    	gameVO.setIdx(gameIdx);
    	
    	List<GameVO> listGameVO = gameService.gameInfo(gameVO);
    	model.addAttribute("paymentTypes", orderService.selectPaymentType());
    	
    	int quantity = Integer.parseInt(request.getParameter("quantity"));
    	int cost = quantity * listGameVO.get(0).getPrice();
    	
    	model.addAttribute("gameVO", listGameVO);
    	model.addAttribute("quantity", request.getParameter("quantity"));
    	model.addAttribute("cost", cost);
    	
    	int fee = cost >= 100000 ? 0 : 2500;
        model.addAttribute("fee", fee);                 // 배송금액
        model.addAttribute("allSum", cost+fee);    // 주문 상품 전체 금액
        
    }

    //추가
    @RequestMapping(value="/insertOrderMt.do", method=RequestMethod.GET)
    public String insertOrderMt(@ModelAttribute OrderVO orderVO, HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	MemberVO memberVO = (MemberVO)session.getAttribute("login");
    	
        return "redirect:insertOrderDt.do";
    }
    
    @RequestMapping(value="/insertOrderDt.do", method=RequestMethod.GET)
    public String insertOrderDt(@ModelAttribute OrderVO orderVO, HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	MemberVO memberVO = (MemberVO)session.getAttribute("login");

        return "redirect:orderList.do";
    }

    //목록
    @RequestMapping(value="orderList.do", method=RequestMethod.GET)
    public String list(Model model, HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	MemberVO memberVO = (MemberVO)session.getAttribute("login");
    	
    	int memberIdx = memberVO.getIdx();

		List<OrderVO> list = orderService.listOrder(memberIdx); // 장바구니 정보 
        int sumCost = orderService.sumCost(memberIdx); // 장바구니 전체 금액 호출
        // 장바구니 전체 긍액에 따라 배송비 구분
        // 배송료(5만원이상 => 무료, 미만 => 2500원)
        int fee = sumCost >= 50000 ? 0 : 2500;
        model.addAttribute("list", list);                // 장바구니 정보를 map에 저장
        model.addAttribute("count", list.size());        // 장바구니 상품의 유무
        model.addAttribute("sumCost", sumCost);        // 장바구니 전체 금액
        model.addAttribute("fee", fee);                 // 배송금액
        model.addAttribute("allSum", sumCost+fee);    // 주문 상품 전체 금액
        
        return "/member/orderList";
    }

    //삭제
    @RequestMapping(value="/deleteOrder.do", method=RequestMethod.GET)
    public String delete(@RequestParam int orderIdx) throws Exception{
        orderService.deleteOrder(orderIdx);
        
        return "redirect:orderList.do";
    }

    //수정
    @RequestMapping(value="/updateOrder.do", method=RequestMethod.GET)
    public String updateOrder(@RequestParam int[] quantity, @RequestParam int[] gameIdx, HttpServletRequest request) throws Exception {
        // session의 id
    	HttpSession session = request.getSession();
    	
    	MemberVO memberVO = (MemberVO)session.getAttribute("login");
    	
    	int memberIdx = memberVO.getIdx();
        // 레코드의 갯수 만큼 반복문 실행
        for(int i=0; i<gameIdx.length; i++){
            OrderVO orderVO = new OrderVO();
            orderVO.setMemberIdx(memberIdx);
            orderVO.setQuantity(quantity[i]);
            orderVO.setGameIdx(gameIdx[i]);
            orderService.updateOrder(orderVO);
        }
        
        return "redirect:orderList.do";
    }
}
