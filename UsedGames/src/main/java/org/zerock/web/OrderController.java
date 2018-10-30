package org.zerock.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.OrderVO;
import org.zerock.domain.MemberVO;
import org.zerock.service.OrderService;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Inject
    private OrderService orderService;

    //장바구니 추가
    @RequestMapping(value="insertOrder.do", method=RequestMethod.GET)
    public String insertOrder(@ModelAttribute OrderVO orderVO, HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	MemberVO memberVO = (MemberVO)session.getAttribute("login");    	
    	int memberIdx = memberVO.getIdx();

        // 장바구니에 기존 상품이 있는지 검사
    	orderVO.setMemberIdx(memberIdx);
        int count = orderService.countOrder(orderVO);

        if(count == 0){
            // 없으면 insert
            orderService.insertOrder(orderVO);
        } else {
            // 있으면 update
            orderService.duplicateUpdateOrder(orderVO);
        }
        
        return "redirect:orderList.do";
    }

    //장바구니 목록
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

    // 3. 장바구니 삭제
    @RequestMapping(value="deleteOrder.do", method=RequestMethod.GET)
    public String delete(@RequestParam int orderIdx) throws Exception{
        orderService.deleteOrder(orderIdx);
        
        return "redirect:orderList.do";
    }

    // 4. 장바구니 수정
    @RequestMapping(value="updateOrder.do", method=RequestMethod.GET)
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
