package com.covid19next.domain.travel;

import com.covid19next.domain.city.City;
import com.covid19next.domain.country.Country;
import com.covid19next.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelCourseTest {


    @Test
    @DisplayName("이미지가 있을 때 null 체크 및 첫번쨰 이미지만들어가는지 체크")
    void testCrateImage() {
        String content = "\"<p>asfasf<img src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUg \\\"\\\\\\\" alt=\\\" /> asdsd\"";
        // GIVE
        TravelCourse travelCourse = TravelCourse.builder().courseName("코수")
                .content(content)
                .city(null).member(null).build();
        travelCourse.createImage();
        //WHEN

        //THEN
        assertTrue(travelCourse.getImage().indexOf("data:image") > -1);
    }
}