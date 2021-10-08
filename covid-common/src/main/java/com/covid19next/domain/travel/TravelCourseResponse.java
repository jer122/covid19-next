package com.covid19next.domain.travel;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class TravelCourseResponse {

    private Long countryId;
    private String countryName;
    private String countryNameEn;
    private Long cityId;
    private String cityName;
    private String cityNameEn;
    private Long id;
    private String courseName;
    private Long starPoint;
    private String content;
    private Long userId;
    private String displayName;
    private String image;
    private LocalDateTime createdAt;

    @Builder
    public TravelCourseResponse(Long countryId, String countryName, String countryNameEn, Long cityId, String cityName, String cityNameEn, Long travelCourseId, String courseName, Long starPoint, String content, Long userId, String displayName, String image, LocalDateTime createdAt) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryNameEn = countryNameEn;
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityNameEn = cityNameEn;
        this.id = travelCourseId;
        this.courseName = courseName;
        this.starPoint = starPoint;
        this.content = content;
        this.userId = userId;
        this.displayName = displayName;
        this.image = image;
        this.createdAt = createdAt;
    }
}
