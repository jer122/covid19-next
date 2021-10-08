package com.covid19next.api.covidinfo;

import com.covid19next.domain.Result;
import com.covid19next.domain.covid.CovidContinentResponse;
import com.covid19next.domain.covid.restriction.CountryRestrictionDescription;
import com.covid19next.domain.covidlevel.CovidLevelCountryResponse;
import com.covid19next.service.covid.restriction.CovidCountryRestrictionService;
import com.covid19next.service.covidlevel.CovidWarningLevelService;
import com.covid19next.util.CustomPublicApiControllerAnnotation;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CustomPublicApiControllerAnnotation
@RestController
@RequiredArgsConstructor
public class CovidWarningLevelApiController {

    private final CovidWarningLevelService covidWarningLevelService;
    private final CovidCountryRestrictionService covidCountryRestrictionService;


    @GetMapping("/covid-level/")
    public Result covidWarningLevelV1(@RequestParam String continentName) throws JsonProcessingException {
        CovidLevelCountryResponse collect = getCovidLevelCountryResponses(continentName);

        return new Result(1, collect);
    }

    @GetMapping("/covid-level/continents")
    public ResponseEntity<CovidContinentResponse> getCountriesCovidData() throws JsonProcessingException {
        //레벨 값 고정 1~2
        List<Long> levels = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        return ResponseEntity.ok(covidWarningLevelService.findByContinentCovidLevelCountriesCovidLevel(levels));
    }

    @GetMapping("/covid-level/countries/{name}")
    public ResponseEntity<CovidLevelCountryResponse>
    getCountriesCovidData(@PathVariable String name) throws JsonProcessingException {
        //레벨 값 고정 1~2
        List<Long> levels = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        CovidLevelCountryResponse countryCovidLevelData = covidWarningLevelService.findCountryCovidLevelData(levels, name);

        return ResponseEntity.ok(countryCovidLevelData);
    }

    @GetMapping("/covid-level/country-restriction/{code}")
    public ResponseEntity<CountryRestrictionDescription> getCountryRestrictionDescription(@PathVariable String code) {
        return ResponseEntity.ok(covidCountryRestrictionService.findByCountryRestrictionDescription(code));
    }

    private CovidLevelCountryResponse getCovidLevelCountryResponses(String continentName) throws JsonProcessingException {

        List<Long> levels = new ArrayList<>(Arrays.asList(1L, 2L));
        return covidWarningLevelService.findCountryCovidLevelData(levels, continentName);
    }

}
