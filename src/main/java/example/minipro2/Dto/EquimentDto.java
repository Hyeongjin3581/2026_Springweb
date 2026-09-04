package example.minipro2.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor 
@Getter @Setter @ToString @Builder 
public class EquimentDto {
    private Integer e_no;
    private String e_name;
    private String c_category;
    private String e_status;
    private Integer l_no;
}
