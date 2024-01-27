package donguk.server.service;

import donguk.server.domain.Product;
import donguk.server.domain.ProductDTO;
import donguk.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO save(ProductDTO productDTO) {
        Product product = Product.toProduct(productDTO);
        System.out.println("product = " + product);
        productRepository.save(product);
        return productDTO;
    }
}
