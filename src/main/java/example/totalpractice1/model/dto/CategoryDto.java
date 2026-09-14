package example.totalpractice1.Model.dto;


import example.totalpractice1.Model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class CategoryDto {
    private Integer cno;
    private String name;

    public CategoryEntity toEntity(){
        return CategoryEntity.builder()
        .name(this.name)
        .build();
    }

    public static CategoryDto from(CategoryEntity entity){
        return CategoryDto.builder()
        .cno(entity.getCno())
        .name(entity.getName())
        .build();
    }
}
