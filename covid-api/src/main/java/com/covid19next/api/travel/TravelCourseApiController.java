package com.covid19next.api.travel;


import com.covid19next.domain.Result;
import com.covid19next.domain.travel.*;
import com.covid19next.domain.travel.TravelCourseListResponse;
import com.covid19next.domain.travel.TravelCourseRequest;
import com.covid19next.service.travel.TravelCourseService;
import com.covid19next.util.CustomPublicApiControllerAnnotation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CustomPublicApiControllerAnnotation
@RestController
@RequiredArgsConstructor
public class TravelCourseApiController {

    private final TravelCourseService travelCourseService;

    @GetMapping("/travel-course")
    public Result getTravelCourseList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        Page<TravelCourseListResponse> allTravelCourse = travelCourseService.findAllTravelCourse(request);
        return new Result(allTravelCourse.getContent().size(), allTravelCourse.getContent());
    }

    @GetMapping("/travel-course/{course_id}")
    public TravelCourseResponse getTravelCourse(@PathVariable("course_id") Long id) {
        TravelCourse travelCourse = travelCourseService.findTravelCourse(id);

        return TravelCourseResponse.builder()
                .travelCourseId(travelCourse.getId())
                .courseName(travelCourse.getCourseName())
                .starPoint(travelCourse.getStarPoint())
                .userId(travelCourse.getMember().getMemberId())
                .displayName(travelCourse.getMember().getDisplayName())
                .content(travelCourse.getContent())
                .cityName(travelCourse.getCity().getNameKr())
                .cityId(travelCourse.getCity().getId())
                .countryName(travelCourse.getCity().getCountry().getNameKr())
                .createdAt(travelCourse.getCreatedAt())
                .build();
    }

    @PostMapping("/travel-course")
    public Long save(@RequestBody @Valid TravelCourseRequest request) {
        return travelCourseService.save(request);
    }

    @PutMapping("/travel-course/{course_id}")
    public TravelCourseResponse updateTravelCourse(@PathVariable("course_id") Long id, @RequestBody TravelCourseRequest request) {
        return travelCourseService.update(id, request);
    }

    @DeleteMapping("/travel-course/{course_id}")
    public Long deleteTravelCourse(@PathVariable("course_id") Long id) {
        return travelCourseService.delete(id);
    }

    @PutMapping("/travel-course/point/{course_id}")
    public Long updateStarPoint(@PathVariable("course_id") Long id,
                                @RequestBody @Valid StarPointRequest starPoint) {
        return travelCourseService.updateStarPoint(id, starPoint);
    }
}
