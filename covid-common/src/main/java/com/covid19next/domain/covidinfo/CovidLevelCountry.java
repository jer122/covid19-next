package com.covid19next.domain.covidinfo;

import com.covid19next.domain.country.Country;
import com.covid19next.domain.covid.restriction.RestrictionType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
public class CovidLevelCountry {

    private Long countryId;
    private String code;
    private String continentNameKr;
    private String continentNameEn;
    private String nameKr;
    private String nameEn;
    private String imgUrl;
    private String country;
    private Long level;
    private String levelName;
    private Long population;
    private Long todayDeaths;
    private Long todayConfirmed;
    private LocalDateTime latestDate;
    private RestrictionType restrictionType;


    @Builder
    public CovidLevelCountry(Long countryId, String code, String continentNameKr, String continentNameEn, String nameKr, String nameEn, String imgUrl, String country, Long level, String levelName, Long population, Long todayDeaths, Long todayConfirmed, LocalDateTime latestDate, RestrictionType restrictionType) {
        this.countryId = countryId;
        this.code = code;
        this.continentNameKr = continentNameKr;
        this.continentNameEn = continentNameEn;
        this.nameKr = nameKr;
        this.nameEn = nameEn;
        this.imgUrl = imgUrl;
        this.country = country;
        this.level = level;
        this.levelName = levelName;
        this.population = population;
        this.todayDeaths = todayDeaths;
        this.todayConfirmed = todayConfirmed;
        this.latestDate = latestDate;
        this.restrictionType = restrictionType;
    }
}
