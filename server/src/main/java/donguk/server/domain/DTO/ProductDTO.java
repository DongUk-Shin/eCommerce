package donguk.server.domain.DTO;

import donguk.server.domain.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {

    private Long id;
    private String name;
    private Long price;
    private Long quantity;
    private String content;
    private String fileName;
    private String fileOriName;
    private String filePath;

    public static ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setContent(product.getContent());

        productDTO.setFileName(product.getFileName());
        productDTO.setFileOriName(product.getFileOriName());
        productDTO.setFilePath(product.getFilePath());
        return productDTO;
    }


}
