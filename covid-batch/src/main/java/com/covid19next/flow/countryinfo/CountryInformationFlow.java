package com.covid19next.flow.countryinfo;

import com.covid19next.client.countyinfo.CountryInformationClient;
import com.covid19next.domain.city.City;
import com.covid19next.domain.city.CityListResponse;
import com.covid19next.domain.country.Country;
import com.covid19next.domain.country.CountryBasicListRequest;
import com.covid19next.flow.BaseFlowInterface;
import com.covid19next.model.countryinfo.CountryData;
import com.covid19next.service.city.CityService;
import com.covid19next.service.country.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Component
@RequiredArgsConstructor
public class CountryInformationFlow implements BaseFlowInterface {


    private final CountryInformationClient informationClient;
    private final CountryService countryService;
    private final CityService cityService;

    public int saveDataFlow() throws Exception {
        List<Country> countries = countryService.findAllCountries();
        log.info("CovidWarningLevelService saveDataFlow : -> {}", countries);

        List<City> cityList = new ArrayList<>();
        for (Country country : countries) {

            CityListResponse cityResponseDto = getCityResponseDto(country);
            if (cityResponseDto != null) {
                for (int i = 0; i < cityResponseDto.getCount(); i++) {
                    cityList.add(City.builder()
                            .country(country)
                            .nameKr(cityResponseDto.getKorCites().get(i))
                            .nameEn(cityResponseDto.getEngCites().get(i))
                            .build());
                }
            } else continue;
        }
        return cityService.saveCities(cityList);
    }

    private CityListResponse getCityResponseDto(Country country) {
        CityListResponse cityResponseDto = new CityListResponse();
        String cities = getCountryInfo(country);
        if (cities != null) {
            cityResponseDto.setKorCites(getKorCityName(cities));
            cityResponseDto.setEngCites(getEngCityName(cities));
            cityResponseDto.setCount(cityResponseDto.getKorCites().size());
        }
        return cityResponseDto;
    }

    private String getCountryInfo(Country country) {
        String json = informationClient.getResponseData(CountryBasicListRequest.builder()
                        .numOfRows(1)
                        .pageNo(1)
                        .returnType("JSON")
                        .cond(country.getNameKr())
                        .build())
                .filter(countryInfo -> countryInfo.getTotalCount() > 0)
                .map(countryInfo -> countryInfo.getData().stream().map(CountryData::getMain_city_cn)
                        .collect(Collectors.joining())
                )
                .orElse(null);
        return json;
    }

    private static List<String> getEngCityName(String mainCities) {
        return Arrays.stream(mainCities.split("\\)"))
                .filter(s -> s.indexOf("(") > 0)
                .map(s -> s.split("\\(")[1].replaceAll("[ㄱ-힣,0-9]", "").trim())
                .collect(Collectors.toList());
    }

    private static List<String> getKorCityName(String mainCities) {
        return Arrays.stream(mainCities.split("\\)"))
                .filter(s -> s.indexOf("(") > 0)
                .map(s -> s.split("\\(")[0].replaceAll(",", "").trim())
                .collect(Collectors.toList());
    }

}
