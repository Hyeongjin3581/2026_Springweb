package example.minipro2.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.Practice3.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="rental")
@NoArgsConstructor @AllArgsConstructor @Builder 
@Getter @Setter 
public class RentalEntity extends BaseTime{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Report 에게 FK됨
    private Integer r_no;

    // Users를 FK함.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_no")
    private UsersEntity users;

    // Equipment를 FK함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "e_no")
    private EquipmentEntity equipment;

    private LocalDateTime r_date;
    private LocalDateTime r_due_date;
    private LocalDateTime r_return_date;

    @Column (length = 10)
    private String r_status;

    @Column (length = 10)
    private String r_condition;

    // Rental 1 : N Report
    @OneToMany(mappedBy = "rental")
    @Builder.Default
    @ToString.Exclude
    private List<ReportEntity> reports = new ArrayList<>();




}
