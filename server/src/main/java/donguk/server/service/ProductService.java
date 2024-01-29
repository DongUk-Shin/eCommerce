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

    /**
     * 이미지 저장
     * 이미지 업로드 후 서버를 refresh 해야 이미지가 로드되는 이슈가 있음 
     */
    public void save(ProductDTO productDTO, MultipartFile file) throws IOException {
        String fileDir = System.getProperty("user.dir") + "/src/main/resources/static/image/product/";
        System.out.println("fileDir = " + fileDir);

        Product product = Product.toProduct(productDTO);

        UUID uuid = UUID.randomUUID();
        String savedFileName = uuid + "_" + file.getOriginalFilename();
        System.out.println("savedFileName = " + savedFileName);

        product.setFileOriName(file.getOriginalFilename());
        product.setFileName(savedFileName);
        product.setFilePath(fileDir + savedFileName);

        file.transferTo(new File(fileDir + savedFileName));
        productRepository.save(product);
    }


    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
