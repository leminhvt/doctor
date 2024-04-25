package com.example.doctor.controller;

import com.example.doctor.request.DoctorRequest;
import com.example.doctor.service.DoctorService;
import com.example.doctor.until.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    /**
     * findById
     *
     * @param id Long
     * @return Response
     */
//    @Operation(
//            summary = "Conversation: API để xem chi tiết bác sĩ"
//    )
    @GetMapping(path = "/detail/{id}")
    public Response findById(@PathVariable Long id) {
        return doctorService.findById(id);
    }

    /**
     * findAll
     *
     * @param request DoctorRequest
     * @return Response
     */
//    @Operation(
//            summary = "Conversation: API để lấy danh sách bác sĩ không có phân trang"
//    )
    @PostMapping(path = "/findAll")
    public Response findAll(HttpServletRequest httpServletRequest, @RequestBody DoctorRequest request) {
        return doctorService.findAll(httpServletRequest, request);

    }

    /**
     * search
     *
     * @param request ConversationRequest
     * @return Response
     */
//    @Operation(
//            summary = "Conversation: API để lấy danh sách bác sĩ phân trang và lọc"
//    )
    @PostMapping(path = "/search")
    public Response processSearch(HttpServletRequest httpServletRequest, @RequestBody DoctorRequest request) {
        return doctorService.getPages(httpServletRequest, request);
    }

}
