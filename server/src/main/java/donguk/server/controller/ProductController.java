package donguk.server.controller;

import donguk.server.domain.ProductDTO;
import donguk.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/add")
    public String addProductForm() {
        return "product/addProduct";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute ProductDTO productDTO) {
        System.out.println("productDTO = " + productDTO);
        productService.save(productDTO);
        return "redirect:/";
    }
}
