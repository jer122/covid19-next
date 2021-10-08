package com.covid19next.service.covidlevel;

import com.covid19next.client.covid.CovidCountriesClient;
import com.covid19next.domain.Result;
import com.covid19next.domain.covid.CovidContinentResponse;
import com.covid19next.domain.covid.CovidCountryResponse;
import com.covid19next.domain.covidinfo.CovidLevelCountry;
import com.covid19next.domain.covidlevel.CovidLevelCountryResponse;
import com.covid19next.domain.covidlevel.CovidWarningLevel;
import com.covid19next.repository.covidlevel.CovidWarningLevelRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CovidWarningLevelService {

    private final CovidWarningLevelRepository warningLevelRepository;
    private final CovidCountriesClient covidCountriesClient;

    @Transactional(readOnly = true)
    public List<CovidWarningLevel> findCountryLevel(List<Long> levels) {
        return warningLevelRepository.findByLevel(levels);
    }


    @Transactional(readOnly = true)
    public CovidContinentResponse findByContinentCovidLevelCountriesCovidLevel(List<Long> levels) throws JsonProcessingException {
        List<CovidLevelCountry> byCountryCovidLevel = warningLevelRepository.findByContinentCovidLevelCountriesCovidLevel(levels);
        return getCovidContinentLevelResponses(byCountryCovidLevel);
    }

    @Transactional(readOnly = true)
    public CovidLevelCountryResponse findCountryCovidLevelData(List<Long> levels, String countryName) throws JsonProcessingException {
        CovidLevelCountry byCountryCovidLevel = warningLevelRepository.findCountryCovidLevelData(levels, countryName);
        return toResponseDto(byCountryCovidLevel, true);
    }

    //대륙별 국가 정보를 Return
    private CovidContinentResponse getCovidContinentLevelResponses(List<CovidLevelCountry> covidLevelCountries) {
        List<CovidLevelCountryResponse> africa = getExistContinentData(covidLevelCountries, "Africa");
        List<CovidLevelCountryResponse> asia = getExistContinentData(covidLevelCountries, "Asia");
        List<CovidLevelCountryResponse> europe = getExistContinentData(covidLevelCountries, "Europe");
        List<CovidLevelCountryResponse> america = getExistContinentData(covidLevelCountries, "America");
        continentSorting(africa, asia, europe, america);

        return CovidContinentResponse.builder()
                .africa(new Result<>(africa.size(), africa))
                .asia(new Result<>(asia.size(), asia))
                .europe(new Result<>(europe.size(), europe))
                .america(new Result<>(america.size(), america))
                .totalCount((long) (africa.size() + asia.size() + europe.size() + america.size()))
                .build();

    }

    //country list sorting
    private void continentSorting(List<CovidLevelCountryResponse> africa, List<CovidLevelCountryResponse> asia, List<CovidLevelCountryResponse> europe, List<CovidLevelCountryResponse> america) {
        africa.sort(Comparator.comparing(CovidLevelCountryResponse::getLevel));
        asia.sort(Comparator.comparing(CovidLevelCountryResponse::getLevel));
        europe.sort(Comparator.comparing(CovidLevelCountryResponse::getLevel));
        america.sort(Comparator.comparing(CovidLevelCountryResponse::getLevel));
    }

    private List<CovidLevelCountryResponse> getExistContinentData(List<CovidLevelCountry> covidLevelCountries, String continent) {
        return covidLevelCountries
                .stream()
                .filter(covidLevelCountry -> covidLevelCountry.getContinentNameEn().equals(continent))
                .map(covidLevelCountry -> this.toResponseDto(covidLevelCountry, false))
                .collect(Collectors.toList());
    }

    private List<CovidLevelCountryResponse> getExistCovidCountryResponses(List<CovidLevelCountry> covidLevelCountries) {
        return covidLevelCountries
                .stream()
                .map(covidLevelCountry -> this.toResponseDto(covidLevelCountry, true))
                .collect(Collectors.toList());
    }

    private CovidLevelCountryResponse toResponseDto(CovidLevelCountry covidLevelCountry, boolean useStatus) {
        return CovidLevelCountryResponse.builder()
                .id(covidLevelCountry.getCountryId())
                .code(covidLevelCountry.getCode())
                .continentName(covidLevelCountry.getContinentNameKr())
                .continentNameEn(covidLevelCountry.getContinentNameEn())
                .countryName(covidLevelCountry.getNameKr())
                .countryNameEn(covidLevelCountry.getNameEn())
                .imgUrl(covidLevelCountry.getImgUrl())
                .level(covidLevelCountry.getLevel())
                .levelName(covidLevelCountry.getLevelName())
                .population(covidLevelCountry.getPopulation())
                .todayDeaths(covidLevelCountry.getTodayDeaths())
                .todayConfirmed(covidLevelCountry.getTodayConfirmed())
                .latestDate(covidLevelCountry.getLatestDate())
                .restrictionType(covidLevelCountry.getRestrictionType())
                .covidCountriesData(getCovidCountriesApiData(covidLevelCountry, useStatus)
                )
                .build();

    }

    private CovidCountryResponse.CovidCountriesData getCovidCountriesApiData(CovidLevelCountry covidLevelCountry, boolean useStatus) {
        if (useStatus) {
            return Objects.requireNonNull(covidCountriesClient
                    .getResponseData(covidLevelCountry.getCode()).orElse(null)).getCovidCountriesData();
        }
        return null;
    }
}