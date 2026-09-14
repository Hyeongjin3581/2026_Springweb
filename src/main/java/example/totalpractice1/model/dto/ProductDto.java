package example.totalpractice1.model.dto;

import java.util.ArrayList;
import java.util.List;

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
    private Integer categoryCno;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
        .name(this.name)
        .price(this.price)
        .build();
    }

    // 제품 전체 조회시 카테고리 까지 함께 조회
    @Builder.Default
    private List<CategoryDto> categorys = new ArrayList<>();

    public static ProductDto from(ProductEntity entity){
        return ProductDto.builder()
        .bno(entity.getBno())
        .name(entity.getName())
        .price(entity.getPrice())
        .categoryCno(entity.getCategoryEntity().getCno())
        .build();
    }

}
