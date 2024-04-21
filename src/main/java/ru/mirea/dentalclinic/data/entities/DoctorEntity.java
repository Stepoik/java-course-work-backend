package ru.mirea.dentalclinic.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "spec")
    private String spec;

    @Column(name = "image")
    private String image;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "experience")
    private Integer experience;

    @ManyToMany(mappedBy = "doctors")
    private List<ProcedureEntity> procedures;

    public DoctorEntity(Long id, String firstName, String lastName, String middleName, String spec, String image, Float rate, Integer experience) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.spec = spec;
        this.image = image;
        this.rate = rate;
        this.experience = experience;
    }
}
