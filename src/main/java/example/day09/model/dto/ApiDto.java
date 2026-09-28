package example.day09.model.dto;

import java.time.LocalDateTime;

import example.day09.model.entity.ApiEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Builder @Data 
public class ApiDto {

    private Integer idx;
    private String subject;
    private String name;
    private String regdate;
    private String content;

    public ApiEntity toEntity(){
        return ApiEntity.builder()
        .subject(this.subject)
        .name(this.name)
        .regdate(LocalDateTime.now().toString())
        .content(this.content)
        .build();
    }

    public static ApiDto from(ApiEntity entity){
        return ApiDto.builder()
        .idx(entity.getIdx())
        .subject(entity.getSubject())
        .name(entity.getName())
        .regdate(entity.getRegdate())
        .content(entity.getContent())
        .build();
    }
}
