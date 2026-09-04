package example.minipro2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "locker")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LockerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "l_no")
    private Integer l_no;

    @Column(name = "l_location", length = 30, nullable = false)
    private String l_location;

    @Column(name = "l_status", length = 10, nullable = false)
    private String l_status;


    // Locker 1 : 1 Equipment
    @OneToOne(mappedBy = "locker")
    @ToString.Exclude
    private EquipmentEntity equipment;

}




