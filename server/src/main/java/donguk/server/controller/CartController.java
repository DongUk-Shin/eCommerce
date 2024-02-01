package donguk.server.controller;

import donguk.server.domain.Cart;
import donguk.server.domain.Member;
import donguk.server.domain.Product;
import donguk.server.service.CartService;
import donguk.server.service.MemberService;
import donguk.server.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final MemberService memberService;

    private final ProductService productService;
    private final CartService cartService;

    /*
    @PostMapping("/cart/{productId}")
    public String cartSave(@PathVariable Long productId, HttpSession session) {
        Long memberId = (Long) session.getAttribute("id");

        Cart cart = new Cart();
        cart.setUserId(memberId);
        cart.setProductId(productId);
        cartService.save(cart);
        return "product/productdetail";
    }




    @GetMapping("/member/cart")
    public String cartForm(Member member) {
        return "cart";
    }

    */
}
