package com.example.doctor.repository;

import com.example.doctor.entity.Doctor;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DoctorRepository {
    List<Doctor> findAll();

    Optional<Doctor> findById(Long id);

    List<Doctor> getDoctors(
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );

    long countDoctors();

}
