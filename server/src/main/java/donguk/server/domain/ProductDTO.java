package donguk.server.domain;

import jakarta.persistence.*;
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
    private String fileName;
    private String fileOriName;
    private String filePath;

    public static ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());

        productDTO.setFileName(product.getFileName());
        productDTO.setFileOriName(product.getFileOriName());
        productDTO.setFilePath(product.getFilePath());
        return productDTO;
    }
}
