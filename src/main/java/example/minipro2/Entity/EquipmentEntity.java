package example.minipro2.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class EquipmentEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer e_no;

    @Column(length = 50) 
    private String e_name;
    @Column(length = 30) 
    private String e_category;
    @Column(length = 20)
    private String e_status;
    
    // Locker를 Fk함. (1 : 1 구조)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "l_no", nullable = false, unique = true)
    private LockerEntity locker;

    // Equipment 1 : N Rental
    @OneToMany(mappedBy = "equipment")
    @Builder.Default
    @ToString.Exclude
    private List<RentalEntity> rentals = new ArrayList<>();
    

}
