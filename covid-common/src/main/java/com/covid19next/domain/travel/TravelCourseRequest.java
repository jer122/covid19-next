package com.covid19next.domain.travel;


import com.covid19next.domain.city.City;
import com.covid19next.domain.member.Member;
import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class TravelCourseRequest {
    private String courseName;
    private String content;
    @NotNull(message = "사용자 정보가 누락되었습니다.")
    private Long userId;
    @NotNull(message = "도시 정보가 누락되었습니다.")
    private Long cityId;
    private String image;

    @Builder
    public TravelCourseRequest(String courseName, String content, Long userId, Long cityId) {
        this.courseName = courseName;
        this.content = content;
        this.userId = userId;
        this.cityId = cityId;
    }

    public TravelCourse toEntity(City city, Member member) {
        return TravelCourse.builder()
                .courseName(courseName)
                .content(content)
                .starPoint(0L)
                .city(city)
                .member(member)
                .build();
    }
}
