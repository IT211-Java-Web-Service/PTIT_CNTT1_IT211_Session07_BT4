package com.re.exceptionhandling.service;

import com.re.exceptionhandling.dto.CourseResponse;
import com.re.exceptionhandling.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CourseService {

    private final Map<Long, CourseResponse> courses = Map.of(
            1L, new CourseResponse(1L, "Spring Boot Exception Handling", "Nguyen Van A"),
            2L, new CourseResponse(2L, "Spring AOP Audit Log", "Tran Thi B")
    );

    public CourseResponse findById(Long id) {
        CourseResponse course = courses.get(id);
        if (course == null) {
            throw new ResourceNotFoundException("Course id " + id + " was not found in the learning catalog");
        }
        return course;
    }
}
