package com.example.doctor.service.iplm;

import com.example.doctor.entity.Doctor;
import com.example.doctor.repository.DoctorRepository;
import com.example.doctor.request.DoctorRequest;
import com.example.doctor.response.DoctorResponse;
import com.example.doctor.service.DoctorService;
import com.example.doctor.until.Constants;
import com.example.doctor.until.PageResultResponse;
import com.example.doctor.until.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class DoctorServiceIplm implements DoctorService {

    @Autowired
    private DoctorRepository repository;

    /**
     * findById
     *
     * @param id Long
     * @return Response
     */
    public Response findById(Long id) {
        Doctor entity = repository.findById(id).orElse(null);
        if (entity == null) {
            return Response.warning(Constants.RESPONSE_CODE.NO_RECORD, "Không tìm thấy bản ghi");
        }

        DoctorResponse response = mapToDTO(entity);
        return Response.success(
                Constants.RESPONSE_CODE.GET_DETAIL_SUCCESS,
                "Lấy chi tiết bản ghi thành công"
        ).withData(response);
    }

    /**
     * getDatatables
     *
     * @param request DoctorRequest
     * @return Response
     */
    public Response findAll(HttpServletRequest httpServletRequest, DoctorRequest request) {
        List<Doctor> entities = repository.findAll();
        return Response.success(
                Constants.RESPONSE_CODE.SUCCESS,
                "Tìm kiếm dữ liệu thành công"
        ).withData(entities);
    }

    @Override
    public Response getPages(HttpServletRequest httpServletRequest, DoctorRequest request) {
        Integer pageIndex = request.getPageIndex();
        Integer pageSize = request.getPageSize();
        int offset = (pageIndex - 1) * pageSize;

        List<Doctor> doctorEntities = repository.getDoctors(offset, pageSize);
        List<DoctorResponse> doctorResponses = doctorEntities
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        long totalElements = repository.countDoctors();
        int totalPages = (int) Math.ceil((double) totalElements / pageSize);

        // Prepare PageResultResponse
        PageResultResponse<DoctorResponse> resultResponse = new PageResultResponse<>();
        resultResponse.setContent(doctorResponses);
        resultResponse.setPageIndex(pageIndex);
        resultResponse.setPageSize(pageSize);
        resultResponse.setTotalPages(totalPages);
        resultResponse.setTotalElements(totalElements);
        resultResponse.setLast(pageIndex == totalPages);

        return Response.success(Constants.RESPONSE_CODE.SUCCESS, "Tìm kiếm dữ liệu thành công").withData(resultResponse);
    }

    private DoctorResponse mapToDTO(Doctor entity) {
        DoctorResponse response = new DoctorResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
