package donguk.server.domain;

import donguk.server.domain.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column  private String name;

    @Column  private Long price;

    @Column  private Long quantity; //수량

    @Column private String content; //설명

    //@Column private LocalDateTime uploadDate;

    @Column private String fileName;
    @Column private String fileOriName;
    @Column private String filePath;


    public static Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setContent(productDTO.getContent());

        product.setFileName(productDTO.getFileName());
        product.setFileOriName(productDTO.getFileOriName());
        product.setFilePath(productDTO.getFilePath());
        return product;
    }

}
