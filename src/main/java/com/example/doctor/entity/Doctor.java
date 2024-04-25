package com.example.doctor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private Long id;
    private String username;
    private List<String> positions;
    private List<String> departments;
    private List<String> hospitals;
    private String detail;
}
