package com.covid19next.domain.travel;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TravelCourseListResponse {

    private Long id;
    private String courseName;
    private Long starPoint;
    private String image;
    private String userName;
    private String displayName;
    private String cityName;
    private String countryName;

    @Builder
    public TravelCourseListResponse(TravelCourse travelCourse) {
        this.id = travelCourse.getId();
        this.courseName = travelCourse.getCourseName();
        this.starPoint = travelCourse.getStarPoint();
        this.image = travelCourse.getImage();
        this.userName = travelCourse.getMember().getName();
        this.displayName = travelCourse.getMember().getDisplayName();
        this.cityName = travelCourse.getCity().getNameKr();
        this.countryName = travelCourse.getCity().getCountry().getNameKr();
    }

}
