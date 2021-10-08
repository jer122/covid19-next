package com.covid19next.domain.search;


import com.covid19next.domain.Result;
import com.covid19next.domain.country.CountryResponse;
import com.covid19next.domain.covidinfo.CovidInformationResponse;
import com.covid19next.domain.travel.TravelCourseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@NoArgsConstructor
public class SearchResponse {
    private Result<List<CountryResponse>> countries;
    private Result<List<CovidInformationResponse>> covidNews;
    private Result<List<TravelCourseResponse>> travelCourse;


    @Builder
    public SearchResponse(Result<List<CountryResponse>> countries, Result<List<CovidInformationResponse>> covidNews, Result<List<TravelCourseResponse>> travelCourse) {
        this.countries = countries;
        this.covidNews = covidNews;
        this.travelCourse = travelCourse;
    }
}
