package donguk.server.service;

import donguk.server.domain.Product;
import donguk.server.domain.ProductDTO;
import donguk.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void save(ProductDTO productDTO) {
        Product product = Product.toProduct(productDTO);
        System.out.println("product = " + product);
        productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
