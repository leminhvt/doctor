package com.example.doctor.service;

import com.example.doctor.request.DoctorRequest;
import com.example.doctor.until.Response;
import jakarta.servlet.http.HttpServletRequest;

public interface DoctorService {
    /**
     * findById
     *
     * @param id Long
     * @return Response
     */
    Response findById(Long id);

    /**
     * findAll
     *
     * @param request DoctorRequest
     * @return Response
     */
    Response findAll(HttpServletRequest httpServletRequest, DoctorRequest request);

    /**
     * getPages
     *
     * @param request DoctorRequest
     * @return Response
     */
    Response getPages(HttpServletRequest httpServletRequest, DoctorRequest request);
}

