package org.zerock.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.CartVO;
import org.zerock.domain.UserVO;
import org.zerock.service.CartService;

@RequestMapping("/cart")
@Controller
public class CartController {

    @Inject
    private CartService cartService;

    //장바구니 추가
    @RequestMapping(value="insertCart.do", method=RequestMethod.GET)
    public String insertCart(@ModelAttribute CartVO cartVO, HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	UserVO userVO = (UserVO)session.getAttribute("login");    	
    	int userIdx = userVO.getIdx();

        // 장바구니에 기존 상품이 있는지 검사
    	cartVO.setUserIdx(userIdx);
        int count = cartService.countCart(cartVO);

        if(count == 0){
            // 없으면 insert
            cartService.insertCart(cartVO);
        } else {
            // 있으면 update
            cartService.duplicateUpdateCart(cartVO);
        }
        
        return "redirect:cartList.do";
    }

    //장바구니 목록
    @RequestMapping(value="cartList.do", method=RequestMethod.GET)
    public String list(Model model, HttpServletRequest request) throws Exception{
    	HttpSession session = request.getSession();
    	
    	UserVO userVO = (UserVO)session.getAttribute("login");
    	
    	int userIdx = userVO.getIdx();

		List<CartVO> list = cartService.listCart(userIdx); // 장바구니 정보 
        int sumCost = cartService.sumCost(userIdx); // 장바구니 전체 금액 호출
        // 장바구니 전체 긍액에 따라 배송비 구분
        // 배송료(5만원이상 => 무료, 미만 => 2500원)
        int fee = sumCost >= 50000 ? 0 : 2500;
        model.addAttribute("list", list);                // 장바구니 정보를 map에 저장
        model.addAttribute("count", list.size());        // 장바구니 상품의 유무
        model.addAttribute("sumCost", sumCost);        // 장바구니 전체 금액
        model.addAttribute("fee", fee);                 // 배송금액
        model.addAttribute("allSum", sumCost+fee);    // 주문 상품 전체 금액
        
        return "/user/cartList";
    }

    // 3. 장바구니 삭제
    @RequestMapping(value="deleteCart.do", method=RequestMethod.GET)
    public String delete(@RequestParam int cartIdx) throws Exception{
        cartService.deleteCart(cartIdx);
        
        return "redirect:cartList.do";
    }

    // 4. 장바구니 수정
    @RequestMapping(value="updateCart.do", method=RequestMethod.GET)
    public String updateCart(@RequestParam int[] quantity, @RequestParam int[] gameIdx, HttpServletRequest request) throws Exception {
        // session의 id
    	HttpSession session = request.getSession();
    	
    	UserVO userVO = (UserVO)session.getAttribute("login");
    	
    	int userIdx = userVO.getIdx();
        // 레코드의 갯수 만큼 반복문 실행
        for(int i=0; i<gameIdx.length; i++){
            CartVO cartVO = new CartVO();
            cartVO.setUserIdx(userIdx);
            cartVO.setQuantity(quantity[i]);
            cartVO.setGameIdx(gameIdx[i]);
            cartService.updateCart(cartVO);
        }
        
        return "redirect:cartList.do";
    }
}
