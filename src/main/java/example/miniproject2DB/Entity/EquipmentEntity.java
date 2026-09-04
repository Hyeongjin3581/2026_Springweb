package example.miniproject2DB.Entity;

import example.Practice3.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="equipment")
@NoArgsConstructor @AllArgsConstructor@Builder 
@Getter @Setter @ToString  
public class EquipmentEntity extends BaseTime{
    @Id 
    @GenteratedValue(strategy = GenerationType.IDENTITY)
    private Integer e_no;
    

}
