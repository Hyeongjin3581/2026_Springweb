package example.totalpractice1.model.dto;

import example.totalpractice1.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Builder 
public class CategoryDto {
    private Integer cno;
    private String name;

    public CategoryEntity toEntity() {
        return CategoryEntity.builder()
        .cno(this.cno)
        .name(this.name)
        .build();
    }

    public static CategoryDto from(CategoryEntity entity) {
        return CategoryDto.builder()
        .cno(entity.getCno() )
        .name(entity.getName() )
        .build();
    }
}