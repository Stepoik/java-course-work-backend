package ru.mirea.dentalclinic.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class ProcedureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "doctor_procedures",
            joinColumns = @JoinColumn(
                    name = "procedureId",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "doctorId",
                    referencedColumnName = "id"
            )
    )
    private List<DoctorEntity> doctors;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "clinic_procedures",
            joinColumns = @JoinColumn(
                    name = "procedureId",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "clinicId",
                    referencedColumnName = "id"
            )
    )
    private List<ClinicEntity> clinics;

}
