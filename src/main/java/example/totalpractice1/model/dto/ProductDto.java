package example.totalpractice1.model.dto;

import example.totalpractice1.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class ProductDto {
    private Integer bno;
    private String name;
    private Integer price;

    // 카테고리 cno 멤버변수에 등록.
    private Integer cno;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
        .name(this.name)
        .price(this.price)
        .build();
    }

    public static ProductDto from(ProductEntity entity){
        return ProductDto.builder()
        .bno(entity.getBno())
        .name(entity.getName())
        .price(entity.getPrice())
        .cno(entity.getCategoryEntity() == null ? null : entity.getCategoryEntity().getCno())
        .build();
    }

}