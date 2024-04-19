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
    private Integer start;

    @Column(name = "finish")
    private Integer finish;

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

    public RecordEntity(Long id, Integer start, Integer finish, Date date, Boolean isBooked) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.date = date;
        this.isBooked = isBooked;
    }

}
