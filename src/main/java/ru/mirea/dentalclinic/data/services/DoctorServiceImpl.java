package ru.mirea.dentalclinic.data.services;

import org.springframework.stereotype.Service;
import ru.mirea.dentalclinic.domain.models.Doctor;
import ru.mirea.dentalclinic.domain.service.DoctorService;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Override
    public List<Doctor> getDoctors() {
        return null;
    }

    @Override
    public List<Doctor> getDoctorByName(String query) {
        return null;
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        return null;
    }
}
