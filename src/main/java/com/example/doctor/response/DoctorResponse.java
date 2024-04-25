package com.example.doctor.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse {
    private Long id;
    private String username;
    private List<String> position;
    private List<String> department;
    private List<String> hospital;
    private String detail;
}
