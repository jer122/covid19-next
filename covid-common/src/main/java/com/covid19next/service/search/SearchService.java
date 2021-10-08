package com.covid19next.service.search;

import com.covid19next.domain.Result;
import com.covid19next.domain.country.Country;
import com.covid19next.domain.country.CountryResponse;
import com.covid19next.domain.covidinfo.CovidInformationResponse;
import com.covid19next.domain.search.SearchResponse;
import com.covid19next.domain.travel.TravelCourseResponse;
import com.covid19next.service.city.CityService;
import com.covid19next.service.country.CountryService;
import com.covid19next.service.covidinfo.CovidInformationService;
import com.covid19next.service.travel.TravelCourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchService {

    private final CountryService countryService;
    private final CityService cityService;
    private final CovidInformationService covidInformationService;
    private final TravelCourseService travelCourseService;

    @Transactional(readOnly = true)
    public SearchResponse findAllByKeyword(String keyword) {
        List<CovidInformationResponse> covidInformationResponses = covidInformationService.findAllByKeyword(keyword);
        List<TravelCourseResponse> travelCourseResponses = travelCourseService.findTravelCourseByKeyword(keyword);
        List<CountryResponse> countryResponse = getCountryResponse(travelCourseResponses, keyword);

        return new SearchResponse(
                new Result<List<CountryResponse>>(countryResponse.size(), countryResponse),
                new Result<List<CovidInformationResponse>>(covidInformationResponses.size(), covidInformationResponses),
                new Result<List<TravelCourseResponse>>(travelCourseResponses.size(), travelCourseResponses));
    }

    public List<CountryResponse> getCountryResponse(List<TravelCourseResponse> travelCourseResponses, String keyword) {
        Long countryId = travelCourseResponses.stream().map(TravelCourseResponse::getCountryId)
                .findFirst()
                .orElse(null);

        if (countryId != null) {
            List<CountryResponse> countryResponses = new ArrayList<>();
            Country country = countryService.findById(countryId);
            countryResponses.add(CountryResponse.builder()
                    .countryId(country.getId())
                    .code(country.getCode())
                    .countryNameKr(country.getNameKr())
                    .countryNameEn(country.getNameEn())
                    .imgUrl(country.getImgUrl())
                    .build());
            return countryResponses;
        }
        return countryService.findNameByKeyword(keyword);

    }


}
