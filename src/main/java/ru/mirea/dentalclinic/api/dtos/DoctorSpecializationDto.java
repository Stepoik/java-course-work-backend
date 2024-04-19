package ru.mirea.dentalclinic.api.dtos;

import ru.mirea.dentalclinic.domain.models.DoctorSpecialization;

public enum DoctorSpecializationDto {

    Therapist,
    Surgeon,
    Orthopedist,
    Hygienist,
    Periodontist,
    Implantologist,
    Orthodontist;
    public DoctorSpecialization mapToDomain() {
        return switch (this) {
            case Therapist -> DoctorSpecialization.Therapist;
            case Surgeon ->  DoctorSpecialization.Surgeon;
            case Orthopedist ->  DoctorSpecialization.Orthopedist;
            case Hygienist ->  DoctorSpecialization.Hygienist;
            case Periodontist ->  DoctorSpecialization.Periodontist;
            case Implantologist ->  DoctorSpecialization.Implantologist;
            case Orthodontist ->  DoctorSpecialization.Orthodontist;
        };
    }

    public static DoctorSpecializationDto mapFromDomain(DoctorSpecialization doctorSpecialization) {
        return switch (doctorSpecialization) {

            case Therapist -> Therapist;
            case Surgeon -> Surgeon;
            case Orthopedist -> Orthopedist;
            case Hygienist -> Hygienist;
            case Periodontist -> Periodontist;
            case Implantologist -> Implantologist;
            case Orthodontist ->  Orthodontist;
        };
    }
}
