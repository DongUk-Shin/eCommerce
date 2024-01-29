package donguk.server.service;

import donguk.server.domain.Product;
import donguk.server.domain.ProductDTO;
import donguk.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void save(ProductDTO productDTO, MultipartFile file) throws IOException {
        String fileDir = "C:/Git/eCommerce/image/product/";
        Product product = Product.toProduct(productDTO);

        UUID uuid = UUID.randomUUID();
        String savedFileName = uuid + "_" + file.getOriginalFilename();

        product.setFileOriName(file.getOriginalFilename());
        product.setFileName(savedFileName);
        product.setFileUrl(fileDir);

        file.transferTo(new File(fileDir + savedFileName));
        productRepository.save(product);
    }


    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
