package com.covid19next.repository.travel;

import com.covid19next.domain.travel.TravelCourse;
import com.covid19next.domain.travel.TravelCourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomTravelCourseRepository {
    public Page<TravelCourseResponse> findByTravelCourseResponse(String keyword, Pageable pageable);
}
