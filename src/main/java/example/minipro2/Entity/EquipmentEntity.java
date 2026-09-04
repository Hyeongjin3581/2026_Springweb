package example.minipro2.Entity;

import java.util.ArrayList;
import java.util.List;

import example.Practice3.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Getter @Setter 
public class EquipmentEntity extends BaseTime{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer e_no;

    @Column(length = 50) 
    private String e_name;
    @Column(length = 30) 
    private String e_category;
    @Column(length = 20)
    private String e_status;
    // 원래는 보관함도 양방향관계를 1대1관계로 구성해야 하나, 
    // DB에서 해당 관계가 작성되지 않았으므로 일단 제외.
    private Integer I_no; 

    // Equipment 1 : N Rental
    @OneToMany(mappedBy = "equipment")
    @Builder.Default
    @ToString.Exclude
    private List<RentalEntity> rentals = new ArrayList<>();
    

}
