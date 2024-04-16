package ru.mirea.dentalclinic.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start")
    private Long start;

    @Column(name = "finish")
    private Long finish;

    @Column(name = "day")
    private Date date;

    @Column(name = "is_booked")
    private Boolean isBooked;

    @ManyToOne(optional = true)
    private PatientEntity patient;

    @ManyToOne(optional = false)
    private DoctorEntity doctor;

    @ManyToOne(optional = false)
    private OfficeEntity office;

}
