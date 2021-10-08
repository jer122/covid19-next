package com.covid19next.domain.covidlevel;

import com.covid19next.domain.covid.CovidCountryResponse;
import com.covid19next.domain.covid.restriction.RestrictionType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class CovidLevelCountryResponse {
    private Long id;
    private String code;
    private String continentName;
    private String continentNameEn;
    private String countryName;
    private String countryNameEn;
    private String imgUrl;
    private Long level;
    private String levelName;
    private Long population;
    private Long todayDeaths;
    private Long todayConfirmed;
    private LocalDateTime latestDate;
    private RestrictionType restrictionType;
    private CovidCountryResponse.CovidCountriesData covidCountriesData;

    @Builder
    public CovidLevelCountryResponse(Long id, String code, String continentName, String continentNameEn, String countryName, String countryNameEn, String imgUrl, Long level, String levelName, Long population, Long todayDeaths, Long todayConfirmed, LocalDateTime latestDate, RestrictionType restrictionType, CovidCountryResponse.CovidCountriesData covidCountriesData) {
        this.id = id;
        this.code = code;
        this.continentName = continentName;
        this.continentNameEn = continentNameEn;
        this.countryName = countryName;
        this.countryNameEn = countryNameEn;
        this.imgUrl = imgUrl;
        this.level = level;
        this.levelName = levelName;
        this.population = population;
        this.todayDeaths = todayDeaths;
        this.todayConfirmed = todayConfirmed;
        this.latestDate = latestDate;
        this.restrictionType = restrictionType;
        this.covidCountriesData = covidCountriesData;
    }
}