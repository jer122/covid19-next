package com.covid19next.flow.covid;

import com.covid19next.client.covid.CovidCountriesClient;
import com.covid19next.domain.country.Country;
import com.covid19next.domain.covid.CovidCountriesResponse;
import com.covid19next.domain.covid.CovidCountryResponse;
import com.covid19next.domain.covid.status.CovidStatusGlobal;
import com.covid19next.service.country.CountryService;
import com.covid19next.service.covid.status.CovidStatusGlobalService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class CovidCountriesFlow {

    private final CovidCountriesClient covidCountriesClient;
    private final CountryService countryService;
    private final CovidStatusGlobalService covidStatusGlobalService;

    public void saveCodeFlow() throws Exception {

        List<CoronaApiResponse> dataFlow = getCountryCodeData();
        for (CoronaApiResponse countryResponse : dataFlow) {
            String countryName = countryResponse.getName();
            countryService.updateCode(countryName, countryResponse.getCode());
        }
    }

    public void saveCovidStatusGlobal() throws Exception {
        List<CovidStatusGlobal> covidData = getCovidData();
        log.info("CovidCountriesFlow saveCovidStatusGlobal ->{}", covidData);
        int i = covidStatusGlobalService.covidStatusSaveAll(covidData);
//        covidStatusGlobalService.updateCountry(covidData);
        log.info("CovidCountriesFlow saveCovidStatusGlobal count ->{}", i);

    }

    public List<CoronaApiResponse> getCountryCodeData() throws Exception {
        return covidCountriesClient.getResponseData()
                .map(CovidCountriesResponse::getCovidCountriesData)
                .map(covidCountriesData -> covidCountriesData
                        .stream()
                        .map(countriesData ->
                                CoronaApiResponse.builder()
                                        .name(countriesData.getName())
                                        .code(countriesData.getCode())
                                        .build()
                        )
                        .collect(Collectors.toList())
                )
                .orElseThrow(() -> new IllegalArgumentException("데이터가 비었습니다."));
    }

    //    public List<CovidCountriesResponse.CovidCountriesData> getCovidData() throws Exception{
    public List<CovidStatusGlobal> getCovidData() throws Exception {
        return covidCountriesClient.getResponseData()
                .map(CovidCountriesResponse::getCovidCountriesData)
                .map(covidCountriesData -> covidCountriesData
                        .stream()
                        .map(countriesData ->
                                CoronaApiResponse.builder()
                                        .id((Long) Timestamp.valueOf(countriesData.getUpdatedAt()).getTime())
                                        .code(countriesData.getCode())
                                        .name(countriesData.getName())
                                        .population(countriesData.getPopulation())
                                        .todayDeaths(countriesData.getTimeLines()
                                                .stream()
                                                .map(CovidCountryResponse.TimeLine::getNewDeaths)
                                                .findFirst()
                                                .orElse(null)
                                        )
                                        .todayConfirmed(countriesData.getTimeLines()
                                                .stream()
                                                .map(CovidCountryResponse.TimeLine::getNewConfirmed)
                                                .findFirst()
                                                .orElse(null))
                                        .updatedAt(countriesData.getTimeLines().stream()
                                                .map(CovidCountryResponse.TimeLine::getUpdatedAt)
                                                .findFirst()
                                                .orElse(null))
                                        .build()
                        )
                        .map(CoronaApiResponse::toEntity)
                        .collect(Collectors.toList())
                )
                .orElseThrow(() -> new IllegalArgumentException("데이터가 비었습니다."));
    }


    @Getter
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    static class CoronaApiResponse {
        private Long id;
        private String code;
        private String name;
        private Long population;
        private Long todayConfirmed;
        private Long todayDeaths;
        private LocalDateTime updatedAt;

        @Builder
        public CoronaApiResponse(Long id, String code, String name, Long population, Long todayConfirmed, Long todayDeaths, LocalDateTime updatedAt) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.population = population;
            this.todayConfirmed = todayConfirmed;
            this.todayDeaths = todayDeaths;
            this.updatedAt = updatedAt;
        }

        public CovidStatusGlobal toEntity() {
            return CovidStatusGlobal.builder()
                    .statusGlobalId(CovidStatusGlobal.CovidStatusGlobalId.builder()
                            .id(id)
                            .code(code)
                            .build())
                    .updatedAt(updatedAt)
                    .countryName(name)
                    .population(population)
                    .todayDeaths(todayDeaths)
                    .todayConfirmed(todayConfirmed)
                    .build();
        }
    }

    static class Coordinates {
        private Long latitude;
        private Long longitude;
    }

    static class LatestData {
        private Long deaths;
        private Long confirmed;
        private Long recovered;
        private Long critical;
    }

    static class Calculated {
        private Double deathRate;
        private Double recoveryRate;
        private Double recoveredVsDeathRatio;
        private Long casesPerMillionPopulation;
    }


}
