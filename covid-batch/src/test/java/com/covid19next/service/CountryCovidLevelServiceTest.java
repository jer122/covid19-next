package com.covid19next.service;

import com.covid19next.domain.covid.CovidContinentResponse;
import com.covid19next.domain.covidinfo.CovidLevelCountry;
import com.covid19next.domain.covidlevel.CovidLevelCountryResponse;
import com.covid19next.domain.covidlevel.CovidWarningLevel;
import com.covid19next.service.covidlevel.CovidWarningLevelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ContextConfiguration("classpath:application.yml")
@SpringBootTest
public class CountryCovidLevelServiceTest {

    @Autowired
    CovidWarningLevelService covidWarningLevelService;


    @Test
    public void testServiceCallTest() throws JsonProcessingException {
        String continentName = "America";
        List<Long> level = new ArrayList<>(Arrays.asList(1L, 2L));

    }
}
