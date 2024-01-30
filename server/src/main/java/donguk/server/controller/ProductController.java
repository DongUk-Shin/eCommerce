package donguk.server.controller;

import donguk.server.domain.Product;
import donguk.server.domain.ProductDTO;
import donguk.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/add")
    public String addProductForm() {
        return "product/addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam Long price,
                             @RequestParam Long quantity,
                             @RequestParam String content,
                             @RequestParam MultipartFile file) throws IOException {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        productDTO.setPrice(price);
        productDTO.setQuantity(quantity);
        productDTO.setContent(content);
        productService.save(productDTO, file);

        return "redirect:/";
    }

    @GetMapping("/{itemId}")
    public String productDetail(@PathVariable Long itemId, Model model) {
        Product product = productService.findById(itemId);
        System.out.println("product = " + product);
        model.addAttribute("product", product);
        return "product/productdetail";
    }

}
