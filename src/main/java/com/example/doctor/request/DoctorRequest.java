package com.example.doctor.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequest {
    private Long id;

    private Integer pageIndex;

    private Integer pageSize;
}
