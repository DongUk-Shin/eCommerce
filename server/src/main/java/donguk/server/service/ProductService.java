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
     * WebMvcConfig 에서 상대경로 -> 절대경로로 바꾸는 로직
     * 프로젝트 외부의 파일에 접근 가능 -> 이미지 업로드 시 바로 반영
     */
    public void save(ProductDTO productDTO, MultipartFile file) throws IOException {
        Product product = Product.toProduct(productDTO);

        UUID uuid = UUID.randomUUID();
        String savedFileName = uuid + "_" + file.getOriginalFilename();

        product.setFileOriName(file.getOriginalFilename());
        product.setFileName(savedFileName);

        product.setFilePath("image/product/" + savedFileName); //상대 경로로 파일 경로 저장

        String fileDir = "C:/Git/eCommerce/image/product/"; //실제 저장 하는 절대 경로
        file.transferTo(new File(fileDir + savedFileName));
        productRepository.save(product);
    }


    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
